package com.expert.service;

import com.expert.entity.Question;

import java.util.List;

public interface QuestionServiceInf {
    int save(Question q);

    List<Question> getQuestionByProjectId(int projectId);

    void update(Question question);

    void removeQuestionsByProjectId(int id);
}
