package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

public class FinancialReport {
    private String category;
    private double amount;

    public FinancialReport(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                '}';
    }
}
