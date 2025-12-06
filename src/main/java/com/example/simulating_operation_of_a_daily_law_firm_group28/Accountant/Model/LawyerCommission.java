package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

public class LawyerCommission {
    private String lawyerId;
    private String lawyerName;
    private double commissionPercentage;
    private double totalBilled;
    private double commissionAmount;

    public LawyerCommission(String lawyerId, String lawyerName, double commissionPercentage, double totalBilled, double commissionAmount) {
        this.lawyerId = lawyerId;
        this.lawyerName = lawyerName;
        this.commissionPercentage = commissionPercentage;
        this.totalBilled = totalBilled;
        this.commissionAmount = commissionAmount;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    public String getLawyerName() {
        return lawyerName;
    }

    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public double getTotalBilled() {
        return totalBilled;
    }

    public void setTotalBilled(double totalBilled) {
        this.totalBilled = totalBilled;
    }

    public double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    @Override
    public String toString() {
        return "LawyerCommission{" +
                "lawyerId='" + lawyerId + '\'' +
                ", lawyerName='" + lawyerName + '\'' +
                ", commissionPercentage=" + commissionPercentage +
                ", totalBilled=" + totalBilled +
                ", commissionAmount=" + commissionAmount +
                '}';
    }
}
