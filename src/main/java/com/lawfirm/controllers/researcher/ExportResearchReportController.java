package com.lawfirm.controllers.researcher;

import com.lawfirm.models.ResearchRecord;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ExportResearchReportController implements Initializable {
    @FXML
    private ComboBox<ResearchRecord> recordComboBox;

    @FXML
    private TextArea reportArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recordComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getResearchRecords()));
        recordComboBox.setCellFactory(param -> new javafx.scene.control.ListCell<ResearchRecord>() {
            @Override
            protected void updateItem(ResearchRecord item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTopic() + " (" + item.getRecordId() + ")");
                }
            }
        });
        recordComboBox.setButtonCell(new javafx.scene.control.ListCell<ResearchRecord>() {
            @Override
            protected void updateItem(ResearchRecord item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTopic() + " (" + item.getRecordId() + ")");
                }
            }
        });
    }

    @FXML
    private void handleGenerateReport() {
        ResearchRecord selected = recordComboBox.getValue();
        if (selected == null) {
            reportArea.setText("Please select a research record to generate report.");
            return;
        }

        StringBuilder report = new StringBuilder();
        report.append("RESEARCH REPORT\n");
        report.append("===============\n\n");
        report.append("Record ID: ").append(selected.getRecordId()).append("\n");
        report.append("Topic: ").append(selected.getTopic()).append("\n");
        report.append("Created Date: ").append(selected.getCreatedDate()).append("\n\n");
        
        report.append("Keywords:\n");
        if (selected.getKeywords().isEmpty()) {
            report.append("  None\n");
        } else {
            selected.getKeywords().forEach(keyword -> report.append("  - ").append(keyword).append("\n"));
        }
        
        report.append("\nReferences:\n");
        if (selected.getReferences().isEmpty()) {
            report.append("  None\n");
        } else {
            selected.getReferences().forEach(ref -> report.append("  - ").append(ref).append("\n"));
        }
        
        report.append("\nSummary:\n");
        report.append(selected.getSummary()).append("\n\n");
        
        report.append("--- End of Report ---");

        reportArea.setText(report.toString());
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

