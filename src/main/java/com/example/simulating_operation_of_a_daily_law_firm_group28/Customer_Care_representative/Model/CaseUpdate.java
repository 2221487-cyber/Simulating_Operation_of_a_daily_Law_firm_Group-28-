package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

import java.time.LocalDate;

public class CaseUpdate {
    private String caseId;
    private String clientId;
    private String remarks;
    private String lawyerId;
    private LocalDate hearingDate;
    private String caseStatus;

    public CaseUpdate(String caseId, String clientId, String remarks, String lawyerId, LocalDate hearingDate, String caseStatus) {
        this.caseId = caseId;
        this.clientId = clientId;
        this.remarks = remarks;
        this.lawyerId = lawyerId;
        this.hearingDate = hearingDate;
        this.caseStatus = caseStatus;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    public LocalDate getHearingDate() {
        return hearingDate;
    }

    public void setHearingDate(LocalDate hearingDate) {
        this.hearingDate = hearingDate;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    @Override
    public String toString() {
        return "CaseUpdate{" +
                "caseId='" + caseId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", remarks='" + remarks + '\'' +
                ", lawyerId='" + lawyerId + '\'' +
                ", hearingDate=" + hearingDate +
                ", caseStatus='" + caseStatus + '\'' +
                '}';
    }
}
