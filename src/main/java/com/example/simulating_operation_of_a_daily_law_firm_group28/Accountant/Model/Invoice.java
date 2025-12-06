package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

import java.util.List;

public class Invoice {
    private String invoiceId;
    private Client client;
    private List<Service> services;
    private double discount; // percentage
    private double tax; // percentage
    private double totalAmount;

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", client=" + client +
                ", services=" + services +
                ", discount=" + discount +
                ", tax=" + tax +
                ", totalAmount=" + totalAmount +
                '}';
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Invoice(String invoiceId, Client client, List<Service> services, double discount, double tax, double totalAmount) {
        this.invoiceId = invoiceId;
        this.client = client;
        this.services = services;
        this.discount = discount;
        this.tax = tax;
        this.totalAmount = totalAmount;
    }
}
