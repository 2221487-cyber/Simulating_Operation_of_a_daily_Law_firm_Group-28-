package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResearchRecord {
    private String recordId;
    private String topic;
    private List<String> keywords;
    private List<String> references;
    private String summary;
    private LocalDate createdDate;

    public ResearchRecord() {
        this.keywords = new ArrayList<>();
        this.references = new ArrayList<>();
        this.createdDate = LocalDate.now();
    }

    public ResearchRecord(String recordId, String topic, String summary) {
        this();
        this.recordId = recordId;
        this.topic = topic;
        this.summary = summary;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}

