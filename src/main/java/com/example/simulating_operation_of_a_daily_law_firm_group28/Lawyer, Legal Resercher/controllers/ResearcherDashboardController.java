package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ResearcherDashboardController implements Initializable {
    @FXML
    private Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (DataStorage.getInstance().getCurrentUser() != null) {
            welcomeLabel.setText("Welcome, " + DataStorage.getInstance().getCurrentUser().getName());
        }
    }

    @FXML
    private void navigateToCreateResearch() {
        PageNavigator.navigateTo("/fxml/researcher/CreateResearchRecordPage.fxml");
    }

    @FXML
    private void navigateToSearchPrecedents() {
        PageNavigator.navigateTo("/fxml/researcher/SearchPrecedentsPage.fxml");
    }

    @FXML
    private void navigateToSavePrecedent() {
        PageNavigator.navigateTo("/fxml/researcher/SavePrecedentPage.fxml");
    }

    @FXML
    private void navigateToGenerateSummary() {
        PageNavigator.navigateTo("/fxml/researcher/GenerateResearchSummaryPage.fxml");
    }

    @FXML
    private void navigateToComparePrecedents() {
        PageNavigator.navigateTo("/fxml/researcher/ComparePrecedentsPage.fxml");
    }

    @FXML
    private void navigateToExportReport() {
        PageNavigator.navigateTo("/fxml/researcher/ExportResearchReportPage.fxml");
    }

    @FXML
    private void navigateToEditResearch() {
        PageNavigator.navigateTo("/fxml/researcher/EditResearchRecordPage.fxml");
    }

    @FXML
    private void navigateToViewHistory() {
        PageNavigator.navigateTo("/fxml/researcher/ViewResearchHistoryPage.fxml");
    }

    @FXML
    private void handleLogout() {
        DataStorage.getInstance().setCurrentUser(null);
        PageNavigator.navigateTo("/fxml/LoginPage.fxml");
    }
}

