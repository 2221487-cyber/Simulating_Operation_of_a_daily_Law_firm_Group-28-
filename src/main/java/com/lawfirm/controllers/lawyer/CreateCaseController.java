package com.lawfirm.controllers.lawyer;

import com.lawfirm.models.CaseFile;
import com.lawfirm.models.Client;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.UUID;

public class CreateCaseController {
    @FXML
    private TextField titleField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField clientNameField;

    @FXML
    private TextField clientEmailField;

    @FXML
    private TextField clientPhoneField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleCreateCase() {
        if (titleField.getText().isEmpty() || typeField.getText().isEmpty() || 
            clientNameField.getText().isEmpty() || descriptionArea.getText().isEmpty()) {
            messageLabel.setText("Please fill in all required fields");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        // Create or find client
        Client client = new Client(UUID.randomUUID().toString().substring(0, 8),
                clientNameField.getText(),
                clientEmailField.getText().isEmpty() ? "N/A" : clientEmailField.getText(),
                clientPhoneField.getText().isEmpty() ? "N/A" : clientPhoneField.getText(),
                "N/A");
        DataStorage.getInstance().addClient(client);

        // Create case file
        CaseFile caseFile = new CaseFile(
                "CASE" + UUID.randomUUID().toString().substring(0, 5).toUpperCase(),
                titleField.getText(),
                typeField.getText(),
                client,
                descriptionArea.getText()
        );

        DataStorage.getInstance().addCase(caseFile);
        client.getCaseHistory().add(caseFile);

        messageLabel.setText("Case created successfully! Case ID: " + caseFile.getCaseId());
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);

        // Clear fields
        titleField.clear();
        typeField.clear();
        clientNameField.clear();
        clientEmailField.clear();
        clientPhoneField.clear();
        descriptionArea.clear();
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

