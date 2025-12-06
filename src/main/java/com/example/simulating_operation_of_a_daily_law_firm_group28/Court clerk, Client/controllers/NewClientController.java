package com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.controllers;

import com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.models.Client;
import com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils.DataManager;
import com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.UUID;

public class NewClientController {

    @FXML
    private TextField txtClientId;
    @FXML
    private TextField txtClientName;
    @FXML
    private TextField txtClientEmail;
    @FXML
    private TextField txtClientPhone;
    @FXML
    private Button btnSaveClient;
    @FXML
    private Button btnBack;
    @FXML
    private TableView<Client> tableViewClients;
    @FXML
    private TableColumn<Client, String> colId;
    @FXML
    private TableColumn<Client, String> colName;
    @FXML
    private TableColumn<Client, String> colEmail;
    @FXML
    private TableColumn<Client, String> colPhone;

    private DataManager dataManager;

    @FXML
    private void initialize() {
        dataManager = DataManager.getInstance();
        
        // Generate ID button handler
        txtClientId.setOnMouseClicked(e -> {
            if (txtClientId.getText().isEmpty()) {
                txtClientId.setText(UUID.randomUUID().toString().substring(0, 8));
            }
        });

        // Setup table columns
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        loadClients();
    }

    @FXML
    private void handleSaveClient() {
        String id = txtClientId.getText().trim();
        String name = txtClientName.getText().trim();
        String email = txtClientEmail.getText().trim();
        String phone = txtClientPhone.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {
            showAlert("Error", "Client ID and Name are required!");
            return;
        }

        Client client = new Client(id, name, email, phone);
        dataManager.addClient(client);
        
        clearFields();
        loadClients();
        showAlert("Success", "Client saved successfully!");
    }

    @FXML
    private void handleBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        NavigationUtil.navigateToDashboard(stage);
    }

    private void loadClients() {
        ObservableList<Client> clients = FXCollections.observableArrayList(
                dataManager.getAllClients()
        );
        tableViewClients.setItems(clients);
    }

    private void clearFields() {
        txtClientId.clear();
        txtClientName.clear();
        txtClientEmail.clear();
        txtClientPhone.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
