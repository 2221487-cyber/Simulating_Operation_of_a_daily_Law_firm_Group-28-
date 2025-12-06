package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.ClientInfo;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.ClientRegistration;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.CCRStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CCR_Client_searchcontroller
{
    @javafx.fxml.FXML
    private TableColumn<ClientInfo, String> TCLawyer;
    @javafx.fxml.FXML
    private TableView<ClientInfo> tableviewClientInfo;
    @javafx.fxml.FXML
    private TableColumn<ClientInfo, String> col;
    @javafx.fxml.FXML
    private TableColumn<ClientInfo, String> TCclientId;
    @javafx.fxml.FXML
    private TableColumn<ClientInfo, String> TCName;
    @javafx.fxml.FXML
    private TextField TFSearchClientInfoClientId;
    @javafx.fxml.FXML
    private TableColumn<ClientInfo, String> TCCaseType;

    private ObservableList<ClientInfo> clientList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        TCName.setCellValueFactory(new PropertyValueFactory<>("name"));
        col.setCellValueFactory(new PropertyValueFactory<>("contact"));
        TCCaseType.setCellValueFactory(new PropertyValueFactory<>("caseType"));
        TCclientId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        TCLawyer.setCellValueFactory(new PropertyValueFactory<>("lawyer"));

        // Load data from storage
        loadClientsFromStorage();
    }

    private void loadClientsFromStorage() {
        try {
            List<ClientRegistration> registrations = CCRStorage.loadClients();
            clientList.clear();
            
            // Convert ClientRegistration to ClientInfo for display
            for (ClientRegistration reg : registrations) {
                ClientInfo info = new ClientInfo(
                    reg.getClientId(),
                    reg.getClientName(),
                    reg.getContactNumber(),
                    reg.getCaseType(),
                    reg.getPreferredLawyer()
                );
                clientList.add(info);
            }
            
            tableviewClientInfo.setItems(clientList);
        } catch (IOException e) {
            showAlert(Alert.AlertType.WARNING, "Storage Error", "Could not load clients: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void buttonSearch(ActionEvent actionEvent) {
        String searchText = TFSearchClientInfoClientId.getText().trim();

        if (searchText.isEmpty()) {
            tableviewClientInfo.setItems(clientList);
            return;
        }

        ObservableList<ClientInfo> filteredList = FXCollections.observableArrayList();
        for (ClientInfo client : clientList) {
            if (client.getClientId().contains(searchText) || client.getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(client);
            }
        }

        if (filteredList.isEmpty()) {
            showAlert(Alert.AlertType.INFORMATION, "No Results", "No clients found matching the search criteria");
        }

        tableviewClientInfo.setItems(filteredList);
    }

    @javafx.fxml.FXML
    public void buttonBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TFSearchClientInfoClientId.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}