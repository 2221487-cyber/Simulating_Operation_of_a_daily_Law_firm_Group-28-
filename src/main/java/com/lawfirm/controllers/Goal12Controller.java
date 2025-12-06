package com.lawfirm.controllers;

import com.lawfirm.models.Goal;
import com.lawfirm.utils.DataManager;
import com.lawfirm.utils.NavigationUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.UUID;

public class Goal12Controller {
    private static final int GOAL_NUMBER = 12;

    @FXML
    private TextField txtGoalTitle;
    @FXML
    private TextArea txtGoalDescription;
    @FXML
    private ComboBox<String> comboClient;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;

    private DataManager dataManager;

    @FXML
    private void initialize() {
        dataManager = DataManager.getInstance();
        loadClients();
    }

    @FXML
    private void handleSave() {
        String title = txtGoalTitle.getText().trim();
        String description = txtGoalDescription.getText().trim();
        String clientId = comboClient.getValue();

        if (title.isEmpty()) {
            showAlert("Error", "Goal title is required!");
            return;
        }

        if (clientId == null) {
            showAlert("Error", "Please select a client!");
            return;
        }

        Goal existingGoal = dataManager.getGoalByNumberAndClient(GOAL_NUMBER, clientId);
        Goal goal;

        if (existingGoal != null) {
            goal = existingGoal;
            goal.setTitle(title);
            goal.setDescription(description);
            dataManager.updateGoal(goal);
        } else {
            goal = new Goal(UUID.randomUUID().toString(), title, description, clientId, GOAL_NUMBER);
            dataManager.addGoal(goal);
        }

        showAlert("Success", "Goal " + GOAL_NUMBER + " saved successfully!");
        clearFields();
    }

    @FXML
    private void handleBack() {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        NavigationUtil.navigateToDashboard(stage);
    }

    private void loadClients() {
        comboClient.getItems().clear();
        dataManager.getAllClients().forEach(client -> {
            comboClient.getItems().add(client.getId());
        });
    }

    private void clearFields() {
        txtGoalTitle.clear();
        txtGoalDescription.clear();
        comboClient.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
