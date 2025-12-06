package com.lawfirm.controllers.lawyer;

import com.lawfirm.models.CaseFile;
import com.lawfirm.utils.DataStorage;
import com.lawfirm.utils.PageNavigator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ManageHearingDatesController implements Initializable {
    @FXML
    private ComboBox<CaseFile> caseComboBox;

    @FXML
    private DatePicker hearingDatePicker;

    @FXML
    private TableView<CaseFile> hearingsTable;

    @FXML
    private TableColumn<CaseFile, String> caseTitleColumn;

    @FXML
    private TableColumn<CaseFile, LocalDate> hearingDateColumn;

    @FXML
    private TableColumn<CaseFile, String> caseStatusColumn;

    @FXML
    private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseComboBox.setItems(FXCollections.observableArrayList(DataStorage.getInstance().getCases()));
        caseComboBox.setCellFactory(param -> new ListCell<CaseFile>() {
            @Override
            protected void updateItem(CaseFile item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getCaseId() + " - " + item.getTitle());
                }
            }
        });
        caseComboBox.setButtonCell(new ListCell<CaseFile>() {
            @Override
            protected void updateItem(CaseFile item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getCaseId() + " - " + item.getTitle());
                }
            }
        });

        caseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        hearingDateColumn.setCellValueFactory(new PropertyValueFactory<>("hearingDate"));
        caseStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadUpcomingHearings();
    }

    private void loadUpcomingHearings() {
        ObservableList<CaseFile> upcomingCases = FXCollections.observableArrayList(
            DataStorage.getInstance().getCases().stream()
                .filter(c -> c.getHearingDate() != null && !c.isClosed())
                .collect(Collectors.toList())
        );
        hearingsTable.setItems(upcomingCases);
    }

    @FXML
    private void handleUpdateHearingDate() {
        CaseFile selectedCase = caseComboBox.getValue();
        LocalDate hearingDate = hearingDatePicker.getValue();

        if (selectedCase == null) {
            messageLabel.setText("Please select a case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (hearingDate == null) {
            messageLabel.setText("Please select a hearing date");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (selectedCase.isClosed()) {
            messageLabel.setText("Cannot update hearing date for a closed case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        selectedCase.setHearingDate(hearingDate);
        loadUpcomingHearings();

        messageLabel.setText("Hearing date updated successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

