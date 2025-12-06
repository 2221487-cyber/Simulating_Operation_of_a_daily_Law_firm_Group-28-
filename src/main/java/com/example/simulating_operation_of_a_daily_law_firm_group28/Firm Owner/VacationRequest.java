package com.example.simulating_operation_of_a_daily_law_firm_group28.FirmOwner;

import java.time.LocalDate;

public class VacationRequest {
    private String Id;
    private String userID;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String status;

    public String getId() {
        return Id;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "VacationRequest{" +
                "Id='" + Id + '\'' +
                ", userID='" + userID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
