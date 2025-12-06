package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.OutstandingBalance;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;

public class Acc_OutstandingBalanceController
{
    @javafx.fxml.FXML
    private TableColumn<OutstandingBalance, LocalDate> dueDateCol;
    @javafx.fxml.FXML
    private Label outstandingInfoLabel;
    @javafx.fxml.FXML
    private TableColumn<OutstandingBalance, String> clientNameCol;
    @javafx.fxml.FXML
    private Button outstandingBalanceBtn;
    @javafx.fxml.FXML
    private TableView<OutstandingBalance> outstandingTable;
    @javafx.fxml.FXML
    private TableColumn<OutstandingBalance, Double> amountDueCol;

    private ObservableList<OutstandingBalance> balanceList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        clientNameCol.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        amountDueCol.setCellValueFactory(new PropertyValueFactory<>("amountDue"));
        dueDateCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        
        // Load existing balances from storage
        try {
            balanceList.addAll(AccountantStorage.loadBalances());
            outstandingInfoLabel.setText("Loaded " + balanceList.size() + " outstanding balances");
        } catch (IOException e) {
            outstandingInfoLabel.setText("No outstanding balances found");
        }
    }

    @javafx.fxml.FXML
    public void viewOutstanding(ActionEvent actionEvent) {
        try {
            balanceList.clear();
            balanceList.addAll(AccountantStorage.loadBalances());
            outstandingTable.setItems(balanceList);
            outstandingInfoLabel.setText("Displaying " + balanceList.size() + " outstanding balances");
        } catch (IOException e) {
            outstandingInfoLabel.setText("Failed to load balances: " + e.getMessage());
        }
    }
}