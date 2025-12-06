package com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationUtil {
    public static void navigateTo(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void navigateToGoal(Stage stage, int goalNumber) {
        String fxmlPath = "/com/lawfirm/goal" + goalNumber + ".fxml";
        navigateTo(stage, fxmlPath, "Goal " + goalNumber);
    }

    public static void navigateToDashboard(Stage stage) {
        navigateTo(stage, "/com/lawfirm/dashboard.fxml", "CourtAlert - Dashboard");
    }

    public static void navigateToNewClient(Stage stage) {
        navigateTo(stage, "/com/lawfirm/new_client.fxml", "New Client");
    }
}
