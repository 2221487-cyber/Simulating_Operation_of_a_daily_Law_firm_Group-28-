package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;

import java.util.ArrayList;
import java.util.List;

public class LegalResearcher extends User {
    private String employeeId;
    private List<ResearchRecord> researchRecords;
    private List<Precedent> savedPrecedents;

    public LegalResearcher() {
        super();
        this.researchRecords = new ArrayList<>();
        this.savedPrecedents = new ArrayList<>();
    }

    public LegalResearcher(String name, String email, String password, String employeeId) {
        super(name, email, password, "LegalResearcher");
        this.employeeId = employeeId;
        this.researchRecords = new ArrayList<>();
        this.savedPrecedents = new ArrayList<>();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<ResearchRecord> getResearchRecords() {
        return researchRecords;
    }

    public void setResearchRecords(List<ResearchRecord> researchRecords) {
        this.researchRecords = researchRecords;
    }

    public List<Precedent> getSavedPrecedents() {
        return savedPrecedents;
    }

    public void setSavedPrecedents(List<Precedent> savedPrecedents) {
        this.savedPrecedents = savedPrecedents;
    }
}

