package com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LawFirmApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lawfirm/dashboard.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 900, 700);
        primaryStage.setTitle("CourtAlert - Law Firm Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
