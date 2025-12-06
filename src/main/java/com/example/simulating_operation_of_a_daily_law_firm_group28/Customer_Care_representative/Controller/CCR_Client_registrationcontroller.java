package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.ClientRegistration;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.CCRStorage;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CCR_Client_registrationcontroller
{
    @javafx.fxml.FXML
    private Label labelRegisterClientStatus;
    @javafx.fxml.FXML
    private ComboBox<String> CBClientRegPreferredLawyer;
    @javafx.fxml.FXML
    private TextField TFClientRegContactNum;
    @javafx.fxml.FXML
    private TextField TFClientRegClientName;
    @javafx.fxml.FXML
    private ComboBox<String> CBClientRegCaseType;

    private ArrayList<ClientRegistration> clientList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize case type dropdown
        CBClientRegCaseType.getItems().addAll(
            "Criminal Law",
            "Civil Law",
            "Family Law",
            "Corporate Law",
            "Real Estate Law",
            "Employment Law",
            "Immigration Law",
            "Intellectual Property",
            "Tax Law",
            "Personal Injury"
        );
        
        // Initialize lawyer dropdown
        CBClientRegPreferredLawyer.getItems().addAll(
            "Lawyer 001 - Criminal Law",
            "Lawyer 002 - Civil Law",
            "Lawyer 003 - Family Law",
            "Lawyer 004 - Corporate Law"
        );
        
        // Load existing clients from storage
        try {
            clientList.addAll(CCRStorage.loadClients());
            labelRegisterClientStatus.setText("Loaded " + clientList.size() + " existing clients");
        } catch (IOException e) {
            labelRegisterClientStatus.setText("Ready to register clients");
        }
    }

    @javafx.fxml.FXML
    public void buttonClientReg(ActionEvent actionEvent) {
        try {
            String clientName = TFClientRegClientName.getText();
            String contactNum = TFClientRegContactNum.getText();
            String caseType = CBClientRegCaseType.getValue();
            String preferredLawyer = CBClientRegPreferredLawyer.getValue();

            if (clientName.isEmpty() || contactNum.isEmpty() || caseType == null || caseType.isEmpty() || preferredLawyer == null) {
                labelRegisterClientStatus.setText("Please fill all fields");
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
                return;
            }

            String clientId = "CLI" + System.currentTimeMillis();
            ClientRegistration client = new ClientRegistration(clientId, clientName, contactNum, caseType, preferredLawyer);
            
            // Save to file storage
            try {
                CCRStorage.saveClient(client);
                clientList.add(client);
                labelRegisterClientStatus.setText("Client registered and saved successfully!");
                showAlert(Alert.AlertType.INFORMATION, "Success", "Client registered with ID: " + clientId);
                clearFields();
            } catch (IOException e) {
                labelRegisterClientStatus.setText("Failed to save client");
                showAlert(Alert.AlertType.ERROR, "Storage Error", "Failed to save client: " + e.getMessage());
            }
        } catch (Exception e) {
            labelRegisterClientStatus.setText("Registration failed");
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to register client: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void buttonClientRegBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TFClientRegClientName.getScene().getWindow();
        stage.close();
    }

    private void clearFields() {
        TFClientRegClientName.clear();
        TFClientRegContactNum.clear();
        CBClientRegCaseType.setValue(null);
        CBClientRegPreferredLawyer.setValue(null);
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}