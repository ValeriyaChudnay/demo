package com.expert.service;

import com.expert.dao.ProjectDao;
import com.expert.entity.DelfiTempoparyData;
import com.expert.entity.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectService implements ProjectServiceInf {

    @Autowired
    private ProjectDao projectDao;
    private Map<Integer,DelfiTempoparyData> dtd = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<Project> getProjectsAdmin(int id) {
        return projectDao.getProjectsAdmin(id) ;
    }

    @Override
    public ProjectDao getProjectDao() {
        return projectDao;
    }

    @Override
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getProjectsMember(int id) {
        return projectDao.getProjectsMember(id);
    }

    @Override
    public Project getProjectById(int projectId) {
        return projectDao.getProjectById(projectId);
    }

    @Override
    public void updateDelfiEtap(int i, int projectId) {
         projectDao.updateDelfiEtap(i,projectId);
    }

    @Override
    public int save(Project project) {
        return projectDao.save(project);
    }

    @Override
    public void saveDelfiResult(DelfiTempoparyData dtd, int id, int currentRound) {
        try {
            String json= objectMapper.writeValueAsString(dtd);
            projectDao.saveDelfiResult(id,currentRound,json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DelfiTempoparyData getDelfiResult(int id, int round) {
        String json = projectDao.getDelfiResult(id,round);
        DelfiTempoparyData dtd = null;
        try {
            dtd = objectMapper.readValue(json, DelfiTempoparyData.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return dtd;
    }

    @Override
    public void endProject(int id) {
        projectDao.endProject(id);
    }

    @Override
    public void addConectionExpertProject(int expertId, int projectId) {
        projectDao.addConectionExpertProject( expertId, projectId);
    }

    @Override
    public Map<Integer, DelfiTempoparyData> getDtd() {
        return dtd;
    }

    @Override
    public void setDtd(Map<Integer, DelfiTempoparyData> dtd) {
        this.dtd = dtd;
    }

    @Override
    public void updateDelfiRound(int delfiround, int id) {
        projectDao.updateDelfiRound(delfiround,id);
    }
}
