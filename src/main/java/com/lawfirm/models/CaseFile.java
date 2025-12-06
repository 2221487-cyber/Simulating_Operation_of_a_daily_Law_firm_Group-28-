package com.lawfirm.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CaseFile {
    private String caseId;
    private String title;
    private String type;
    private Client client;
    private String description;
    private String status; // "Open", "In Progress", "Closed"
    private LocalDate hearingDate;
    private List<Document> documents;
    private boolean isClosed;

    public CaseFile() {
        this.documents = new ArrayList<>();
        this.status = "Open";
        this.isClosed = false;
    }

    public CaseFile(String caseId, String title, String type, Client client, String description) {
        this();
        this.caseId = caseId;
        this.title = title;
        this.type = type;
        this.client = client;
        this.description = description;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public LocalDate getHearingDate() {
        return hearingDate;
    }

    public void setHearingDate(LocalDate hearingDate) {
        this.hearingDate = hearingDate;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
        if (closed) {
            this.status = "Closed";
        }
    }
}

