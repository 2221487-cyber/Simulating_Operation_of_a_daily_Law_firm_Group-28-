package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

public class Service {
    private String serviceName;
    private double hours;
    private double rate;

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", hours=" + hours +
                ", rate=" + rate +
                '}';
    }

    public Service(String serviceName, double hours, double rate) {
        this.serviceName = serviceName;
        this.hours = hours;
        this.rate = rate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
