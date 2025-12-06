package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.CashFlow;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class Acc_CashFlowController
{
    @javafx.fxml.FXML
    private TableColumn<CashFlow, String> cashFlowIdCol;
    @javafx.fxml.FXML
    private TableColumn<CashFlow, LocalDate> dateCol;
    @javafx.fxml.FXML
    private TableColumn<CashFlow, Double> incomeCol;
    @javafx.fxml.FXML
    private TableColumn<CashFlow, Double> netCashCol;
    @javafx.fxml.FXML
    private TableColumn<CashFlow, Double> expenseCol;
    @javafx.fxml.FXML
    private Button cashFlowBtn;
    @javafx.fxml.FXML
    private LineChart<String, Number> projectionChart;
    @javafx.fxml.FXML
    private TableView<CashFlow> cashFlowDataTable;
    @javafx.fxml.FXML
    private Label forecastDashboardArea;

    private ObservableList<CashFlow> cashFlowList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        cashFlowIdCol.setCellValueFactory(new PropertyValueFactory<>("cashFlowId"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        incomeCol.setCellValueFactory(new PropertyValueFactory<>("income"));
        expenseCol.setCellValueFactory(new PropertyValueFactory<>("expense"));
        netCashCol.setCellValueFactory(new PropertyValueFactory<>("netCash"));

        // Load data from storage
        loadCashFlowData();
    }

    private void loadCashFlowData() {
        try {
            cashFlowList.clear();
            cashFlowList.addAll(AccountantStorage.loadCashFlow());
            
            // If no data, add sample data
            if (cashFlowList.isEmpty()) {
                CashFlow cf1 = new CashFlow("CF001", LocalDate.now().minusDays(30), 50000, 30000, 20000);
                CashFlow cf2 = new CashFlow("CF002", LocalDate.now().minusDays(20), 60000, 35000, 25000);
                CashFlow cf3 = new CashFlow("CF003", LocalDate.now().minusDays(10), 55000, 32000, 23000);
                
                AccountantStorage.saveCashFlow(cf1);
                AccountantStorage.saveCashFlow(cf2);
                AccountantStorage.saveCashFlow(cf3);
                
                cashFlowList.addAll(AccountantStorage.loadCashFlow());
            }
            
            cashFlowDataTable.setItems(cashFlowList);
        } catch (IOException e) {
            showAlert(Alert.AlertType.WARNING, "Storage Error", "Could not load cash flow data: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void viewCashFlow(ActionEvent actionEvent) {
        try {
            // Update chart
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Net Cash Flow");
            for (CashFlow cf : cashFlowList) {
                series.getData().add(new XYChart.Data<>(cf.getDate().toString(), cf.getNetCash()));
            }
            projectionChart.getData().clear();
            projectionChart.getData().add(series);

            forecastDashboardArea.setText("Cash flow forecast loaded successfully");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to load cash flow: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}