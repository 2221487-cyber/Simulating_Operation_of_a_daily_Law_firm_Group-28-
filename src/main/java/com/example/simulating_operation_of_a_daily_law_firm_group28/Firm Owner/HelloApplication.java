package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Firm_Owner.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Firm Owner Dashboard - Law Firm Management System");
        stage.setScene(scene);
        stage.show();
    }
}
