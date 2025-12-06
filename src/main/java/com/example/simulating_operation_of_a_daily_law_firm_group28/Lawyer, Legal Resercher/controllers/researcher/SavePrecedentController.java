package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.Precedent;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SavePrecedentController implements Initializable {
    @FXML
    private ComboBox<Precedent> precedentComboBox;

    @FXML
    private TableView<Precedent> savedTable;

    @FXML
    private TableColumn<Precedent, String> savedTitleColumn;

    @FXML
    private TableColumn<Precedent, String> savedCourtColumn;

    @FXML
    private TableColumn<Precedent, Integer> savedYearColumn;

    @FXML
    private TableColumn<Precedent, String> savedSummaryColumn;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        precedentComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getPrecedents()));
        precedentComboBox.setCellFactory(param -> new ListCell<Precedent>() {
            @Override
            protected void updateItem(Precedent item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTitle() + " (" + item.getCourt() + ", " + item.getYear() + ")");
                }
            }
        });
        precedentComboBox.setButtonCell(new ListCell<Precedent>() {
            @Override
            protected void updateItem(Precedent item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTitle() + " (" + item.getCourt() + ", " + item.getYear() + ")");
                }
            }
        });

        savedTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        savedCourtColumn.setCellValueFactory(new PropertyValueFactory<>("court"));
        savedYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        savedSummaryColumn.setCellValueFactory(new PropertyValueFactory<>("summary"));

        loadSavedPrecedents();
    }

    private void loadSavedPrecedents() {
        ObservableList<Precedent> saved = FXCollections.observableArrayList(DataStorage.getInstance().getSavedPrecedents());
        savedTable.setItems(saved);
    }

    @FXML
    private void handleSavePrecedent() {
        Precedent selectedPrecedent = precedentComboBox.getValue();
        if (selectedPrecedent == null) {
            messageLabel.setText("Please select a precedent");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        // Check if already saved
        if (DataStorage.getInstance().getSavedPrecedents().contains(selectedPrecedent)) {
            messageLabel.setText("This precedent is already in your library");
            messageLabel.setTextFill(javafx.scene.paint.Color.ORANGE);
            messageLabel.setVisible(true);
            return;
        }

        DataStorage.getInstance().savePrecedentToLibrary(selectedPrecedent);
        loadSavedPrecedents();

        messageLabel.setText("Precedent saved to library successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

