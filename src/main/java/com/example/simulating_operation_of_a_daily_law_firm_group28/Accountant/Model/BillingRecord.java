package com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model;

import java.time.LocalDateTime;

public class BillingRecord {
    private Invoice invoice;
    private LocalDateTime timestamp;

    @Override
    public String toString() {
        return "BillingRecord{" +
                "invoice=" + invoice +
                ", timestamp=" + timestamp +
                '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public BillingRecord(Invoice invoice, LocalDateTime timestamp) {
        this.invoice = invoice;
        this.timestamp = timestamp;
    }
}
