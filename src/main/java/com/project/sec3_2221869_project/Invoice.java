package com.project.sec3_2221869_project;

import java.time.LocalDate;

public class Invoice {
    private String Id;
    private String caseID;
    private String clientID;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private long totalAmountDueInCents;
    private long totalTaxAmountInCents;
    private long totalHoursBilledInMinutes;
    private String paymentStatus;

    public String getId() {
        return Id;
    }

    public String getCaseID() {
        return caseID;
    }

    public String getClientID() {
        return clientID;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public long getTotalAmountDueInCents() {
        return totalAmountDueInCents;
    }

    public long getTotalTaxAmountInCents() {
        return totalTaxAmountInCents;
    }

    public long getTotalHoursBilledInMinutes() {
        return totalHoursBilledInMinutes;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setTotalAmountDueInCents(long totalAmountDueInCents) {
        this.totalAmountDueInCents = totalAmountDueInCents;
    }

    public void setTotalTaxAmountInCents(long totalTaxAmountInCents) {
        this.totalTaxAmountInCents = totalTaxAmountInCents;
    }

    public void setTotalHoursBilledInMinutes(long totalHoursBilledInMinutes) {
        this.totalHoursBilledInMinutes = totalHoursBilledInMinutes;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "Id='" + Id + '\'' +
                ", caseID='" + caseID + '\'' +
                ", clientID='" + clientID + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", totalAmountDueInCents=" + totalAmountDueInCents +
                ", totalTaxAmountInCents=" + totalTaxAmountInCents +
                ", totalHoursBilledInMinutes=" + totalHoursBilledInMinutes +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }

    public Invoice(String id, String caseID, String clientID, LocalDate invoiceDate, LocalDate dueDate, long totalAmountDueInCents, long totalTaxAmountInCents, long totalHoursBilledInMinutes, String paymentStatus) {
        Id = id;
        this.caseID = caseID;
        this.clientID = clientID;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.totalAmountDueInCents = totalAmountDueInCents;
        this.totalTaxAmountInCents = totalTaxAmountInCents;
        this.totalHoursBilledInMinutes = totalHoursBilledInMinutes;
        this.paymentStatus = paymentStatus;
    }
}
