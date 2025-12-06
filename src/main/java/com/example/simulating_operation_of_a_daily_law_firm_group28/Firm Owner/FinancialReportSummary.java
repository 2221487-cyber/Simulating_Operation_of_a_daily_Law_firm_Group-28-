package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import java.time.LocalDate;

public class FinancialReportSummary {
    private String Id;
    private LocalDate startDate;
    private LocalDate endDate;
    private long totalRevenueInCents;
    private long totalExpensesInCents;
    private long netProfitLossInCents;
    private long totalBillableHoursInMinutes;
    private int totalActiveCases;
    private long averageBillableRateInCentsPerHour;
    private String profitLossBreakdown;


    public String getId() {
        return Id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getTotalRevenueInCents() {
        return totalRevenueInCents;
    }

    public long getTotalExpensesInCents() {
        return totalExpensesInCents;
    }

    public long getNetProfitLossInCents() {
        return netProfitLossInCents;
    }

    public long getTotalBillableHoursInMinutes() {
        return totalBillableHoursInMinutes;
    }

    public int getTotalActiveCases() {
        return totalActiveCases;
    }

    public long getAverageBillableRateInCentsPerHour() {
        return averageBillableRateInCentsPerHour;
    }

    public String getProfitLossBreakdown() {
        return profitLossBreakdown;
    }

    @Override
    public String toString() {
        return "FinancialReportSummary{" +
                "Id='" + Id + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalRevenueInCents=" + totalRevenueInCents +
                ", totalExpensesInCents=" + totalExpensesInCents +
                ", netProfitLossInCents=" + netProfitLossInCents +
                ", totalBillableHoursInMinutes=" + totalBillableHoursInMinutes +
                ", totalActiveCases=" + totalActiveCases +
                ", averageBillableRateInCentsPerHour=" + averageBillableRateInCentsPerHour +
                ", profitLossBreakdown='" + profitLossBreakdown + '\'' +
                '}';
    }

    public FinancialReportSummary(String id, LocalDate startDate, LocalDate endDate, long totalRevenueInCents, long totalExpensesInCents, long netProfitLossInCents, long totalBillableHoursInMinutes, int totalActiveCases, long averageBillableRateInCentsPerHour, String profitLossBreakdown) {
        Id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalRevenueInCents = totalRevenueInCents;
        this.totalExpensesInCents = totalExpensesInCents;
        this.netProfitLossInCents = netProfitLossInCents;
        this.totalBillableHoursInMinutes = totalBillableHoursInMinutes;
        this.totalActiveCases = totalActiveCases;
        this.averageBillableRateInCentsPerHour = averageBillableRateInCentsPerHour;
        this.profitLossBreakdown = profitLossBreakdown;

    }
}
