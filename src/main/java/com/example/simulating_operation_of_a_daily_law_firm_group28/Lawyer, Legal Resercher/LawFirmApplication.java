package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class LawFirmApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        PageNavigator.setPrimaryStage(primaryStage);
        PageNavigator.navigateTo("/fxml/LoginPage.fxml");
        primaryStage.setTitle("Law Firm Management System");
        primaryStage.setResizable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

