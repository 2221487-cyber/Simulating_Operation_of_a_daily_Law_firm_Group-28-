package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import java.time.LocalDateTime;

public class TimeEntry {
    private String clientId;
    private String caseNo;
    private String lawyerId;
    private String caseId;
    private LocalDateTime entryDateTime;
    private String description;
    private boolean isBilled;

    public String getLawyerId() {
        return lawyerId;
    }

    public String getclientId() {
        return clientId;
    }

    public String getcaseNo() {
        return caseNo;
    }

    public String getCaseId() {
        return caseId;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBilled() {
        return isBilled;
    }

    public void setEntryDateTime(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public void setclientId(String clientid) {
        clientId = clientid;
    }

    public void setcaseNo(String caseNo) {
        caseNo = caseNo;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBilled(boolean billed) {
        isBilled = billed;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "clientId='" + clientId + '\'' +
                "caseNo='" + caseNo + '\'' +
                ", lawyerId='" + lawyerId + '\'' +
                ", caseId='" + caseId + '\'' +
                ", entryDateTime=" + entryDateTime +
                ", description='" + description + '\'' +
                ", isBilled=" + isBilled +
                '}';
    }

    public TimeEntry(String clientid, String caseNo,  String lawyerId, String caseId, LocalDateTime entryDateTime, String description, boolean isBilled) {
        this.clientId = clientid;
        this.caseNo = caseNo;
        this.lawyerId = lawyerId;
        this.caseId = caseId;
        this.entryDateTime = entryDateTime;
        this.description = description;
        this.isBilled = isBilled;
    }
}
