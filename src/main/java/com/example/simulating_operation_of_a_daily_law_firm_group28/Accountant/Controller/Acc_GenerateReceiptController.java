package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Acc_GenerateReceiptController
{
    @javafx.fxml.FXML
    private Button viewReceiptBtn;
    @javafx.fxml.FXML
    private TextField receiptInvoiceField;
    @javafx.fxml.FXML
    private TextField receiptClientIdField;
    @javafx.fxml.FXML
    private Button buttongenerateReceipt;
    @javafx.fxml.FXML
    private Button buttonverifyPayment;
    @javafx.fxml.FXML
    private TextField paymentAmountField;
    @javafx.fxml.FXML
    private DatePicker paymentDatePicker;
    @javafx.fxml.FXML
    private TextArea receiptDetailsArea;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> ComboBoxPaymentMethod;

    @javafx.fxml.FXML
    public void initialize() {
        paymentDatePicker.setValue(LocalDate.now());
        

        ComboBoxPaymentMethod.getItems().addAll("Cash", "Credit Card", "Debit Card", "Bank Transfer", "Check");
        ComboBoxPaymentMethod.setValue("Cash");
        
        statusLabel.setText("Fill in the payment details to generate a receipt");
    }

    @javafx.fxml.FXML
    public void viewReceipt(ActionEvent actionEvent) {
        String clientId = receiptClientIdField.getText();
        String invoiceId = receiptInvoiceField.getText();
        
        if (clientId.isEmpty() || invoiceId.isEmpty()) {
            statusLabel.setText("Error: Please enter Client ID and Invoice Number");
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all required fields");
            return;
        }
        

        String receiptText = generateReceiptText(clientId, invoiceId);
        receiptDetailsArea.setText(receiptText);
        statusLabel.setText("Receipt displayed successfully");
    }

    @javafx.fxml.FXML
    public void verifyPayment(ActionEvent actionEvent) {
        String invoiceId = receiptInvoiceField.getText();
        String amount = paymentAmountField.getText();
        
        if (invoiceId.isEmpty() || amount.isEmpty()) {
            statusLabel.setText("Error: Please enter Invoice Number and Payment Amount");
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all required fields");
            return;
        }
        
        try {
            Double.parseDouble(amount);
            statusLabel.setText("Payment verified successfully for invoice: " + invoiceId);
            showAlert(Alert.AlertType.INFORMATION, "Verified", "Payment of $" + amount + " verified for invoice: " + invoiceId);
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Invalid payment amount");
            showAlert(Alert.AlertType.ERROR, "Invalid Amount", "Please enter a valid numeric amount");
        }
    }

    @javafx.fxml.FXML
    public void generateReceipt(ActionEvent actionEvent) {
        String clientId = receiptClientIdField.getText();
        String invoiceId = receiptInvoiceField.getText();
        String amount = paymentAmountField.getText();
        String method = ComboBoxPaymentMethod.getValue();
        LocalDate date = paymentDatePicker.getValue();
        
        if (clientId.isEmpty() || invoiceId.isEmpty() || amount.isEmpty() || method.isEmpty() || date == null) {
            statusLabel.setText("Error: Please fill all fields");
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
            return;
        }
        
        try {
            Double.parseDouble(amount);
            String receiptText = generateReceiptText(clientId, invoiceId);
            receiptDetailsArea.setText(receiptText);
            statusLabel.setText("Receipt generated successfully for client: " + clientId);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Receipt generated successfully!");
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Invalid payment amount");
            showAlert(Alert.AlertType.ERROR, "Invalid Amount", "Please enter a valid numeric amount");
        }
    }
    
    private String generateReceiptText(String clientId, String invoiceId) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("========================================\n");
        receipt.append("           PAYMENT RECEIPT\n");
        receipt.append("========================================\n\n");
        receipt.append("Receipt Date: ").append(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        receipt.append("Client ID: ").append(clientId).append("\n");
        receipt.append("Invoice Number: ").append(invoiceId).append("\n\n");
        
        String amount = paymentAmountField.getText();
        String method = ComboBoxPaymentMethod.getValue();
        LocalDate date = paymentDatePicker.getValue();
        
        if (amount != null && !amount.isEmpty()) {
            receipt.append("Payment Amount: $").append(amount).append("\n");
        }
        if (date != null) {
            receipt.append("Payment Date: ").append(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        }
        if (method != null && !method.isEmpty()) {
            receipt.append("Payment Method: ").append(method).append("\n");
        }
        

        receipt.append("Thank you for your payment!\n");

        
        return receipt.toString();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}