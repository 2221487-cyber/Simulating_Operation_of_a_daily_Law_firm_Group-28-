package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import java.time.LocalDate;


public class CaseArchiveManager {
    private int caseId;
    private String caseName;
    private String clientName;
    private LocalDate caseClosedDate;
    private String status; // OPEN, CLOSED, ARCHIVED
    private int documentCount;
    private boolean allDocumentsFinalized;
    private LocalDate archiveDate;
    private String archiveLocation;

    public CaseArchiveManager() {
        this.status = "OPEN";
        this.allDocumentsFinalized = false;
    }

    public CaseArchiveManager(int caseId, String caseName, String clientName) {
        this();
        this.caseId = caseId;
        this.caseName = caseName;
        this.clientName = clientName;
    }


    public boolean areAllDocumentsFinalized() {
        return allDocumentsFinalized;
    }


    public void closeCase() {
        this.status = "CLOSED";
        this.caseClosedDate = LocalDate.now();
    }


    public void archiveCase(String archiveLocation) throws IllegalStateException {
        if (!allDocumentsFinalized) {
            throw new IllegalStateException(
                "Cannot archive case. Not all documents are finalized.");
        }
        this.status = "ARCHIVED";
        this.archiveDate = LocalDate.now();
        this.archiveLocation = archiveLocation;
    }


    public String getCaseSummary() {
        return String.format(
            "Case Archive Information\n" +
            "Case ID: %d\n" +
            "Case Name: %s\n" +
            "Client: %s\n" +
            "Status: %s\n" +
            "Documents: %d\n" +
            "Closed Date: %s\n" +
            "Archive Location: %s",
            caseId, caseName, clientName, status, documentCount,
            caseClosedDate, archiveLocation != null ? archiveLocation : "Not archived"
        );
    }

    // Getters and Setters
    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getCaseClosedDate() {
        return caseClosedDate;
    }

    public void setCaseClosedDate(LocalDate caseClosedDate) {
        this.caseClosedDate = caseClosedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(int documentCount) {
        this.documentCount = documentCount;
    }

    public boolean isAllDocumentsFinalized() {
        return allDocumentsFinalized;
    }

    public void setAllDocumentsFinalized(boolean allDocumentsFinalized) {
        this.allDocumentsFinalized = allDocumentsFinalized;
    }

    public LocalDate getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(LocalDate archiveDate) {
        this.archiveDate = archiveDate;
    }

    public String getArchiveLocation() {
        return archiveLocation;
    }

    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }
}
