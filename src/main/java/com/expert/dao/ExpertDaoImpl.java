package com.expert.dao;

import com.expert.entity.Expert;
import com.expert.entity.Project;
import com.expert.mapper.ExpertMapper;
import com.expert.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;

public class ExpertDaoImpl implements ExpertDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ExpertDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Expert> findAll() {
        //todo тут запрос всех юзеров + джоин проекты имя и ид
        String sql = "select * from public.\"Expert\"";
        return jdbcTemplate.query(sql, new ExpertMapper());
    }

    @Override
    public Expert getExpertByEmail(String email) {
        String sql = "select * from public.\"Expert\" where  email=? ";
        Expert expert = null;
        expert = jdbcTemplate.queryForObject(sql, new Object[]{email}, new ExpertMapper());
        return expert;
    }

    @Override
    public Expert createExpert(String email, String password, String score, String name, String organizationCode) {
        String sql = "INSERT INTO public.\"Expert\"(name, password, email, score, organizationcode) VALUES (?, ?, ?, ?, ?) RETURNING id;";
        Expert expert = new Expert();
        expert.setPassword(password);
        expert.setEmail(email);
        expert.setName(name);
        expert.setOrganizationCode(organizationCode);
        double d = Integer.parseInt(score);
        expert.setScore(d);
        int expertId  =jdbcTemplate.queryForObject(sql, new Object[]{expert.getName(), expert.getPassword(), expert.getEmail(), expert.getScore(), expert.getOrganizationCode()},Integer.class);
        expert.setId(expertId);
        return expert;
    }

    @Override
    public List<Expert> getExpertsByProjectId(int id) {
        String sql = "SELECT * FROM public.\"Expert\"  JOIN public.\"Project_Expert\" ON public.\"Expert\".id = public.\"Project_Expert\".expertid where  public.\"Project_Expert\".projectid=?";
        List<Expert> experts = jdbcTemplate.query(sql,new ExpertMapper(),id);
        return experts;
    }

    @Override
    public List<Expert> getExpertsByOrganization(String organizationCode) {
        String sql = "SELECT * FROM public.\"Expert\" where organizationcode=?";
        List<Expert> experts = jdbcTemplate.query(sql,new ExpertMapper(),organizationCode);
        return experts;
    }

}
