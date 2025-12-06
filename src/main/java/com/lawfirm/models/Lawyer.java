package com.lawfirm.models;

public class Lawyer {
    private String username;

    public Lawyer() {
        this.username = "CourtAlert";
    }

    public Lawyer(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
