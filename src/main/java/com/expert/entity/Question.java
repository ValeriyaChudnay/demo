package com.expert.entity;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;
    private int projectId;
    private String text;
    private double scoreAverage;
    private double scoreSelfMult;
    private double kvartil;
    private double lowTrust;
    private double hightTrust;

    public Question() {

    }

    public Question(int id, int projectId, String text, double scoreAverage, double scoreSelfMult, double kvartil, double lowTrust, double hightTrust) {
        this.id = id;
        this.projectId = projectId;
        this.text = text;
        this.scoreAverage = scoreAverage;
        this.scoreSelfMult = scoreSelfMult;
        this.kvartil = kvartil;
        this.lowTrust = lowTrust;
        this.hightTrust = hightTrust;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public double getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(double scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public double getScoreSelfMult() {
        return scoreSelfMult;
    }

    public void setScoreSelfMult(double scoreSelfMult) {
        this.scoreSelfMult = scoreSelfMult;
    }

    public double getKvartil() {
        return kvartil;
    }

    public void setKvartil(double kvartil) {
        this.kvartil = kvartil;
    }

    public double getLowTrust() {
        return lowTrust;
    }

    public void setLowTrust(double lowTrust) {
        this.lowTrust = lowTrust;
    }

    public double getHightTrust() {
        return hightTrust;
    }

    public void setHightTrust(double hightTrust) {
        this.hightTrust = hightTrust;
    }
}
