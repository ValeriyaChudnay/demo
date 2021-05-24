package com.expert.service;

import com.expert.dao.ProjectDao;
import com.expert.entity.DelfiTempoparyData;
import com.expert.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectServiceInf {
    List<Project> getProjectsAdmin(int id);

    ProjectDao getProjectDao();

    void setProjectDao(ProjectDao projectDao);

    List<Project> getProjectsMember(int id);

    Project getProjectById(int projectId);

    void updateDelfiEtap(int i, int projectId);

    int save(Project project);

    void saveDelfiResult(DelfiTempoparyData dtd, int id, int currentRound);

    DelfiTempoparyData getDelfiResult(int id, int round);

    void endProject(int id);

    void addConectionExpertProject(int expertId, int projectId);

    Map<Integer, DelfiTempoparyData> getDtd();

    void setDtd(Map<Integer, DelfiTempoparyData> dtd);

    void updateDelfiRound(int delfiround, int id);
}
