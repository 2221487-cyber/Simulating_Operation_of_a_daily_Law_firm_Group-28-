package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.CaseUpdate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class CCR_Case_updatecontroller
{
    @javafx.fxml.FXML
    private Label TFupdateCaseClientid;
    @javafx.fxml.FXML
    private TextField TFUpdateClientID;
    @javafx.fxml.FXML
    private TextField TFClientRemakrs;
    @javafx.fxml.FXML
    private DatePicker DPUpdateClientCaseHearingDate;
    @javafx.fxml.FXML
    private Label TFupdateCaseRemarks;
    @javafx.fxml.FXML
    private Label CBupdateCaseLawyer;
    @javafx.fxml.FXML
    private Label DPdateupdateCaseHearing;
    @javafx.fxml.FXML
    private ComboBox<String> CBUpdateClientCaseLawyer;

    private ArrayList<CaseUpdate> caseUpdateList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize lawyer dropdown
        CBUpdateClientCaseLawyer.getItems().addAll(
            "Lawyer 001", "Lawyer 002", "Lawyer 003", "Lawyer 004"
        );
    }

    @javafx.fxml.FXML
    public void ButtonUpdateCaseBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TFUpdateClientID.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void labelUpdatecasestatus(Event event) {
        // Handle status label updates
    }

    @javafx.fxml.FXML
    public void ButtonUpdateCaseSubmit(ActionEvent actionEvent) {
        try {
            String clientId = TFUpdateClientID.getText();
            String remarks = TFClientRemakrs.getText();
            String lawyer = CBUpdateClientCaseLawyer.getValue();
            LocalDate hearingDate = DPUpdateClientCaseHearingDate.getValue();

            if (clientId.isEmpty() || remarks.isEmpty() || lawyer == null || hearingDate == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
                return;
            }

            String caseId = "CASE" + System.currentTimeMillis();
            CaseUpdate caseUpdate = new CaseUpdate(caseId, clientId, remarks, lawyer, hearingDate, "Updated");
            caseUpdateList.add(caseUpdate);

            showAlert(Alert.AlertType.INFORMATION, "Success", "Case updated successfully!");
            clearFields();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to update case: " + e.getMessage());
        }
    }

    private void clearFields() {
        TFUpdateClientID.clear();
        TFClientRemakrs.clear();
        CBUpdateClientCaseLawyer.setValue(null);
        DPUpdateClientCaseHearingDate.setValue(null);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}