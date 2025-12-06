package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

public class ClientRegistration {
    private String clientId;
    private String clientName;
    private String contactNumber;
    private String caseType;
    private String preferredLawyer;

    public ClientRegistration(String clientId, String clientName, String contactNumber, String caseType, String preferredLawyer) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactNumber = contactNumber;
        this.caseType = caseType;
        this.preferredLawyer = preferredLawyer;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getPreferredLawyer() {
        return preferredLawyer;
    }

    public void setPreferredLawyer(String preferredLawyer) {
        this.preferredLawyer = preferredLawyer;
    }

    @Override
    public String toString() {
        return "ClientRegistration{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", caseType='" + caseType + '\'' +
                ", preferredLawyer='" + preferredLawyer + '\'' +
                '}';
    }
}
