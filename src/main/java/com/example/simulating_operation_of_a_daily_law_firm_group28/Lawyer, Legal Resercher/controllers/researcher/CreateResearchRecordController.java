package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.ResearchRecord;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateResearchRecordController {
    @FXML
    private TextField topicField;

    @FXML
    private TextField keywordsField;

    @FXML
    private TextArea referencesArea;

    @FXML
    private TextArea summaryArea;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleSaveRecord() {
        if (topicField.getText().isEmpty() || summaryArea.getText().isEmpty()) {
            messageLabel.setText("Please fill in topic and summary");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        ResearchRecord record = new ResearchRecord(
            "RES" + UUID.randomUUID().toString().substring(0, 5).toUpperCase(),
            topicField.getText(),
            summaryArea.getText()
        );

        if (!keywordsField.getText().isEmpty()) {
            record.setKeywords(Arrays.stream(keywordsField.getText().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));
        }

        if (!referencesArea.getText().isEmpty()) {
            record.setReferences(Arrays.stream(referencesArea.getText().split("\n"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));
        }

        DataStorage.getInstance().addResearchRecord(record);

        messageLabel.setText("Research record created successfully! Record ID: " + record.getRecordId());
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);

        topicField.clear();
        keywordsField.clear();
        referencesArea.clear();
        summaryArea.clear();
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

