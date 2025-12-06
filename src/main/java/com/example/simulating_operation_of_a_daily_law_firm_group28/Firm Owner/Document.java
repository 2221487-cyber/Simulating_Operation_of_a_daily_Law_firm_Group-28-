package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import java.time.LocalDateTime;

public class Document {
    private String Id;
    private String caseID;
    private String fileName;
    private String fileType;
    private String storagePath;
    private LocalDateTime uploadDateTime;
    private String approvalStatus;

    public Document(String id, String caseID, String fileName, String fileType, String storagePath, LocalDateTime uploadDateTime, String approvalStatus) {
        Id = id;
        this.caseID = caseID;
        this.fileName = fileName;
        this.fileType = fileType;
        this.storagePath = storagePath;
        this.uploadDateTime = uploadDateTime;
        this.approvalStatus = approvalStatus;
    }

    public String getId() {
        return Id;
    }

    public String getCaseID() {
        return caseID;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public LocalDateTime getUploadDateTime() {
        return uploadDateTime;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public void setUploadDateTime(LocalDateTime uploadDateTime) {
        this.uploadDateTime = uploadDateTime;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "Document{" +
                "Id='" + Id + '\'' +
                ", caseID='" + caseID + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", storagePath='" + storagePath + '\'' +
                ", uploadDateTime=" + uploadDateTime +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }
}
