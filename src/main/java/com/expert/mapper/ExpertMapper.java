package com.expert.mapper;

import com.expert.entity.Expert;
import com.expert.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpertMapper implements RowMapper<Expert> {
    @Override
    public Expert mapRow(ResultSet resultSet, int i) throws SQLException {
        Expert expert = new Expert();
        expert.setId(resultSet.getInt("id"));
        expert.setName(resultSet.getString("name"));
        expert.setEmail(resultSet.getString("email"));
        expert.setPassword(resultSet.getString("password"));
        expert.setOrganizationCode(resultSet.getString("organizationcode"));
        expert.setScore(resultSet.getDouble("score"));
        return expert;
    }
}
