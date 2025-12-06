package com.lawfirm.controllers.lawyer;

import com.lawfirm.models.CaseFile;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCaseStatusController implements Initializable {
    @FXML
    private TableView<CaseFile> casesTable;

    @FXML
    private TableColumn<CaseFile, String> caseIdColumn;

    @FXML
    private TableColumn<CaseFile, String> titleColumn;

    @FXML
    private TableColumn<CaseFile, String> typeColumn;

    @FXML
    private TableColumn<CaseFile, String> statusColumn;

    @FXML
    private TableColumn<CaseFile, String> clientColumn;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private Label messageLabel;

    private ObservableList<CaseFile> casesList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseIdColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        clientColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getClient() != null ? cellData.getValue().getClient().getName() : "N/A"));

        statusComboBox.setItems(FXCollections.observableArrayList("Open", "In Progress", "Closed"));

        loadCases();
    }

    private void loadCases() {
        casesList = FXCollections.observableArrayList(DataStorage.getInstance().getCases());
        casesTable.setItems(casesList);
    }

    @FXML
    private void handleUpdateStatus() {
        CaseFile selectedCase = casesTable.getSelectionModel().getSelectedItem();
        String newStatus = statusComboBox.getValue();

        if (selectedCase == null) {
            messageLabel.setText("Please select a case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (newStatus == null || newStatus.isEmpty()) {
            messageLabel.setText("Please select a status");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (selectedCase.isClosed() && !newStatus.equals("Closed")) {
            messageLabel.setText("Cannot change status of a closed case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        selectedCase.setStatus(newStatus);
        if (newStatus.equals("Closed")) {
            selectedCase.setClosed(true);
        }

        casesTable.refresh();
        messageLabel.setText("Status updated successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

