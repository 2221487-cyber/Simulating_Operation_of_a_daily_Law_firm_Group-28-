package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LawyerDashboardController implements Initializable {
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (DataStorage.getInstance().getCurrentUser() != null) {
            welcomeLabel.setText("Welcome, " + DataStorage.getInstance().getCurrentUser().getName());
        }
    }

    @FXML
    private void navigateToCreateCase() {
        PageNavigator.navigateTo("/fxml/lawyer/CreateCasePage.fxml");
    }

    @FXML
    private void navigateToUpdateStatus() {
        PageNavigator.navigateTo("/fxml/lawyer/UpdateCaseStatusPage.fxml");
    }

    @FXML
    private void navigateToManageHearing() {
        PageNavigator.navigateTo("/fxml/lawyer/ManageHearingDatesPage.fxml");
    }

    @FXML
    private void navigateToUploadDocuments() {
        PageNavigator.navigateTo("/fxml/lawyer/UploadDocumentsPage.fxml");
    }

    @FXML
    private void navigateToViewClient() {
        PageNavigator.navigateTo("/fxml/lawyer/ViewClientDetailsPage.fxml");
    }

    @FXML
    private void navigateToGenerateReport() {
        PageNavigator.navigateTo("/fxml/lawyer/GenerateCaseReportPage.fxml");
    }

    @FXML
    private void navigateToTrackBilling() {
        PageNavigator.navigateTo("/fxml/lawyer/TrackBillingPage.fxml");
    }

    @FXML
    private void navigateToCloseCase() {
        PageNavigator.navigateTo("/fxml/lawyer/CloseCasePage.fxml");
    }

    @FXML
    private void handleLogout() {
        DataStorage.getInstance().setCurrentUser(null);
        PageNavigator.navigateTo("/fxml/LoginPage.fxml");
    }
}

