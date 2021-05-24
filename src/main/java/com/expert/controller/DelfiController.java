package com.expert.controller;

import com.expert.entity.DelfiTempoparyData;
import com.expert.entity.Expert;
import com.expert.entity.Project;
import com.expert.entity.Question;
import com.expert.service.ExpertService;
import com.expert.service.ProjectService;
import com.expert.service.QuestionService;
import com.sun.net.httpserver.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static com.expert.controller.ExpertController.CURRENT_PROJECT;

@Controller
public class DelfiController {


    public static final String EXPERT = "expert";
    public static final String DELFI_DATA = "delfiData";
    private final ExpertService expertService;
    private final ProjectService projectService;
    private final QuestionService questionService;


    @Autowired
    public DelfiController(ExpertService expertService, ProjectService projectService, QuestionService questionService) {
        this.expertService = expertService;
        this.projectService = projectService;
        this.questionService = questionService;
    }


    @GetMapping("/endDelfiChat")
    public String endDelfiChat(@RequestParam("questionNumber") String qNumber, Model model, HttpSession session) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        projectService.updateDelfiEtap(1, project.getId());
        model.addAttribute("questionNumber", Integer.parseInt(qNumber));
        return "createAnketa";
    }

    @PostMapping("/createAnketa")
    public String createAnketa(@RequestParam Map<String, String> questionsMap, HttpSession session) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        List<Question> questions = new ArrayList<>();
        for (String value : questionsMap.values()) {
            Question q = new Question();
            q.setText(value);
            q.setProjectId(project.getId());
            int questionId = questionService.save(q);
            q.setId(questionId);
            questions.add(q);
        }
        DelfiTempoparyData delfiTempoparyData = new DelfiTempoparyData();
        List<Expert> experts = expertService.getExpertsByProjectId(project.getId());
        int expertCount = experts.size();
        double selfSum = 0;
        for (Expert expert : experts) {
            selfSum += expert.getScore();
        }
        delfiTempoparyData.setExpertCount(expertCount);
        delfiTempoparyData.setSumGroupSelfScore(selfSum);
        delfiTempoparyData.setQuestions(questions);
        projectService.updateDelfiEtap(2, project.getId());
        projectService.getDtd().put(project.getId(), delfiTempoparyData);
        return "redirect:" + "project/" + project.getId();
    }

    @GetMapping("/getDelfiAnketa")
    public String getDelfiAnketa(Model model, HttpSession session) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        List<Question> questions = questionService.getQuestionByProjectId(project.getId());
        model.addAttribute("questions", questions);
        return "delfiAnketa";
    }

    @PostMapping("/delfiAnketa")
    public String submitDelfiAnketa(@RequestParam Map<String, String> params, HttpSession session) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        DelfiTempoparyData dtd = (DelfiTempoparyData) projectService.getDtd().get(project.getId());
        Expert expert = (Expert) session.getAttribute(EXPERT);
        Map<Integer, Double> sumScore = dtd.getSumScoreForQuestion();
        Map<Integer, Double> scoreMulSelf = dtd.getScoreMulSelfRef();
        Map<Integer, Double> maxScore = dtd.getMaxScore();
        Map<Integer, Double> minScore = dtd.getMinScore();
        for (Map.Entry<String, String> questionScore : params.entrySet()) {
            Integer key = Integer.valueOf(questionScore.getKey());
            Double score = sumScore.get(key);
            score = score == null ? 0 : score;
            double scoreValue = Integer.parseInt(questionScore.getValue());
            double value = score + scoreValue;
            sumScore.put(key, value);

            score = scoreMulSelf.get(key);
            score = score==null?0:score;
            scoreMulSelf.put(key,expert.getScore()*scoreValue+score);

            Double max = maxScore.get(key);
            max = max==null?0:max;
            if(max<scoreValue){
                maxScore.put(key,scoreValue);
            }

            Double min = minScore.get(key);
            min = min==null?100:min;
            if(min>scoreValue){
                minScore.put(key,scoreValue);
            }
        }
        dtd.setExpertCount(dtd.getExpertCount()-1);
        dtd.getExpertsIdPassed().add(expert.getId());
        if(dtd.getExpertCount()==0){
            projectService.updateDelfiEtap(3,project.getId());
            countDelfiData(dtd);
            projectService.saveDelfiResult(dtd,project.getId(),project.getCurrentRound());
        }

        return "redirect:/project/"+project.getId();
    }

    private void countDelfiData(DelfiTempoparyData dtd) {
        List<Question> questions = dtd.getQuestions();
        for (Question question : questions) {
            double scoreAverage = round(dtd.getSumScoreForQuestion().get(question.getId()) / dtd.getExpertsIdPassed().size());
            question.setScoreAverage(scoreAverage);
            double scoreSelfMult = round(dtd.getScoreMulSelfRef().get(question.getId()) / dtd.getSumGroupSelfScore());
            question.setScoreSelfMult(scoreSelfMult);
            double kvartil = round((dtd.getMaxScore().get(question.getId()) - dtd.getMinScore().get(question.getId())) / 4);
            question.setKvartil(kvartil);
            double lowTrust = dtd.getMinScore().get(question.getId()) + question.getKvartil();
            question.setLowTrust(lowTrust);
            double hightTrust = dtd.getMaxScore().get(question.getId()) - question.getKvartil();
            question.setHightTrust(hightTrust);
        }
        dtd.setQuestions(questions);
        for (Question question : questions) {
            questionService.update(question);
        }
    }


    @GetMapping("/delfiChat")
    public String delfiChat(HttpSession session) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        Expert expert = (Expert) session.getAttribute(EXPERT);
        boolean isAdmin = project.getAdminExpertId() == expert.getId();
        session.setAttribute("isAdmin", isAdmin);
        return "delfiChat";
    }
    @GetMapping("/delfiResult")
    public String delfiResult(HttpSession session,Model model,@RequestParam("round") int round) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        DelfiTempoparyData dtd = projectService.getDelfiResult(project.getId(),round);

        model.addAttribute("questions",dtd.getQuestions());
        model.addAttribute("groupRef",dtd.getSumGroupSelfScore()/dtd.getExpertsIdPassed().size());
        Expert expert = (Expert) session.getAttribute(EXPERT);
        return "delfiResult";
    }

    @GetMapping("/endDelfiProject")
    public String endDelfiProject(HttpSession session,Model model) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        projectService.endProject(project.getId());
        project.setEnd(true);
        return "redirect:/";
    }

    @GetMapping("/newRoundProject")
    public String newRoundDelfi(HttpSession session,Model model) {
        Project project = (Project) session.getAttribute(CURRENT_PROJECT);
        projectService.updateDelfiEtap(0,project.getId());
        questionService.removeQuestionsByProjectId(project.getId());
        projectService.updateDelfiRound(project.getCurrentRound()+1,project.getId());
        session.removeAttribute(String.valueOf(project.getId()));
        return "redirect:/project/"+project.getId();
    }

    private static double round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
