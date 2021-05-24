package com.expert.dao;

import com.expert.entity.Project;

import java.util.List;

public interface ProjectDao {

    List<Project> findAll();

    List<Project> getProjectsAdmin(int id);

    List<Project> getProjectsMember(int id);

    Project getProjectById(int projectId);

    void updateDelfiEtap(int etap,int projectId);

    int save(Project project);

    void saveDelfiResult(int id, int currentRound, String json);

    String getDelfiResult(int id, int round);

    void endProject(int id);

    void addConectionExpertProject(int expertId, int projectId);

    void updateDelfiRound(int delfiround, int id);
}
