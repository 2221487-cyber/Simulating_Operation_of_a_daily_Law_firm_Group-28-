package com.project.sec3_2221869_project;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class SetFirmGoalController {

    @FXML
    private TextField inputForNumericalGoaTextFieldl;

    @FXML
    private void handleSaveGoalButtonOnAction() {

        String input = inputForNumericalGoaTextFieldl.getText();

        if (input.isEmpty()) {
            showAlert("Input Required", "Please enter a number.");
            return;
        }

        try {
            int targetHours = Integer.parseInt(input);

            System.out.println("Target Billable Hours Saved: " + targetHours);

            showAlert("Success", "Goal saved successfully!");

        } catch (NumberFormatException e) {
            showAlert("Invalid Input", "Please enter a valid number.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
