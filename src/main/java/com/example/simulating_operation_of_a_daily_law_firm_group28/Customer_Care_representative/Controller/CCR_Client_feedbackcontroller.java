package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.ClientFeedback;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.Inquiry;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.CCRStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CCR_Client_feedbackcontroller
{
    @javafx.fxml.FXML
    private TableView<ClientFeedback> TVViewFeedback;
    @javafx.fxml.FXML
    private TableColumn<ClientFeedback, String> TCclientname;
    @javafx.fxml.FXML
    private TableColumn<ClientFeedback, String> TcFeedBackid;
    @javafx.fxml.FXML
    private TableColumn<ClientFeedback, String> TCViewFeedbackMassage;
    @javafx.fxml.FXML
    private TableColumn<ClientFeedback, Integer> TCViewfeedbackRating;
    @javafx.fxml.FXML
    private Label labelReplytoclient;
    @javafx.fxml.FXML
    private TextArea TAViewFeedbackReply;

    private ObservableList<ClientFeedback> feedbackList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize table columns
        TcFeedBackid.setCellValueFactory(new PropertyValueFactory<>("feedbackId"));
        TCclientname.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        TCViewfeedbackRating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        TCViewFeedbackMassage.setCellValueFactory(new PropertyValueFactory<>("message"));

        // Load sample data
        loadFeedbackData();
    }

    private void loadFeedbackData() {
        try {
            // Load inquiries from storage and convert to feedback format
            List<Inquiry> inquiries = CCRStorage.loadInquiries();
            
            for (Inquiry inquiry : inquiries) {
                // Convert inquiry to feedback (rating based on category)
                int rating = getCategoryRating(inquiry.getCategory());
                String message = String.format("[%s] %s", inquiry.getCategory(), inquiry.getDescription());
                
                ClientFeedback feedback = new ClientFeedback(
                    inquiry.getInquiryId(),
                    inquiry.getClientName(),
                    rating,
                    message,
                    ""
                );
                feedbackList.add(feedback);
            }
            
            // Also load actual feedback from storage
            List<ClientFeedback> storedFeedback = CCRStorage.loadFeedback();
            feedbackList.addAll(storedFeedback);
            
            // If no data, add sample data
            if (feedbackList.isEmpty()) {
                feedbackList.add(new ClientFeedback("FB001", "John Doe", 5, "Excellent service", ""));
                feedbackList.add(new ClientFeedback("FB002", "Jane Smith", 4, "Very satisfied", ""));
            }
            
            TVViewFeedback.setItems(feedbackList);
        } catch (IOException e) {
            // If loading fails, show sample data
            feedbackList.add(new ClientFeedback("FB001", "John Doe", 5, "Excellent service", ""));
            feedbackList.add(new ClientFeedback("FB002", "Jane Smith", 4, "Very satisfied", ""));
            TVViewFeedback.setItems(feedbackList);
        }
    }
    
    private int getCategoryRating(String category) {
        // Assign default ratings based on inquiry category
        switch (category) {
            case "General Inquiry":
                return 3;
            case "Case Status":
                return 4;
            case "Billing Question":
                return 3;
            case "Appointment Request":
                return 4;
            case "Document Request":
                return 3;
            default:
                return 3;
        }
    }

    @javafx.fxml.FXML
    public void buttonRefreshFeedback(ActionEvent actionEvent) {
        feedbackList.clear();
        loadFeedbackData();
        showAlert(Alert.AlertType.INFORMATION, "Refreshed", "Feedback and inquiry data reloaded successfully!");
    }

    @javafx.fxml.FXML
    public void buttonViewFeedbackBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TAViewFeedbackReply.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void buttonSendFeedbackReply(ActionEvent actionEvent) {
        ClientFeedback selectedFeedback = TVViewFeedback.getSelectionModel().getSelectedItem();
        String reply = TAViewFeedbackReply.getText();

        if (selectedFeedback == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a feedback to reply");
            return;
        }

        if (reply.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "Please enter a reply");
            return;
        }

        selectedFeedback.setReply(reply);
        showAlert(Alert.AlertType.INFORMATION, "Success", "Reply sent successfully!");
        TAViewFeedbackReply.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}