package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

public class BillableItem {
    private String serviceName;
    private double hours;
    private double rate;
    private double fee;
    private double total;

    public BillableItem(String serviceName, double hours, double rate, double fee) {
        this.serviceName = serviceName;
        this.hours = hours;
        this.rate = rate;
        this.fee = fee;
        this.total = (hours * rate) + fee;
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
        updateTotal();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        updateTotal();
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
        updateTotal();
    }

    public double getTotal() {
        return total;
    }

    private void updateTotal() {
        this.total = (hours * rate) + fee;
    }

    @Override
    public String toString() {
        return "BillableItem{" +
                "serviceName='" + serviceName + '\'' +
                ", hours=" + hours +
                ", rate=" + rate +
                ", fee=" + fee +
                ", total=" + total +
                '}';
    }
}
