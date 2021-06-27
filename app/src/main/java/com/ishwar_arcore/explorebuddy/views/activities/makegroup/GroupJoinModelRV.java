package com.ishwar_arcore.explorebuddy.views.activities.makegroup;
public class GroupJoinModelRV {

    private String id;
    private String budget;
    private String place;
    private String plan;
    private String prefer;
    private String travel;

    public GroupJoinModelRV() {
    }

    public GroupJoinModelRV(String id, String budget, String place, String plan, String prefer, String travel) {
        this.id = id;
        this.budget = budget;
        this.place = place;
        this.plan = plan;
        this.prefer = prefer;
        this.travel = travel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPrefer() {
        return prefer;
    }

    public void setPrefer(String prefer) {
        this.prefer = prefer;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }
}
