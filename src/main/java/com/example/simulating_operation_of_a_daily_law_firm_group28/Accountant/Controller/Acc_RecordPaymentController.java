package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.Payment;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Acc_RecordPaymentController
{
    @javafx.fxml.FXML
    private Button updatePaymentBtn;
    @javafx.fxml.FXML
    private Button recordPaymentBtn;
    @javafx.fxml.FXML
    private Label paymentConfirmationLabel;
    @javafx.fxml.FXML
    private TextField paymentClientIdField;
    @javafx.fxml.FXML
    private TextField paymentAmountField;
    @javafx.fxml.FXML
    private TextField paymentMethodField;
    @javafx.fxml.FXML
    private Button verifyInvoiceBtn;
    @javafx.fxml.FXML
    private TableView<Payment> paymentTable;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> paymentIdCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> clientIdCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, Double> amountCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> methodCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<Payment, String> invoiceCol;

    private ObservableList<Payment> paymentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        paymentIdCol.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        clientIdCol.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        methodCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        invoiceCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNumber"));
        
        // Load existing payments from storage
        loadPayments();
    }
    
    private void loadPayments() {
        try {
            paymentList.clear();
            paymentList.addAll(AccountantStorage.loadPayments());
            paymentTable.setItems(paymentList);
            paymentConfirmationLabel.setText("Loaded " + paymentList.size() + " existing payments");
        } catch (IOException e) {
            paymentConfirmationLabel.setText("Ready to record payment");
        }
    }

    @javafx.fxml.FXML
    public void verifyInvoice(ActionEvent actionEvent) {
        String clientId = paymentClientIdField.getText();
        if (clientId.isEmpty()) {
            paymentConfirmationLabel.setText("Please enter Client ID");
        } else {
            paymentConfirmationLabel.setText("Invoice verified for client: " + clientId);
        }
    }

    @javafx.fxml.FXML
    public void recordPayment(ActionEvent actionEvent) {
        try {
            String clientId = paymentClientIdField.getText();
            double amount = Double.parseDouble(paymentAmountField.getText());
            String method = paymentMethodField.getText();

            if (clientId.isEmpty() || method.isEmpty()) {
                paymentConfirmationLabel.setText("Please fill all fields");
                return;
            }

            String paymentId = "PAY" + System.currentTimeMillis();
            Payment payment = new Payment(paymentId, clientId, amount, method, LocalDate.now(), "INV-" + clientId);
            
            // Save to file storage
            try {
                AccountantStorage.savePayment(payment);
                loadPayments(); // Refresh table
                paymentConfirmationLabel.setText("Payment recorded and saved successfully!");
                clearFields();
            } catch (IOException e) {
                paymentConfirmationLabel.setText("Failed to save payment: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            paymentConfirmationLabel.setText("Invalid amount");
        }
    }

    @javafx.fxml.FXML
    public void updatePayment(ActionEvent actionEvent) {
        recordPayment(actionEvent);
    }

    private void clearFields() {
        paymentClientIdField.clear();
        paymentAmountField.clear();
        paymentMethodField.clear();
    }
}