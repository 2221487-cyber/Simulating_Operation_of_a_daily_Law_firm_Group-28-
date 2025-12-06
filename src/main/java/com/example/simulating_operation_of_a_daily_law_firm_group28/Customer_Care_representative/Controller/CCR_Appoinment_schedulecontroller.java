package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Controller;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.Appointment;
import com.example.simulating_operation_of_a_daily_law_firm_group28.Storage.CCRStorage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CCR_Appoinment_schedulecontroller
{
    @javafx.fxml.FXML
    private Label CBScheduleTime;
    @javafx.fxml.FXML
    private TextField TFScheduleAppoinmentClientname;
    @javafx.fxml.FXML
    private DatePicker DPScheduleAppoinmentDate;
    @javafx.fxml.FXML
    private TextField TFScheduleAppoinmentLawyerId;
    @javafx.fxml.FXML
    private Label TFScheduleClientId;
    @javafx.fxml.FXML
    private Label DPScheduleAppoinment;
    @javafx.fxml.FXML
    private Label TFScheduleLawyerId;
    @javafx.fxml.FXML
    private ComboBox<String> CBScheduleAppoinmentTimeSlots;
    @javafx.fxml.FXML
    private TableView<Appointment> TVAppointments;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colAppointmentId;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colClientId;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colLawyerId;
    @javafx.fxml.FXML
    private TableColumn<Appointment, LocalDate> colDate;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colTimeSlot;
    @javafx.fxml.FXML
    private TableColumn<Appointment, String> colStatus;

    private ObservableList<Appointment> appointmentList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        // Initialize time slots
        CBScheduleAppoinmentTimeSlots.getItems().addAll(
            "09:00 AM", "10:00 AM", "11:00 AM", 
            "02:00 PM", "03:00 PM", "04:00 PM"
        );
        
        // Initialize table columns
        colAppointmentId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        colClientId.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        colLawyerId.setCellValueFactory(new PropertyValueFactory<>("lawyerId"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        colTimeSlot.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        // Load appointments from storage
        loadAppointments();
    }

    @javafx.fxml.FXML
    public void buttonScheduleAppoinmentBack(ActionEvent actionEvent) {
        Stage stage = (Stage) TFScheduleAppoinmentClientname.getScene().getWindow();
        stage.close();
    }

    @javafx.fxml.FXML
    public void buttonScheduleAppoinmentSubmit(ActionEvent actionEvent) {
        try {
            String clientId = TFScheduleAppoinmentClientname.getText();
            String lawyerId = TFScheduleAppoinmentLawyerId.getText();
            LocalDate appointmentDate = DPScheduleAppoinmentDate.getValue();
            String timeSlot = CBScheduleAppoinmentTimeSlots.getValue();

            if (clientId.isEmpty() || lawyerId.isEmpty() || appointmentDate == null || timeSlot == null) {
                showAlert(Alert.AlertType.WARNING, "Validation Error", "Please fill all fields");
                return;
            }

            String appointmentId = "APT" + System.currentTimeMillis();
            Appointment appointment = new Appointment(appointmentId, clientId, lawyerId, appointmentDate, timeSlot, "Scheduled");
            
            // Save to storage
            try {
                CCRStorage.saveAppointment(appointment);
                appointmentList.add(appointment);
                TVAppointments.setItems(appointmentList);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Appointment scheduled and saved successfully!");
                clearFields();
            } catch (IOException e) {
                showAlert(Alert.AlertType.ERROR, "Storage Error", "Failed to save appointment: " + e.getMessage());
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to schedule appointment: " + e.getMessage());
        }
    }

    private void clearFields() {
        TFScheduleAppoinmentClientname.clear();
        TFScheduleAppoinmentLawyerId.clear();
        DPScheduleAppoinmentDate.setValue(null);
        CBScheduleAppoinmentTimeSlots.setValue(null);
    }

    @javafx.fxml.FXML
    public void buttonRefreshAppointments(ActionEvent actionEvent) {
        appointmentList.clear();
        loadAppointments();
        showAlert(Alert.AlertType.INFORMATION, "Refreshed", "Appointments reloaded from storage!");
    }
    
    private void loadAppointments() {
        try {
            List<Appointment> appointments = CCRStorage.loadAppointments();
            appointmentList.addAll(appointments);
            TVAppointments.setItems(appointmentList);
        } catch (IOException e) {
            // No appointments yet or error loading
            TVAppointments.setItems(appointmentList);
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