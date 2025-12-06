package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimeEntryFormController {

    @FXML
    private TextField clientIdTextField;

    @FXML
    private TextField caseNoTextField;

    @FXML
    private TextArea timeEntryDetailsTextArea;

    @FXML
    private TableView<TimeEntry> TableView;

    @FXML
    private TableColumn<TimeEntry, String> clientIdTC;

    @FXML
    private TableColumn<TimeEntry, String> caseNoTC;

    @FXML
    private TableColumn<TimeEntry, String> timeEntrtyDetailsTC;

    private ObservableList<TimeEntry> timeEntryList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        clientIdTC.setCellValueFactory(new PropertyValueFactory<TimeEntry, String>("clientId"));
        caseNoTC.setCellValueFactory(new PropertyValueFactory<TimeEntry, String>("caseNo"));
        timeEntrtyDetailsTC.setCellValueFactory(new PropertyValueFactory<TimeEntry, String>("details"));
        TableView.setItems(timeEntryList);
    }

    @FXML
    private void handleEnterButtonOnAction() {
        String clientId = clientIdTextField.getText();
        String caseNo = caseNoTextField.getText();
        String details = timeEntryDetailsTextArea.getText();

        if (clientId.isEmpty() || caseNo.isEmpty() || details.isEmpty()) {
            showAlert("Missing Fields", "Please fill out all fields before entering.");
            return;
        }
        TimeEntry entry = new TimeEntry(clientId, caseNo, details);
        timeEntryList.add(entry);
        clientIdTextField.clear();
        caseNoTextField.clear();
        timeEntryDetailsTextArea.clear();

        showAlert("Success", "Time entry added!");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
