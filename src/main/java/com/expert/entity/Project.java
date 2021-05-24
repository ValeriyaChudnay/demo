package com.expert.entity;

import java.util.List;

public class Project {
    private int id;
    private int delfietap;
    private String name;
    private int adminExpertId;
    private List<Method> methods;
    private String description;
    private int currentRound;
    private boolean end;
    private double trust;

    public double getTrust() {
        return trust;
    }

    public void setTrust(double trust) {
        this.trust = trust;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public int getAdminExpertId() {
        return adminExpertId;
    }

    public void setAdminExpertId(int adminExpertId) {
        this.adminExpertId = adminExpertId;
    }

    public int getDelfietap() {
        return delfietap;
    }

    public void setDelfietap(int delfietap) {
        this.delfietap = delfietap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound = currentRound;
    }
}
