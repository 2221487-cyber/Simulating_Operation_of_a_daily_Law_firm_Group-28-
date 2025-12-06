package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;

public class Precedent {
    private String precedentId;
    private String title;
    private String summary;
    private String court;
    private int year;

    public Precedent() {
    }

    public Precedent(String precedentId, String title, String summary, String court, int year) {
        this.precedentId = precedentId;
        this.title = title;
        this.summary = summary;
        this.court = court;
        this.year = year;
    }

    public String getPrecedentId() {
        return precedentId;
    }

    public void setPrecedentId(String precedentId) {
        this.precedentId = precedentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

