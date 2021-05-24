package com.expert.dao;

import com.expert.entity.Project;
import com.expert.mapper.ProjectMapper;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class ProjectDaoImpl implements ProjectDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> findAll() {
        String sql = "select * from public.\"Project\"";
        return jdbcTemplate.query(sql,new ProjectMapper());
    }

    @Override
    public List<Project> getProjectsAdmin(int adminId) {
        String sql = "select * from public.\"Project\" where expertid=?";
        List<Project> projects = jdbcTemplate.query(sql,new ProjectMapper(),adminId);
        return projects;
    }

    @Override
    public List<Project> getProjectsMember(int id) {
        String sql = "SELECT * FROM public.\"Project\"  JOIN public.\"Project_Expert\" ON public.\"Project\".id = public.\"Project_Expert\".projectid where  public.\"Project_Expert\".expertid=?";
        List<Project> projects = jdbcTemplate.query(sql,new ProjectMapper(),id);
        return projects;
    }

    @Override
    public Project getProjectById(int projectId) {
        String sql = "select * from public.\"Project\" where id=?";
        Project project = jdbcTemplate.queryForObject(sql,new ProjectMapper(),projectId);
        return project;
    }

    @Override
    public void updateDelfiEtap(int etap,int projectId) {
        String sql = "UPDATE public.\"Project\"  SET  delfietap=?  WHERE id=?";
        jdbcTemplate.update(sql,etap,projectId);
    }

    @Override
    public int save(Project project) {
        String sql="INSERT INTO public.\"Project\"( name, expertid, description,trust) VALUES (?, ?, ?,?)  RETURNING id;";
        return jdbcTemplate.queryForObject(sql, new Object[]{project.getName(),project.getAdminExpertId(),project.getDescription(),project.getTrust()},Integer.class);
    }

    @Override
    public void saveDelfiResult(int id, int currentRound, String json) {
        String sql = "INSERT INTO public.\"DelfiRoundResult\"(projectid,round,data)VALUES (?, ?,?::JSON);";
        jdbcTemplate.update(sql,id,currentRound,json);
    }

    @Override
    public String getDelfiResult(int id, int round) {
        String sql = "SELECT data FROM public.\"DelfiRoundResult\" where projectid=? and round=?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql,id,round);
        return result.get(0).get("data").toString();
    }

    @Override
    public void endProject(int id) {
        String sql = "UPDATE public.\"Project\"  SET  isend=true  WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void addConectionExpertProject(int expertId, int projectId) {
        String sql = "INSERT INTO public.\"Project_Expert\"( expertid, projectid) VALUES (?, ?);";
        jdbcTemplate.update(sql,expertId,projectId);
    }

    @Override
    public void updateDelfiRound(int delfiround, int id) {
        String sql = "UPDATE public.\"Project\"  SET  currentround=?  WHERE id=?";
        jdbcTemplate.update(sql,delfiround,id);
    }
}
