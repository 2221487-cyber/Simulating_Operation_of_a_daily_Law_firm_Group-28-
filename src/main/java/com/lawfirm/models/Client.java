package com.lawfirm.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private List<CaseFile> caseHistory;

    public Client() {
        this.caseHistory = new ArrayList<>();
    }

    public Client(String clientId, String name, String email, String phone, String address) {
        this();
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CaseFile> getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(List<CaseFile> caseHistory) {
        this.caseHistory = caseHistory;
    }
}

