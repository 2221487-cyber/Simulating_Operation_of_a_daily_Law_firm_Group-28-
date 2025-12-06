package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.controllers.researcher;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.Precedent;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.DataStorage;
import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ComparePrecedentsController implements Initializable {
    @FXML
    private ComboBox<Precedent> precedent1ComboBox;

    @FXML
    private ComboBox<Precedent> precedent2ComboBox;

    @FXML
    private TextArea precedent1Area;

    @FXML
    private TextArea precedent2Area;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        precedent1ComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getPrecedents()));
        precedent1ComboBox.setCellFactory(param -> new javafx.scene.control.ListCell<Precedent>() {
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
        precedent1ComboBox.setButtonCell(new javafx.scene.control.ListCell<Precedent>() {
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

        precedent2ComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getPrecedents()));
        precedent2ComboBox.setCellFactory(param -> new javafx.scene.control.ListCell<Precedent>() {
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
        precedent2ComboBox.setButtonCell(new javafx.scene.control.ListCell<Precedent>() {
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
    }

    @FXML
    private void handleCompare() {
        Precedent p1 = precedent1ComboBox.getValue();
        Precedent p2 = precedent2ComboBox.getValue();

        if (p1 == null || p2 == null) {
            precedent1Area.setText("Please select both precedents to compare");
            precedent2Area.setText("");
            return;
        }

        if (p1.equals(p2)) {
            precedent1Area.setText("Please select two different precedents");
            precedent2Area.setText("");
            return;
        }

        StringBuilder details1 = new StringBuilder();
        details1.append("Title: ").append(p1.getTitle()).append("\n\n");
        details1.append("Court: ").append(p1.getCourt()).append("\n\n");
        details1.append("Year: ").append(p1.getYear()).append("\n\n");
        details1.append("Summary:\n").append(p1.getSummary());
        precedent1Area.setText(details1.toString());

        StringBuilder details2 = new StringBuilder();
        details2.append("Title: ").append(p2.getTitle()).append("\n\n");
        details2.append("Court: ").append(p2.getCourt()).append("\n\n");
        details2.append("Year: ").append(p2.getYear()).append("\n\n");
        details2.append("Summary:\n").append(p2.getSummary());
        precedent2Area.setText(details2.toString());
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/ResearcherDashboard.fxml");
    }
}

