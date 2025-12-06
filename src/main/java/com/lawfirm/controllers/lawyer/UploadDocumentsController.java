package com.lawfirm.controllers.lawyer;

import com.lawfirm.models.CaseFile;
import com.lawfirm.models.Document;
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
import java.util.UUID;

public class UploadDocumentsController implements Initializable {
    @FXML
    private ComboBox<CaseFile> caseComboBox;

    @FXML
    private TextField documentNameField;

    @FXML
    private ComboBox<String> documentTypeComboBox;

    @FXML
    private TableView<Document> documentsTable;

    @FXML
    private TableColumn<Document, String> docNameColumn;

    @FXML
    private TableColumn<Document, String> docTypeColumn;

    @FXML
    private TableColumn<Document, String> docDateColumn;

    @FXML
    private TableColumn<Document, String> docCaseColumn;

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

        documentTypeComboBox.setItems(FXCollections.observableArrayList(
            "Contract", "Evidence", "Court Filing", "Correspondence", "Report", "Other"
        ));

        docNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        docTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        docDateColumn.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
        docCaseColumn.setCellValueFactory(new PropertyValueFactory<>("caseId"));

        loadDocuments();
    }

    private void loadDocuments() {
        ObservableList<Document> allDocuments = FXCollections.observableArrayList();
        DataStorage.getInstance().getCases().forEach(caseFile -> {
            allDocuments.addAll(DataStorage.getInstance().getDocumentsByCase(caseFile.getCaseId()));
        });
        documentsTable.setItems(allDocuments);
    }

    @FXML
    private void handleUploadDocument() {
        CaseFile selectedCase = caseComboBox.getValue();
        String docName = documentNameField.getText();
        String docType = documentTypeComboBox.getValue();

        if (selectedCase == null) {
            messageLabel.setText("Please select a case");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (docName == null || docName.isEmpty()) {
            messageLabel.setText("Please enter document name");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        if (docType == null || docType.isEmpty()) {
            messageLabel.setText("Please select document type");
            messageLabel.setTextFill(javafx.scene.paint.Color.RED);
            messageLabel.setVisible(true);
            return;
        }

        Document document = new Document(
            "DOC" + UUID.randomUUID().toString().substring(0, 5).toUpperCase(),
            docName,
            docType,
            selectedCase.getCaseId()
        );

        DataStorage.getInstance().addDocument(document);
        selectedCase.getDocuments().add(document);
        loadDocuments();

        messageLabel.setText("Document uploaded successfully!");
        messageLabel.setTextFill(javafx.scene.paint.Color.GREEN);
        messageLabel.setVisible(true);

        documentNameField.clear();
        documentTypeComboBox.setValue(null);
    }

    @FXML
    private void handleBack() {
        PageNavigator.navigateTo("/fxml/LawyerDashboard.fxml");
    }
}

