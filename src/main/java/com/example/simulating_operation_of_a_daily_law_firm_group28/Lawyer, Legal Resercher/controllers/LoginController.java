package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.User;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter both email and password");
            errorLabel.setVisible(true);
            return;
        }

        User user = DataStorage.getInstance().authenticate(email, password);
        if (user != null) {
            DataStorage.getInstance().setCurrentUser(user);
            if ("Lawyer".equals(user.getRole())) {
                PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
            } else if ("LegalResearcher".equals(user.getRole())) {
                PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
            }
        } else {
            errorLabel.setText("Invalid email or password");
            errorLabel.setVisible(true);
        }
    }
}

