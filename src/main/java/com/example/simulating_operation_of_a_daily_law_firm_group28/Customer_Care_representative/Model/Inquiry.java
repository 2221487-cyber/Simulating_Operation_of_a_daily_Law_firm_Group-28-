package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

import java.time.LocalDate;

public class Inquiry {
    private String inquiryId;
    private String clientName;
    private String description;
    private String category;
    private LocalDate inquiryDate;
    private String status;

    public Inquiry(String inquiryId, String clientName, String description, String category, LocalDate inquiryDate, String status) {
        this.inquiryId = inquiryId;
        this.clientName = clientName;
        this.description = description;
        this.category = category;
        this.inquiryDate = inquiryDate;
        this.status = status;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "inquiryId='" + inquiryId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", inquiryDate=" + inquiryDate +
                ", status='" + status + '\'' +
                '}';
    }
}
