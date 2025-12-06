package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.Inquiry;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.CCRStorage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CCR_Inquiry_recordcontroller
{
    @javafx.fxml.FXML
    private Label TAinquiryDescription;
    @javafx.fxml.FXML
    private Label TFinquiryClientname;
    @javafx.fxml.FXML
    private Label CBinquiryType;
    @javafx.fxml.FXML
    private TextField TFInquiryrecordclientname;
    @javafx.fxml.FXML
    private TextArea TAInquiryrecordDescription;
    @javafx.fxml.FXML
    private ComboBox<String> CBInquiryrecordcategory;

    private ArrayList<Inquiry> inquiryList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize inquiry categories
        CBInquiryrecordcategory.getItems().addAll(
            "General Inquiry",
            "Case Status",
            "Billing Question",
            "Appointment Request",
            "Document Request",
            "Other"
        );
    }

    @javafx.fxml.FXML
    public void buttonInquiryrecordSubmit(ActionEvent actionEvent) {
        try {
            String clientName = TFInquiryrecordclientname.getText();
            String description = TAInquiryrecordDescription.getText();
            String category = CBInquiryrecordcategory.getValue();

            if (clientName.isEmpty() || description.isEmpty() || category == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
                return;
            }

            String inquiryId = "INQ" + System.currentTimeMillis();
            Inquiry inquiry = new Inquiry(inquiryId, clientName, description, category, LocalDate.now(), "Pending");
            
            // Save to storage
            try {
                CCRStorage.saveInquiry(inquiry);
                inquiryList.add(inquiry);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Inquiry recorded and saved successfully with ID: " + inquiryId);
                clearFields();
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Storage Error", "Failed to save inquiry: " + e.getMessage());
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to record inquiry: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void buttonInquiryrecordBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TFInquiryrecordclientname.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        TFInquiryrecordclientname.clear();
        TAInquiryrecordDescription.clear();
        CBInquiryrecordcategory.setValue(null);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}