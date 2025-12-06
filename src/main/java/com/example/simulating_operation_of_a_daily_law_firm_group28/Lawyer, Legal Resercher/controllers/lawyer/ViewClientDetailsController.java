package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.CaseFile;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.Client;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewClientDetailsController implements Initializable {
    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private Label clientNameLabel;

    @FXML
    private Label clientEmailLabel;

    @FXML
    private Label clientPhoneLabel;

    @FXML
    private Label clientAddressLabel;

    @FXML
    private TableView<CaseFile> caseHistoryTable;

    @FXML
    private TableColumn<CaseFile, String> caseIdColumn;

    @FXML
    private TableColumn<CaseFile, String> caseTitleColumn;

    @FXML
    private TableColumn<CaseFile, String> caseTypeColumn;

    @FXML
    private TableColumn<CaseFile, String> caseStatusColumn;

    @FXML
    private TableColumn<CaseFile, String> caseDateColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getClients()));
        clientComboBox.setCellFactory(param -> new ListCell<Client>() {
            @Override
            protected void updateItem(Client item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName() + " (" + item.getClientId() + ")");
                }
            }
        });
        clientComboBox.setButtonCell(new ListCell<Client>() {
            @Override
            protected void updateItem(Client item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName() + " (" + item.getClientId() + ")");
                }
            }
        });

        clientComboBox.setOnAction(e -> displayClientDetails());

        caseIdColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        caseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        caseTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        caseStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        caseDateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getHearingDate() != null ? 
                    cellData.getValue().getHearingDate().toString() : "N/A"));
    }

    private void displayClientDetails() {
        Client selectedClient = clientComboBox.getValue();
        if (selectedClient != null) {
            clientNameLabel.setText("Name: " + selectedClient.getName());
            clientEmailLabel.setText("Email: " + selectedClient.getEmail());
            clientPhoneLabel.setText("Phone: " + selectedClient.getPhone());
            clientAddressLabel.setText("Address: " + selectedClient.getAddress());

            ObservableList<CaseFile> caseHistory = FXCollections.observableArrayList(selectedClient.getCaseHistory());
            caseHistoryTable.setItems(caseHistory);
        }
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

