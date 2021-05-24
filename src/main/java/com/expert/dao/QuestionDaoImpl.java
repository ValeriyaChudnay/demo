package com.expert.dao;

import com.expert.entity.Question;
import com.expert.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Question q) {
        String sql = "  INSERT INTO public.\"Question\"(projectId, text)VALUES ( ?, ?)  RETURNING id;";
        int questionId = jdbcTemplate.queryForObject(sql, new Object[]{q.getProjectId(), q.getText()}, Integer.class);
        return questionId;
    }

    @Override
    public List<Question> getQuestionByProjectId(int projectId) {
        String sql = "select * from public.\"Question\" where projectid=?";
        List<Question> questions = jdbcTemplate.query(sql, new QuestionMapper(), projectId);
        return questions;
    }

    @Override
    public void update(Question q) {
        String sql = "UPDATE public.\"Question\" SET  scoreaverage=?, scoreselfmult=?, kvartil=? WHERE id=?;";
        jdbcTemplate.update(sql,q.getScoreAverage(),q.getScoreSelfMult(),q.getKvartil(),q.getId());
    }

    @Override
    public void removeQuestionsByProjectId(int id) {
       String sql="DELETE FROM public.\"Question\" WHERE projectid=?;";
       jdbcTemplate.update(sql,id);
    }
}
