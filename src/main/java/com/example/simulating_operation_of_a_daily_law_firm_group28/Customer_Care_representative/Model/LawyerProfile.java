package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

public class LawyerProfile {
    private String lawyerId;
    private String name;
    private String expertise;
    private String available;

    public LawyerProfile(String lawyerId, String name, String expertise, String available) {
        this.lawyerId = lawyerId;
        this.name = name;
        this.expertise = expertise;
        this.available = available;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "LawyerProfile{" +
                "lawyerId='" + lawyerId + '\'' +
                ", name='" + name + '\'' +
                ", expertise='" + expertise + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
