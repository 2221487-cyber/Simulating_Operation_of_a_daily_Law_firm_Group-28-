package com.project.sec3_2221869_project;

import java.util.ArrayList;
import java.util.List;

public class CaseFile {
    private String Id;
    private String clientId;
    private String caseName;
    private String staus;
    private String managingLawyerID;
    private List<String> associateDocuments = new ArrayList<>();

    public String getId() {
        return Id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getCaseName() {
        return caseName;
    }

    public String getStaus() {
        return staus;
    }

    public String getManagingLawyerID() {
        return managingLawyerID;
    }

    public List<String> getAssociateDocuments() {
        return associateDocuments;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setStaus(String staus) {
        this.staus = staus;
    }

    public void setManagingLawyerID(String managingLawyerID) {
        this.managingLawyerID = managingLawyerID;
    }

    public void setAssociateDocuments(List<String> associateDocuments) {
        this.associateDocuments = associateDocuments;
    }

    @Override
    public String toString() {
        return "CaseFile{" +
                "Id='" + Id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", caseName='" + caseName + '\'' +
                ", staus='" + staus + '\'' +
                ", managingLawyerID='" + managingLawyerID + '\'' +
                ", associateDocuments=" + associateDocuments +
                '}';
    }

    public CaseFile(String id, String clientId, String caseName, String staus, String managingLawyerID, List<String> associateDocuments) {
        Id = id;
        this.clientId = clientId;
        this.caseName = caseName;
        this.staus = staus;
        this.managingLawyerID = managingLawyerID;
        this.associateDocuments = associateDocuments;
    }
}
