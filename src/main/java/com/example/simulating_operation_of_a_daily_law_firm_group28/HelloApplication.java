package com.example.simulating_operation_of_a_daily_law_firm_group28;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            HelloApplication.class.getResource("/com/example/simulating_operation_of_a_daily_law_firm_group28/Customer_Care_representative/CCR.fxml")
        );
        
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Law Firm Management System - Customer Care Representative");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

