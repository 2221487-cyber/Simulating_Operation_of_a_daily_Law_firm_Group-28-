package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

import java.time.LocalDate;

public class OutstandingBalance {
    private String clientId;
    private String clientName;
    private double amountDue;
    private LocalDate dueDate;
    private String status;

    public OutstandingBalance(String clientId, String clientName, double amountDue, LocalDate dueDate, String status) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.amountDue = amountDue;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OutstandingBalance{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", amountDue=" + amountDue +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
