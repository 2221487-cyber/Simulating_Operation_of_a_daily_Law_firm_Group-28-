package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.ResearchRecord;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class GenerateResearchSummaryController implements Initializable {
    @FXML
    private ComboBox<ResearchRecord> topicComboBox;

    @FXML
    private TextArea summaryArea;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topicComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getResearchRecords()));
        topicComboBox.setCellFactory(param -> new javafx.scene.control.ListCell<ResearchRecord>() {
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
        topicComboBox.setButtonCell(new javafx.scene.control.ListCell<ResearchRecord>() {
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

        topicComboBox.setOnAction(e -> loadSummary());
    }

    private void loadSummary() {
        ResearchRecord selected = topicComboBox.getValue();
        if (selected != null) {
            summaryArea.setText(selected.getSummary());
        }
    }

    @FXML
    private void handleSaveSummary() {
        ResearchRecord selected = topicComboBox.getValue();
        if (selected == null) {
            messageLabel.setText("Please select a research topic");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (summaryArea.getText().isEmpty()) {
            messageLabel.setText("Please enter a summary");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        selected.setSummary(summaryArea.getText());
        messageLabel.setText("Summary saved successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

