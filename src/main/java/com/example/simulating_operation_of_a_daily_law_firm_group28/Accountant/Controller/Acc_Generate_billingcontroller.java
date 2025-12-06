package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.BillableItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Acc_Generate_billingcontroller {

    @javafx.fxml.FXML
    private TableColumn<BillableItem, Double> serviceTotalCol;
    @javafx.fxml.FXML
    private TableColumn<BillableItem, String> serviceNameCol;
    @javafx.fxml.FXML
    private Button calculateTotalBtn;
    @javafx.fxml.FXML
    private Label finalTotalLabel;
    @javafx.fxml.FXML
    private TableColumn<BillableItem, Double> serviceHoursCol;
    @javafx.fxml.FXML
    private Button viewInvoiceBtn;
    @javafx.fxml.FXML
    private Button saveBillingBtn;
    @javafx.fxml.FXML
    private TableView<BillableItem> billableItemsTable;
    @javafx.fxml.FXML
    private TextField discountField;
    @javafx.fxml.FXML
    private TableColumn<BillableItem, Double> serviceRateCol;
    @javafx.fxml.FXML
    private TextField taxField;
    @javafx.fxml.FXML
    private Button generateBillBtn;
    @javafx.fxml.FXML
    private TextField clientIdField;
    @javafx.fxml.FXML
    private TableColumn<BillableItem, Double> serviceFeeCol;
    @javafx.fxml.FXML
    private Label subtotalLabel;
    @javafx.fxml.FXML
    private Label statusLabel;

    private ObservableList<BillableItem> billableItems = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        serviceNameCol.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
        serviceHoursCol.setCellValueFactory(new PropertyValueFactory<>("hours"));
        serviceRateCol.setCellValueFactory(new PropertyValueFactory<>("rate"));
        serviceFeeCol.setCellValueFactory(new PropertyValueFactory<>("fee"));
        serviceTotalCol.setCellValueFactory(new PropertyValueFactory<>("total"));

        // Initialize default values
        discountField.setText("0");
        taxField.setText("0");
        finalTotalLabel.setText("0.00");
        subtotalLabel.setText("0.00");
        statusLabel.setText("Enter client ID and click 'Load Billable Items' to start");
    }

    @Deprecated
    public void buttonGeneratebill(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void saveBilling(ActionEvent actionEvent) {
        String clientId = clientIdField.getText();
        if (clientId.isEmpty()) {
            statusLabel.setText("Error: Please enter a client ID");
            return;
        }
        statusLabel.setText("Billing record saved successfully for client: " + clientId);
    }

    @javafx.fxml.FXML
    public void calculateTotal(ActionEvent actionEvent) {
        try {
            // Calculate subtotal from all billable items in the table
            double subtotal = 0.0;
            for (BillableItem item : billableItems) {
                subtotal += item.getTotal();
            }

            double discount = Double.parseDouble(discountField.getText().isEmpty() ? "0" : discountField.getText());
            double tax = Double.parseDouble(taxField.getText().isEmpty() ? "0" : taxField.getText());

            // Calculate discount and tax amounts
            double discountAmount = subtotal * (discount / 100);
            double afterDiscount = subtotal - discountAmount;
            double taxAmount = afterDiscount * (tax / 100);
            double total = afterDiscount + taxAmount;

            // Display results
            subtotalLabel.setText(String.format("%.2f", subtotal));
            finalTotalLabel.setText(String.format("%.2f", total));
            statusLabel.setText(String.format("Subtotal: %.2f | Discount: %.2f | Tax: %.2f | Total: %.2f",
                    subtotal, discountAmount, taxAmount, total));
        } catch (NumberFormatException e) {
            statusLabel.setText("Error: Invalid discount or tax value");
        }
    }

    @javafx.fxml.FXML
    public void generateBill(ActionEvent actionEvent) {
        String clientId = clientIdField.getText();
        if (clientId.isEmpty()) {
            statusLabel.setText("Error: Please enter a client ID");
            return;
        }

        // Clear existing items
        billableItems.clear();

        // Load or generate sample billable items for the client
        // In a real application, this would load from storage based on clientId
        billableItems.add(new BillableItem("Legal Consultation", 5.0, 150.0, 0.0));
        billableItems.add(new BillableItem("Document Preparation", 3.0, 100.0, 50.0));
        billableItems.add(new BillableItem("Court Representation", 8.0, 200.0, 100.0));
        billableItems.add(new BillableItem("Research", 4.0, 120.0, 0.0));

        // Set items to table
        billableItemsTable.setItems(billableItems);

        // Calculate initial subtotal
        double subtotal = billableItems.stream().mapToDouble(BillableItem::getTotal).sum();
        subtotalLabel.setText(String.format("%.2f", subtotal));

        statusLabel.setText("Loaded " + billableItems.size() + " billable items for client: " + clientId);
    }

    @javafx.fxml.FXML
    public void viewInvoice(ActionEvent actionEvent) {
        String clientId = clientIdField.getText();
        if (clientId.isEmpty()) {
            statusLabel.setText("Error: Please enter a client ID");
            return;
        }
        statusLabel.setText("Viewing invoice for client: " + clientId);
    }
}