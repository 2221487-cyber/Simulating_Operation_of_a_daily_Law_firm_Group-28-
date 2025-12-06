package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CCR_Communicationcontroller
{
    @javafx.fxml.FXML
    private Label DPdateReportFrom;
    @javafx.fxml.FXML
    private DatePicker DPHistoryReportFrom;
    @javafx.fxml.FXML
    private Label DPdateReportTo;
    @javafx.fxml.FXML
    private DatePicker DPHistoryReportTo;
    @javafx.fxml.FXML
    private Label labelGenerateReportStatus;

    @javafx.fxml.FXML
    public void initialize() {
        labelGenerateReportStatus.setText("Ready to generate report");
    }

    @javafx.fxml.FXML
    public void buttonGenerateReportStatus(ActionEvent actionEvent) {
        Stage stage = (Stage) DPHistoryReportFrom.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void buttonGenerateReportSubmit(ActionEvent actionEvent) {
        try {
            LocalDate fromDate = DPHistoryReportFrom.getValue();
            LocalDate toDate = DPHistoryReportTo.getValue();

            if (fromDate == null || toDate == null) {
                labelGenerateReportStatus.setText("Please select both dates");
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please select both dates");
                return;
            }

            if (fromDate.isAfter(toDate)) {
                labelGenerateReportStatus.setText("From date must be before To date");
                showAlert(Alert.AlertType.WARNING, "Validation Error", "From date must be before To date");
                return;
            }

            // Generate report logic here
            labelGenerateReportStatus.setText("Report generated successfully!");
            showAlert(Alert.AlertType.INFORMATION, "Success", 
                "Communication report generated for period: " + fromDate + " to " + toDate);
        } catch (Exception e) {
            labelGenerateReportStatus.setText("Failed to generate report");
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to generate report: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}