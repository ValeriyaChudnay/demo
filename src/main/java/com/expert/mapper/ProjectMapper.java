package com.expert.mapper;

import com.expert.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setAdminExpertId(resultSet.getInt("expertid"));
        project.setDelfietap(resultSet.getInt("delfietap"));
        project.setDescription(resultSet.getString("description"));
        project.setCurrentRound(resultSet.getInt("currentround"));
        project.setEnd(resultSet.getBoolean("isend"));
        project.setTrust(resultSet.getInt("trust"));
        return project;
    }
}
