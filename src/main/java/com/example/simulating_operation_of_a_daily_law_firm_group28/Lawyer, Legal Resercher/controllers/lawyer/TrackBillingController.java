package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.lawyer;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.Billing;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.CaseFile;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class TrackBillingController implements Initializable {
    @FXML
    private ComboBox<CaseFile> caseComboBox;

    @FXML
    private TextField totalBillingField;

    @FXML
    private TextField amountPaidField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TableView<Billing> billingTable;

    @FXML
    private TableColumn<Billing, String> billingCaseColumn;

    @FXML
    private TableColumn<Billing, Double> totalBillingColumn;

    @FXML
    private TableColumn<Billing, Double> amountPaidColumn;

    @FXML
    private TableColumn<Billing, Double> remainingColumn;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getCases()));
        caseComboBox.setCellFactory(param -> new ListCell<CaseFile>() {
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
        caseComboBox.setButtonCell(new ListCell<CaseFile>() {
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

        caseComboBox.setOnAction(e -> loadBillingForCase());

        billingCaseColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));
        totalBillingColumn.setCellValueFactory(new PropertyValueFactory<>("totalBilling"));
        amountPaidColumn.setCellValueFactory(new PropertyValueFactory<>("amountPaid"));
        remainingColumn.setCellValueFactory(new PropertyValueFactory<>("remainingBalance"));

        loadAllBillings();
    }

    private void loadBillingForCase() {
        CaseFile selectedCase = caseComboBox.getValue();
        if (selectedCase != null) {
            Billing billing = DataStorage.getInstance().getBillingsByCase(selectedCase.getCaseId())
                .stream().findFirst().orElse(null);
            if (billing != null) {
                totalBillingField.setText(String.valueOf(billing.getTotalBilling()));
                amountPaidField.setText(String.valueOf(billing.getAmountPaid()));
                descriptionArea.setText(billing.getDescription() != null ? billing.getDescription() : "");
            } else {
                totalBillingField.clear();
                amountPaidField.clear();
                descriptionArea.clear();
            }
        }
    }

    private void loadAllBillings() {
        ObservableList<Billing> billings = FXCollections.observableArrayList(DataStorage.getInstance().getBillings());
        billingTable.setItems(billings);
    }

    @FXML
    private void handleAddBilling() {
        CaseFile selectedCase = caseComboBox.getValue();
        if (selectedCase == null) {
            messageLabel.setText("Please select a case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        try {
            double totalBilling = Double.parseDouble(totalBillingField.getText());
            double amountPaid = amountPaidField.getText().isEmpty() ? 0.0 : Double.parseDouble(amountPaidField.getText());

            if (amountPaid > totalBilling) {
                messageLabel.setText("Amount paid cannot exceed total billing");
                messageLabel.setTextFill(javafx.scene.paint.Color.RED);
                messageLabel.setVisible(true);
                return;
            }

            Billing existingBilling = DataStorage.getInstance().getBillingsByCase(selectedCase.getCaseId())
                .stream().findFirst().orElse(null);

            if (existingBilling != null) {
                existingBilling.setTotalBilling(totalBilling);
                existingBilling.setAmountPaid(amountPaid);
                existingBilling.setDescription(descriptionArea.getText());
            } else {
                Billing billing = new Billing(
                    "BILL" + UUID.randomUUID().toString().substring(0, 5).toUpperCase(),
                    selectedCase.getCaseId(),
                    totalBilling
                );
                billing.setAmountPaid(amountPaid);
                billing.setDescription(descriptionArea.getText());
                DataStorage.getInstance().addBilling(billing);
            }

            loadAllBillings();
            messageLabel.setText("Billing information updated successfully!");
            messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            messageLabel.setVisible(true);
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter valid numbers");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
        }
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

