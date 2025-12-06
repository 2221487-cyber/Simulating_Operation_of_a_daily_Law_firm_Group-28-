package com.lawfirm;

import com.lawfirm.utils.PageNavigator;
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

