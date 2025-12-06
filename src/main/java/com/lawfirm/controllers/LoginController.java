package com.lawfirm.controllers;

import com.lawfirm.models.User;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
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

