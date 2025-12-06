package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

import java.time.LocalDate;

public class Appointment {
    private String appointmentId;
    private String clientId;
    private String lawyerId;
    private LocalDate appointmentDate;
    private String timeSlot;
    private String status;

    public Appointment(String appointmentId, String clientId, String lawyerId, LocalDate appointmentDate, String timeSlot, String status) {
        this.appointmentId = appointmentId;
        this.clientId = clientId;
        this.lawyerId = lawyerId;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getLawyerId() {
        return lawyerId;
    }

    public void setLawyerId(String lawyerId) {
        this.lawyerId = lawyerId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", lawyerId='" + lawyerId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", timeSlot='" + timeSlot + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
