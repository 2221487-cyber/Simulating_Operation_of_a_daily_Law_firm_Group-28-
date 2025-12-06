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
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class EditResearchRecordController implements Initializable {
    @FXML
    private ComboBox<ResearchRecord> recordComboBox;

    @FXML
    private TextField keywordsField;

    @FXML
    private TextArea referencesArea;

    @FXML
    private TextArea summaryArea;

    @FXML
    private Label messageLabel;

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

        recordComboBox.setOnAction(e -> loadRecordData());
    }

    private void loadRecordData() {
        ResearchRecord selected = recordComboBox.getValue();
        if (selected != null) {
            keywordsField.setText(String.join(", ", selected.getKeywords()));
            referencesArea.setText(String.join("\n", selected.getReferences()));
            summaryArea.setText(selected.getSummary());
        }
    }

    @FXML
    private void handleUpdateRecord() {
        ResearchRecord selected = recordComboBox.getValue();
        if (selected == null) {
            messageLabel.setText("Please select a research record");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (summaryArea.getText().isEmpty()) {
            messageLabel.setText("Summary cannot be empty");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        selected.setKeywords(Arrays.stream(keywordsField.getText().split(","))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList()));

        selected.setReferences(Arrays.stream(referencesArea.getText().split("\n"))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toList()));

        selected.setSummary(summaryArea.getText());

        messageLabel.setText("Research record updated successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

