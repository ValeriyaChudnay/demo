package com.expert.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DelfiTempoparyData implements Serializable {
    private int expertCount;
    private List<Integer> expertsIdPassed = new ArrayList<>();
    private double sumGroupSelfScore;
    private Map<Integer, Double> sumScoreForQuestion = new HashMap<>(); // сумма оценки всех эксертов по вопросу
    private Map<Integer, Double> ScoreMulSelfRef = new HashMap<>();//сумма оценка эксперта умноженная на ту оценку которую он поставил
    private Map<Integer, Double>  minScore = new HashMap<>();
    private Map<Integer, Double>  maxScore = new HashMap<>();
    private List<Question> questions;

    public DelfiTempoparyData() {
    }

    public DelfiTempoparyData(int expertCount, List<Integer> expertsIdPassed, double sumGroupSelfScore, Map<Integer, Double> sumScoreForQuestion, Map<Integer, Double> scoreMulSelfRef, Map<Integer, Double> minScore, Map<Integer, Double> maxScore, List<Question> questions) {
        this.expertCount = expertCount;
        this.expertsIdPassed = expertsIdPassed;
        this.sumGroupSelfScore = sumGroupSelfScore;
        this.sumScoreForQuestion = sumScoreForQuestion;
        ScoreMulSelfRef = scoreMulSelfRef;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.questions = questions;
    }

    public List<Integer> getExpertsIdPassed() {
        return expertsIdPassed;
    }

    public void setExpertsIdPassed(List<Integer> expertsIdPassed) {
        this.expertsIdPassed = expertsIdPassed;
    }

    public double getSumGroupSelfScore() {
        return sumGroupSelfScore;
    }

    public void setSumGroupSelfScore(double sumGroupSelfScore) {
        this.sumGroupSelfScore = sumGroupSelfScore;
    }

    public int getExpertCount() {
        return expertCount;
    }

    public void setExpertCount(int expertCount) {
        this.expertCount = expertCount;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Map<Integer, Double> getSumScoreForQuestion() {
        return sumScoreForQuestion;
    }

    public void setSumScoreForQuestion(Map<Integer, Double> sumScoreForQuestion) {
        this.sumScoreForQuestion = sumScoreForQuestion;
    }

    public Map<Integer, Double> getScoreMulSelfRef() {
        return ScoreMulSelfRef;
    }

    public void setScoreMulSelfRef(Map<Integer, Double> scoreMulSelfRef) {
        ScoreMulSelfRef = scoreMulSelfRef;
    }

    public Map<Integer, Double> getMinScore() {
        return minScore;
    }

    public void setMinScore(Map<Integer, Double> minScore) {
        this.minScore = minScore;
    }

    public Map<Integer, Double> getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Map<Integer, Double> maxScore) {
        this.maxScore = maxScore;
    }
}
