package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

public class ClientInfo {
    private String clientId;
    private String name;
    private String contact;
    private String caseType;
    private String lawyer;

    public ClientInfo(String clientId, String name, String contact, String caseType, String lawyer) {
        this.clientId = clientId;
        this.name = name;
        this.contact = contact;
        this.caseType = caseType;
        this.lawyer = lawyer;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getLawyer() {
        return lawyer;
    }

    public void setLawyer(String lawyer) {
        this.lawyer = lawyer;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", caseType='" + caseType + '\'' +
                ", lawyer='" + lawyer + '\'' +
                '}';
    }
}
