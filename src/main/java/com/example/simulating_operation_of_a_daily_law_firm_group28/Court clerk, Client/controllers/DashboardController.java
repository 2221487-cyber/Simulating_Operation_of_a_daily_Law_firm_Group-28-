package com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.controllers;

import com.example.simulating_operation_of_a_daily_law_firm_group28.CourtClerkClient.utils.NavigationUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private Button btnNewClient;

    @FXML
    private Button btnGoal1, btnGoal2, btnGoal3, btnGoal4, btnGoal5, btnGoal6, btnGoal7, btnGoal8,
                   btnGoal9, btnGoal10, btnGoal11, btnGoal12, btnGoal13, btnGoal14, btnGoal15, btnGoal16;

    @FXML
    private void initialize() {
        setupButtonHandlers();
    }

    private void setupButtonHandlers() {
        btnNewClient.setOnAction(e -> {
            Stage stage = (Stage) btnNewClient.getScene().getWindow();
            NavigationUtil.navigateToNewClient(stage);
        });

        btnGoal1.setOnAction(e -> navigateToGoal(1));
        btnGoal2.setOnAction(e -> navigateToGoal(2));
        btnGoal3.setOnAction(e -> navigateToGoal(3));
        btnGoal4.setOnAction(e -> navigateToGoal(4));
        btnGoal5.setOnAction(e -> navigateToGoal(5));
        btnGoal6.setOnAction(e -> navigateToGoal(6));
        btnGoal7.setOnAction(e -> navigateToGoal(7));
        btnGoal8.setOnAction(e -> navigateToGoal(8));
        btnGoal9.setOnAction(e -> navigateToGoal(9));
        btnGoal10.setOnAction(e -> navigateToGoal(10));
        btnGoal11.setOnAction(e -> navigateToGoal(11));
        btnGoal12.setOnAction(e -> navigateToGoal(12));
        btnGoal13.setOnAction(e -> navigateToGoal(13));
        btnGoal14.setOnAction(e -> navigateToGoal(14));
        btnGoal15.setOnAction(e -> navigateToGoal(15));
        btnGoal16.setOnAction(e -> navigateToGoal(16));
    }

    private void navigateToGoal(int goalNumber) {
        Stage stage = (Stage) btnGoal1.getScene().getWindow();
        NavigationUtil.navigateToGoal(stage, goalNumber);
    }
}
