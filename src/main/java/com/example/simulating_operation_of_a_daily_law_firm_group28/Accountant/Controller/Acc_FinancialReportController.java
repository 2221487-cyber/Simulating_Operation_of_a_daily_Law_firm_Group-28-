package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.FinancialReport;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class Acc_FinancialReportController
{
    @javafx.fxml.FXML
    private TableView<FinancialReport> reportDataTable;
    @javafx.fxml.FXML
    private DatePicker reportEndDatePicker;
    @javafx.fxml.FXML
    private DatePicker reportStartDatePicker;
    @javafx.fxml.FXML
    private TextArea reportSummaryArea;
    @javafx.fxml.FXML
    private Button generateReportBtn;
    @javafx.fxml.FXML
    private Button clearReportBtn;
    @javafx.fxml.FXML
    private ChoiceBox<String> reportTypeChoiceBox;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport, Double> reportAmountCol;
    @javafx.fxml.FXML
    private TableColumn<FinancialReport, String> reportCategoryCol;

    private ObservableList<FinancialReport> reportList = FXCollections.observableArrayList();
    private ObservableList<FinancialReport> allReports = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {

        reportCategoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        reportAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        

        reportTypeChoiceBox.getItems().addAll("Income Statement", "Balance Sheet", "Cash Flow", "All Reports");
        reportTypeChoiceBox.setValue("All Reports");

        reportStartDatePicker.setValue(LocalDate.now().minusMonths(1));
        reportEndDatePicker.setValue(LocalDate.now());
        

        loadAllReports();
    }

    private void loadAllReports() {
        try {
            allReports.clear();
            allReports.addAll(AccountantStorage.loadFinancialReports());
            

            if (allReports.isEmpty()) {

                allReports.add(new FinancialReport("Legal Fees Revenue", 250000));
                allReports.add(new FinancialReport("Consultation Revenue", 80000));
                allReports.add(new FinancialReport("Salaries Expense", -120000));
                allReports.add(new FinancialReport("Office Rent Expense", -30000));
                allReports.add(new FinancialReport("Utilities Expense", -5000));
                

                allReports.add(new FinancialReport("Cash Assets", 150000));
                allReports.add(new FinancialReport("Accounts Receivable", 75000));
                allReports.add(new FinancialReport("Office Equipment", 50000));
                allReports.add(new FinancialReport("Accounts Payable", -40000));
                allReports.add(new FinancialReport("Long-term Debt", -100000));
                

                allReports.add(new FinancialReport("Operating Cash Flow", 180000));
                allReports.add(new FinancialReport("Investing Cash Flow", -50000));
                allReports.add(new FinancialReport("Financing Cash Flow", -30000));

                for (FinancialReport report : allReports) {
                    AccountantStorage.saveFinancialReport(report);
                }
            }
        } catch (IOException e) {
            reportSummaryArea.setText("Error loading reports: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void generateReport(ActionEvent actionEvent) {
        String reportType = reportTypeChoiceBox.getValue();
        LocalDate startDate = reportStartDatePicker.getValue();
        LocalDate endDate = reportEndDatePicker.getValue();
        

        if (reportType == null || reportType.isEmpty()) {
            reportSummaryArea.setText("Error: Please select a report type");
            return;
        }
        
        if (startDate == null || endDate == null) {
            reportSummaryArea.setText("Error: Please select both start and end dates");
            return;
        }
        
        if (startDate.isAfter(endDate)) {
            reportSummaryArea.setText("Error: Start date must be before end date");
            return;
        }
        

        reportList.clear();

        if (reportType.equals("All Reports")) {
            reportList.addAll(allReports);
        } else if (reportType.equals("Income Statement")) {
            for (FinancialReport report : allReports) {
                if (report.getCategory().contains("Revenue") ||
                    report.getCategory().contains("Expense") ||
                    report.getCategory().contains("Income")) {
                    reportList.add(report);
                }
            }
        } else if (reportType.equals("Balance Sheet")) {
            for (FinancialReport report : allReports) {
                if (report.getCategory().contains("Assets") ||
                    report.getCategory().contains("Receivable") ||
                    report.getCategory().contains("Equipment") ||
                    report.getCategory().contains("Payable") ||
                    report.getCategory().contains("Debt")) {
                    reportList.add(report);
                }
            }
        } else if (reportType.equals("Cash Flow")) {
            for (FinancialReport report : allReports) {
                if (report.getCategory().contains("Cash Flow")) {
                    reportList.add(report);
                }
            }
        }
        
        // Update table
        reportDataTable.setItems(reportList);
        
        // Calculate and display summary
        generateSummary(reportType, startDate, endDate);
    }
    
    private void generateSummary(String reportType, LocalDate startDate, LocalDate endDate) {
        double total = 0.0;
        double positive = 0.0;
        double negative = 0.0;
        
        for (FinancialReport report : reportList) {
            total += report.getAmount();
            if (report.getAmount() > 0) {
                positive += report.getAmount();
            } else {
                negative += report.getAmount();
            }
        }
        
        StringBuilder summary = new StringBuilder();
        summary.append("Report Type: ").append(reportType).append("\n");
        summary.append("Period: ").append(startDate).append(" to ").append(endDate).append("\n");
        summary.append("Total Items: ").append(reportList.size()).append("\n");
        summary.append(String.format("Total Income/Assets: %.2f\n", positive));
        summary.append(String.format("Total Expenses/Liabilities: %.2f\n", negative));
        summary.append(String.format("Net Total: %.2f", total));
        
        reportSummaryArea.setText(summary.toString());
    }
    
    @javafx.fxml.FXML
    public void clearReport(ActionEvent actionEvent) {
        reportList.clear();
        reportDataTable.setItems(reportList);
        reportSummaryArea.clear();
        reportTypeChoiceBox.setValue("All Reports");
        reportStartDatePicker.setValue(LocalDate.now().minusMonths(1));
        reportEndDatePicker.setValue(LocalDate.now());
    }
}