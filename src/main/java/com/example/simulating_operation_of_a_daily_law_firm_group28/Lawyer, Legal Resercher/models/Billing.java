package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models;

import java.time.LocalDate;

public class Billing {
    private String billingId;
    private String caseId;
    private double totalBilling;
    private double amountPaid;
    private LocalDate billingDate;
    private String description;

    public Billing() {
        this.billingDate = LocalDate.now();
    }

    public Billing(String billingId, String caseId, double totalBilling) {
        this();
        this.billingId = billingId;
        this.caseId = caseId;
        this.totalBilling = totalBilling;
        this.amountPaid = 0.0;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public double getTotalBilling() {
        return totalBilling;
    }

    public void setTotalBilling(double totalBilling) {
        this.totalBilling = totalBilling;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getRemainingBalance() {
        return totalBilling - amountPaid;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

