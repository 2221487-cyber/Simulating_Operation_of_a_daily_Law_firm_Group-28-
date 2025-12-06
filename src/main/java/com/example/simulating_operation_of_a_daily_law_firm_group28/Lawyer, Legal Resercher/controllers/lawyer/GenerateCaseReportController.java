package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.CaseFile;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class GenerateCaseReportController implements Initializable {
    @FXML
    private ComboBox<CaseFile> caseComboBox;

    @FXML
    private TextArea reportArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getCases()));
        caseComboBox.setCellFactory(param -> new javafx.scene.control.ListCell<CaseFile>() {
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
        caseComboBox.setButtonCell(new javafx.scene.control.ListCell<CaseFile>() {
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
    }

    @FXML
    private void handleGenerateReport() {
        CaseFile selectedCase = caseComboBox.getValue();
        if (selectedCase == null) {
            reportArea.setText("Please select a case to generate report.");
            return;
        }

        StringBuilder report = new StringBuilder();
        report.append("CASE PROGRESS REPORT\n");
        report.append("===================\n\n");
        report.append("Case ID: ").append(selectedCase.getCaseId()).append("\n");
        report.append("Title: ").append(selectedCase.getTitle()).append("\n");
        report.append("Type: ").append(selectedCase.getType()).append("\n");
        report.append("Status: ").append(selectedCase.getStatus()).append("\n");
        report.append("Client: ").append(selectedCase.getClient() != null ? selectedCase.getClient().getName() : "N/A").append("\n");
        report.append("Hearing Date: ").append(selectedCase.getHearingDate() != null ? selectedCase.getHearingDate().toString() : "Not scheduled").append("\n\n");
        
        report.append("Description:\n");
        report.append(selectedCase.getDescription()).append("\n\n");
        
        report.append("Documents: ").append(selectedCase.getDocuments().size()).append(" document(s)\n");
        if (!selectedCase.getDocuments().isEmpty()) {
            report.append("Document List:\n");
            selectedCase.getDocuments().forEach(doc -> {
                report.append("  - ").append(doc.getName()).append(" (").append(doc.getType()).append(")\n");
            });
        }
        
        report.append("\n");
        report.append("Case Status: ").append(selectedCase.isClosed() ? "CLOSED" : "ACTIVE").append("\n");

        reportArea.setText(report.toString());
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

