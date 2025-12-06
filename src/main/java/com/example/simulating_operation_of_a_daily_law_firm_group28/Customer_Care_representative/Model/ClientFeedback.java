package com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model;

public class ClientFeedback {
    private String feedbackId;
    private String clientName;
    private int rating;
    private String message;
    private String reply;

    public ClientFeedback(String feedbackId, String clientName, int rating, String message, String reply) {
        this.feedbackId = feedbackId;
        this.clientName = clientName;
        this.rating = rating;
        this.message = message;
        this.reply = reply;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "ClientFeedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", rating=" + rating +
                ", message='" + message + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}
