package com.expert.entity;

import java.util.List;

public class MAI {
    private String[] criteriaName;
    private String[] alternameName;
    private double[][] criteria;
    private double[] wCriteria;
    private List<Criteria> alterantes;
    private int alternate;

    public int getAlternate() {
        return alternate;
    }

    public void setAlternate(int alternate) {
        this.alternate = alternate;
    }

    public String[] getCriteriaName() {
        return criteriaName;
    }

    public void setCriteriaName(String[] criteriaName) {
        this.criteriaName = criteriaName;
    }

    public String[] getAlternameName() {
        return alternameName;
    }

    public void setAlternameName(String[] alternameName) {
        this.alternameName = alternameName;
    }

    public double[][] getCriteria() {
        return criteria;
    }

    public void setCriteria(double[][] criteria) {
        this.criteria = criteria;
    }

    public double[] getwCriteria() {
        return wCriteria;
    }

    public void setwCriteria(double[] wCriteria) {
        this.wCriteria = wCriteria;
    }

    public List<Criteria> getAlterantes() {
        return alterantes;
    }

    public void setAlterantes(List<Criteria> alterantes) {
        this.alterantes = alterantes;
    }
}
