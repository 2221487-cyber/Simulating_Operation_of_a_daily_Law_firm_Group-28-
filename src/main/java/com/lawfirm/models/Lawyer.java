package com.lawfirm.models;

import java.util.ArrayList;
import java.util.List;

public class Lawyer extends User {
    private String barId;
    private List<CaseFile> cases;
    private List<Client> clients;

    public Lawyer() {
        super();
        this.cases = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public Lawyer(String name, String email, String password, String barId) {
        super(name, email, password, "Lawyer");
        this.barId = barId;
        this.cases = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public List<CaseFile> getCases() {
        return cases;
    }

    public void setCases(List<CaseFile> cases) {
        this.cases = cases;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

