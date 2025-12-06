package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.Expense;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.AccountantStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Acc_ManageExpensesController
{
    @javafx.fxml.FXML
    private Label expenseConfirmationLabel;
    @javafx.fxml.FXML
    private DatePicker expenseDatePicker;
    @javafx.fxml.FXML
    private Button saveExpenseBtn;
    @javafx.fxml.FXML
    private Button recordExpenseBtn;
    @javafx.fxml.FXML
    private TextField expenseAmountField;
    @javafx.fxml.FXML
    private Button validateExpenseBtn;
    @javafx.fxml.FXML
    private TextField expenseCategoryField;
    @javafx.fxml.FXML
    private TableView<Expense> expenseTable;
    @javafx.fxml.FXML
    private TableColumn<Expense, String> expenseIdCol;
    @javafx.fxml.FXML
    private TableColumn<Expense, String> categoryCol;
    @javafx.fxml.FXML
    private TableColumn<Expense, Double> expenseAmountCol;
    @javafx.fxml.FXML
    private TableColumn<Expense, LocalDate> expenseDateCol;
    @javafx.fxml.FXML
    private TableColumn<Expense, String> descriptionCol;

    private ObservableList<Expense> expenseList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        expenseIdCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        expenseAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        expenseDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        

        loadExpenses();
    }
    
    private void loadExpenses() {
        try {
            expenseList.clear();
            expenseList.addAll(AccountantStorage.loadExpenses());
            expenseTable.setItems(expenseList);
            expenseConfirmationLabel.setText("Loaded " + expenseList.size() + " existing expenses");
        } catch (IOException e) {
            expenseConfirmationLabel.setText("Ready to record expense");
        }
    }

    @javafx.fxml.FXML
    public void validateExpense(ActionEvent actionEvent) {
        if (expenseAmountField.getText().isEmpty() || expenseCategoryField.getText().isEmpty()) {
            expenseConfirmationLabel.setText("Please fill all fields");
        } else {
            expenseConfirmationLabel.setText("Expense validated");
        }
    }

    @javafx.fxml.FXML
    public void recordExpense(ActionEvent actionEvent) {
        saveExpense(actionEvent);
    }

    @javafx.fxml.FXML
    public void saveExpense(ActionEvent actionEvent) {
        try {
            String category = expenseCategoryField.getText();
            double amount = Double.parseDouble(expenseAmountField.getText());
            LocalDate date = expenseDatePicker.getValue();

            if (category.isEmpty() || date == null) {
                expenseConfirmationLabel.setText("Please fill all fields");
                return;
            }

            String expenseId = "EXP" + System.currentTimeMillis();
            Expense expense = new Expense(expenseId, category, amount, date, "Recorded expense");
            

            try {
                AccountantStorage.saveExpense(expense);
                loadExpenses(); // Refresh table
                expenseConfirmationLabel.setText("Expense saved successfully!");
                clearFields();
            } catch (IOException e) {
                expenseConfirmationLabel.setText("Failed to save expense: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            expenseConfirmationLabel.setText("Invalid amount");
        }
    }

    private void clearFields() {
        expenseCategoryField.clear();
        expenseAmountField.clear();
        expenseDatePicker.setValue(null);
    }
}