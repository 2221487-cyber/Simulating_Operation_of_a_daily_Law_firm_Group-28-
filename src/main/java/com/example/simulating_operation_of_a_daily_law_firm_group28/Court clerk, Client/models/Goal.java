package com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.models;

public class Goal {
    private String id;
    private String title;
    private String description;
    private String status;
    private String clientId;
    private int goalNumber;

    public Goal() {
        this.status = "Pending";
    }

    public Goal(String id, String title, String description, String clientId, int goalNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.clientId = clientId;
        this.goalNumber = goalNumber;
        this.status = "Pending";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getGoalNumber() {
        return goalNumber;
    }

    public void setGoalNumber(int goalNumber) {
        this.goalNumber = goalNumber;
    }
}
