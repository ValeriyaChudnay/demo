package com.expert.service;

import com.expert.dao.ProjectDao;
import com.expert.dao.QuestionDao;
import com.expert.entity.Project;
import com.expert.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionService implements QuestionServiceInf {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public int save(Question q) {
        return questionDao.save(q);
    }

    @Override
    public List<Question> getQuestionByProjectId(int projectId) {
        return questionDao.getQuestionByProjectId(projectId);
    }

    @Override
    public void update(Question question) {
        questionDao.update(question);
    }

    @Override
    public void removeQuestionsByProjectId(int id) {
        questionDao.removeQuestionsByProjectId(id);
    }
}
