package com.lawfirm.controllers.researcher;

import com.lawfirm.models.Precedent;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchPrecedentsController implements Initializable {
    @FXML
    private TextField keywordField;

    @FXML
    private TextField courtField;

    @FXML
    private TextField yearField;

    @FXML
    private TableView<Precedent> resultsTable;

    @FXML
    private TableColumn<Precedent, String> titleColumn;

    @FXML
    private TableColumn<Precedent, String> courtColumn;

    @FXML
    private TableColumn<Precedent, Integer> yearColumn;

    @FXML
    private TableColumn<Precedent, String> summaryColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        courtColumn.setCellValueFactory(new PropertyValueFactory<>("court"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));
    }

    @FXML
    private void handleSearch() {
        String keyword = keywordField.getText();
        String court = courtField.getText();
        Integer year = null;

        try {
            if (!yearField.getText().isEmpty()) {
                year = Integer.parseInt(yearField.getText());
            }
        } catch (NumberFormatException e) {
            // Invalid year, ignore
        }

        java.util.List<Precedent> results = DataStorage.getInstance().searchPrecedents(keyword, court, year);
        ObservableList<Precedent> resultsList = FXCollections.observableArrayList(results);
        resultsTable.setItems(resultsList);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

