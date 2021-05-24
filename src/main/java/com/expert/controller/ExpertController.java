package com.expert.controller;

import com.expert.entity.DelfiTempoparyData;
import com.expert.entity.Expert;
import com.expert.entity.Project;
import com.expert.entity.Question;
import com.expert.service.ExpertService;
import com.expert.service.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class ExpertController {

    public static final String CURRENT_PROJECT = "currentProject";
    public static final String EXPERT = "expert";
    private final ExpertService expertService;
    private final ProjectService projectService;


    @Autowired
    public ExpertController(ExpertService expertService,ProjectService projectService) {
        this.expertService = expertService;
        this.projectService = projectService;
    }

    @GetMapping("/experts")
    public String getAllExperts(Model model) {
        model.addAttribute("users", expertService.findAll());
        return "experts";
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sign-up")
    public String signUpView() {
        return "sign-up";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(EXPERT);
        session.removeAttribute(CURRENT_PROJECT);
        return "redirect:/";
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestParam("email") String email, @RequestParam("password") String password,
                         @RequestParam("score") String score, @RequestParam("name") String name, @RequestParam("organizationCode") String organizationCode, HttpSession session) {
       Expert expert= expertService.createExpert(email,password,score,name,organizationCode);
        session.setAttribute(EXPERT, expert);
        return "redirect:" + "profile/"+expert.getId();
    }

    @PostMapping("/sign-in")
    public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session,Model model) {
        Expert expert = expertService.getExpertByEmailAndPassword(email, password);
        String redirect = "redirect:/?alert=true";
        if (Objects.nonNull(expert)) {
            List<Project> adminProject=projectService.getProjectsAdmin(expert.getId());
            List<Project> memberProject=projectService.getProjectsMember(expert.getId());
            model.addAttribute("admins",adminProject);
            model.addAttribute("members",memberProject);
            redirect = "redirect:" + "profile/" + expert.getId();
            session.setAttribute(EXPERT, expert);
        }
        return redirect;
    }

    @GetMapping("/profile/{expertId}")
    public String profile(Model model,@PathVariable("expertId") String expertId) {
        int id = Integer.parseInt(expertId);
        List<Project> adminProject=projectService.getProjectsAdmin(id);
        List<Project> memberProject=projectService.getProjectsMember(id);
        model.addAttribute("admins",adminProject);
        model.addAttribute("members",memberProject);
        return "profile";
    }

    @GetMapping("/faqs")
    public String faqsView() {
        return "faqs";
    }

    @GetMapping("/about")
    public String aboutView() {
        return "about";
    }

    @GetMapping("/project/{projectId}")
    public String project(HttpSession session, @PathVariable("projectId") Integer projectId, Model model) {
            Project project = projectService.getProjectById(projectId);
        session.setAttribute(CURRENT_PROJECT, project);
        Expert expert = (Expert) session.getAttribute(EXPERT);
        boolean isAdmin = project.getAdminExpertId() == expert.getId();
        if(isAdmin){
            List<Expert> experts = expertService.getExpertsByProjectId(projectId);
            model.addAttribute("experts",experts);
        }
        DelfiTempoparyData dtd =projectService.getDtd().get(projectId);
        if(Objects.nonNull(dtd)){
        model.addAttribute("expertsIdPassed",dtd.getExpertsIdPassed());
        }
        session.setAttribute("isAdmin",isAdmin);
        return "project";
    }

    @GetMapping("/project/create")
    public String createProjectView(HttpSession session,Model model) {
        Expert admin = (Expert) session.getAttribute(EXPERT);
        List<Expert> experts = expertService.getExpertsByOrganization(admin.getOrganizationCode());
        model.addAttribute("experts",experts);
        return "createProject";
    }

    @PostMapping("/project/create")
    public String createProject(@RequestParam Map<String,String> projectInfo,@RequestParam("experts") String[] experts,HttpSession session) {
        Expert expert = (Expert) session.getAttribute(EXPERT);
        Project project = new Project();
        project.setDescription(projectInfo.get("description"));
        project.setName(projectInfo.get("name"));
        project.setTrust(Double.parseDouble(projectInfo.get("trust")));
        project.setAdminExpertId(expert.getId());
        project.setId(projectService.save(project));
        for (String s : experts) {
            projectService.addConectionExpertProject(Integer.parseInt(s),project.getId());
        }
        return "redirect:/project/"+project.getId();
    }

    @GetMapping("/saveDTD")
    public String saveDtd() throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.writeValue(new File("target/dtd.json"), projectService.getDtd());
       return "redirect:/";
    }
    @GetMapping("/restoreDTD")
    public String restorDtd() throws IOException {
        ObjectMapper om = new ObjectMapper();
        projectService.setDtd(om.readValue(new File("target/dtd.json"),Map.class));
        return "redirect:/";
    }



}
