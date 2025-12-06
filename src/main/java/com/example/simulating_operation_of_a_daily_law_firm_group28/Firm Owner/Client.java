package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

public class Client {
    private String id;
    private String name;
    private String contactAddress;
    private String email;
    private String phoneNumber;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
