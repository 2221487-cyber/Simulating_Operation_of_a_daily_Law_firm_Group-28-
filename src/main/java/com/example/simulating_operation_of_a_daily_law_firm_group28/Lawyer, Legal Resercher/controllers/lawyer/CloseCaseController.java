package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.CaseFile;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CloseCaseController implements Initializable {
    @FXML
    private ComboBox<CaseFile> caseComboBox;

    @FXML
    private Label caseInfoLabel;

    @FXML
    private CheckBox confirmCheckBox;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseComboBox.setItems(FXCollections.observableArrayList(
            DataStorage.getInstance().getCases().stream()
                .filter(c -> !c.isClosed())
                .collect(Collectors.toList())
        ));
        caseComboBox.setCellFactory(param -> new ListCell<CaseFile>() {
            @Override
            protected void updateItem(CaseFile item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getCaseId() + " - " + item.getTitle());
                }
            }
        });
        caseComboBox.setButtonCell(new ListCell<CaseFile>() {
            @Override
            protected void updateItem(CaseFile item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getCaseId() + " - " + item.getTitle());
                }
            }
        });

        caseComboBox.setOnAction(e -> displayCaseInfo());
    }

    private void displayCaseInfo() {
        CaseFile selectedCase = caseComboBox.getValue();
        if (selectedCase != null) {
            StringBuilder info = new StringBuilder();
            info.append("Case ID: ").append(selectedCase.getCaseId()).append("\n");
            info.append("Title: ").append(selectedCase.getTitle()).append("\n");
            info.append("Type: ").append(selectedCase.getType()).append("\n");
            info.append("Status: ").append(selectedCase.getStatus()).append("\n");
            info.append("Client: ").append(selectedCase.getClient() != null ? selectedCase.getClient().getName() : "N/A").append("\n");
            info.append("Documents: ").append(selectedCase.getDocuments().size()).append(" document(s)");
            caseInfoLabel.setText(info.toString());
        }
    }

    @FXML
    private void handleCloseCase() {
        CaseFile selectedCase = caseComboBox.getValue();
        if (selectedCase == null) {
            messageLabel.setText("Please select a case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (!confirmCheckBox.isSelected()) {
            messageLabel.setText("Please confirm by checking the checkbox");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (selectedCase.isClosed()) {
            messageLabel.setText("This case is already closed");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        selectedCase.setClosed(true);
        selectedCase.setStatus("Closed");

        messageLabel.setText("Case closed successfully! The case is now read-only.");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);

        confirmCheckBox.setSelected(false);
        caseComboBox.setItems(FXCollections.observableArrayList(
            DataStorage.getInstance().getCases().stream()
                .filter(c -> !c.isClosed())
                .collect(java.util.stream.Collectors.toList())
        ));
        caseInfoLabel.setText("");
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

