package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.LawyerCommission;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;

public class Acc_LawyerCommissionController
{
    @javafx.fxml.FXML
    private Button lawyerCommissionBtn;
    @javafx.fxml.FXML
    private TextField lawyerIdField;
    @javafx.fxml.FXML
    private Label commissionAmountLabel;
    @javafx.fxml.FXML
    private Button verifyLawyerCasesBtn;
    @javafx.fxml.FXML
    private TextField commissionPercentageField;
    @javafx.fxml.FXML
    private Button calculateCommissionBtn;
    @javafx.fxml.FXML
    private Label commissionConfirmationLabel;
    @javafx.fxml.FXML
    private Label commissionStatusLabel;
    @javafx.fxml.FXML
    private TextField commissionResultField;
    @javafx.fxml.FXML
    private TableView<LawyerCommission> commissionTable;
    @javafx.fxml.FXML
    private TableColumn<LawyerCommission, String> lawyerIdCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerCommission, String> lawyerNameCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerCommission, Double> percentageCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerCommission, Double> totalBilledCol;
    @javafx.fxml.FXML
    private TableColumn<LawyerCommission, Double> commissionAmountCol;

    private ObservableList<LawyerCommission> commissionList = FXCollections.observableArrayList();
    private double totalBilled = 0;

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        lawyerIdCol.setCellValueFactory(new PropertyValueFactory<>("lawyerId"));
        lawyerNameCol.setCellValueFactory(new PropertyValueFactory<>("lawyerName"));
        percentageCol.setCellValueFactory(new PropertyValueFactory<>("commissionPercentage"));
        totalBilledCol.setCellValueFactory(new PropertyValueFactory<>("totalBilled"));
        commissionAmountCol.setCellValueFactory(new PropertyValueFactory<>("commissionAmount"));
        
        commissionAmountLabel.setText("0.00");
        
        // Load existing commissions from storage
        loadCommissions();
    }
    
    private void loadCommissions() {
        try {
            commissionList.clear();
            commissionList.addAll(AccountantStorage.loadCommissions());
            commissionTable.setItems(commissionList);
            commissionStatusLabel.setText("Loaded " + commissionList.size() + " commission records");
        } catch (IOException e) {
            commissionStatusLabel.setText("Ready to calculate commission");
        }
    }

    @javafx.fxml.FXML
    public void verifyLawyerCases(ActionEvent actionEvent) {
        String lawyerId = lawyerIdField.getText();
        if (lawyerId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter Lawyer ID");
            return;
        }
        // Simulate verification - in real app, query database
        totalBilled = 50000 + Math.random() * 50000;
        commissionConfirmationLabel.setText("Verified: Total billed $" + String.format("%.2f", totalBilled));
    }

    @javafx.fxml.FXML
    public void calculateCommission(ActionEvent actionEvent) {
        try {
            String lawyerId = lawyerIdField.getText();
            String percentageStr = commissionPercentageField.getText();

            if (lawyerId.isEmpty() || percentageStr.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
                return;
            }

            double percentage = Double.parseDouble(percentageStr);
            double commissionAmount = (totalBilled * percentage) / 100;

            commissionAmountLabel.setText(String.format("%.2f", commissionAmount));
            commissionConfirmationLabel.setText("Commission calculated successfully");

            LawyerCommission commission = new LawyerCommission(lawyerId, "Lawyer Name", percentage, totalBilled, commissionAmount);
            
            // Save to file storage
            try {
                AccountantStorage.saveCommission(commission);
                loadCommissions(); // Refresh table
                commissionResultField.setText(String.format("%.2f", commissionAmount));
                commissionStatusLabel.setText("Commission calculated and saved!");
                showAlert(Alert.AlertType.INFORMATION, "Success", "Commission: $" + String.format("%.2f", commissionAmount));
            } catch (IOException e) {
                commissionStatusLabel.setText("Failed to save commission: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid percentage value");
        }
    }

    @javafx.fxml.FXML
    public void selectLawyerCommission(ActionEvent actionEvent) {
        commissionConfirmationLabel.setText("Ready to calculate commission");
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}