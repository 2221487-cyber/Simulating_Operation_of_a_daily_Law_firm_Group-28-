package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

import java.time.LocalDate;

public class Payment {
    private String paymentId;
    private String clientId;
    private double amount;
    private String paymentMethod;
    private LocalDate paymentDate;
    private String invoiceNumber;

    public Payment(String paymentId, String clientId, double amount, String paymentMethod, LocalDate paymentDate, String invoiceNumber) {
        this.paymentId = paymentId;
        this.clientId = clientId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
    }
}
