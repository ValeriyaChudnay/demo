package com.expert.mapper;

import com.expert.entity.Expert;
import com.expert.entity.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        Question q=new Question();
        q.setId(resultSet.getInt("id"));
        q.setText(resultSet.getString("text"));
        q.setScoreAverage(resultSet.getDouble("scoreaverage"));
        q.setScoreSelfMult(resultSet.getDouble("scoreselfmult"));
        q.setKvartil(resultSet.getDouble("kvartil"));
        q.setProjectId(resultSet.getInt("projectId"));
        return q;
    }
}
