package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

import java.time.LocalDate;

public class CashFlow {
    private String cashFlowId;
    private LocalDate date;
    private double income;
    private double expense;
    private double netCash;

    public CashFlow(String cashFlowId, LocalDate date, double income, double expense, double netCash) {
        this.cashFlowId = cashFlowId;
        this.date = date;
        this.income = income;
        this.expense = expense;
        this.netCash = netCash;
    }

    public String getCashFlowId() {
        return cashFlowId;
    }

    public void setCashFlowId(String cashFlowId) {
        this.cashFlowId = cashFlowId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public double getNetCash() {
        return netCash;
    }

    public void setNetCash(double netCash) {
        this.netCash = netCash;
    }

    @Override
    public String toString() {
        return "CashFlow{" +
                "cashFlowId='" + cashFlowId + '\'' +
                ", date=" + date +
                ", income=" + income +
                ", expense=" + expense +
                ", netCash=" + netCash +
                '}';
    }
}
