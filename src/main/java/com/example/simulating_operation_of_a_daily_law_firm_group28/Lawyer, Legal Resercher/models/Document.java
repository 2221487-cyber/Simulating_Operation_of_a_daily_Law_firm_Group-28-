package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;

import java.time.LocalDate;

public class Document {
    private String documentId;
    private String name;
    private String type;
    private LocalDate uploadDate;
    private String caseId;

    public Document() {
        this.uploadDate = LocalDate.now();
    }

    public Document(String documentId, String name, String type, String caseId) {
        this();
        this.documentId = documentId;
        this.name = name;
        this.type = type;
        this.caseId = caseId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }
}

