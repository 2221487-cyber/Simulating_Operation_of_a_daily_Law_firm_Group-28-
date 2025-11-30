package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

public class Client_Info {
    private String name;
    private String contact;
    private String casetype;

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

    public String getCasetype() {
        return casetype;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    @Override
    public String toString() {
        return "Client_Info{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", casetype='" + casetype + '\'' +
                '}';
    }

    public Client_Info(String name, String contact, String casetype) {
        this.name = name;
        this.contact = contact;
        this.casetype = casetype;


    }
}
