package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.ResearchRecord;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewResearchHistoryController implements Initializable {
    @FXML
    private TableView<ResearchRecord> historyTable;

    @FXML
    private TableColumn<ResearchRecord, String> topicColumn;

    @FXML
    private TableColumn<ResearchRecord, String> dateColumn;

    @FXML
    private TableColumn<ResearchRecord, String> summaryColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
        summaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));

        loadHistory();
    }

    private void loadHistory() {
        ObservableList<ResearchRecord> records = FXCollections.observableArrayList(DataStorage.getInstance().getResearchRecords());
        historyTable.setItems(records);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

