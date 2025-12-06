package com.example.simulating_operation_of_a_daily_law_firm_group28.Storage;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Customer_Care_representative.Model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Storage manager for Customer Care Representative data
 */
public class CCRStorage {
    private static final String CLIENTS_FILE = "ccr_clients.bin";
    private static final String APPOINTMENTS_FILE = "ccr_appointments.bin";
    private static final String INQUIRIES_FILE = "ccr_inquiries.bin";
    private static final String CASES_FILE = "ccr_cases.bin";
    private static final String FEEDBACK_FILE = "ccr_feedback.bin";

    // Client operations
    public static void saveClient(ClientRegistration client) throws IOException {
        String data = String.format("%s|%s|%s|%s|%s",
                client.getClientId(),
                client.getClientName(),
                client.getContactNumber(),
                client.getCaseType(),
                client.getPreferredLawyer());
        FileStorage.appendToFile(CLIENTS_FILE, data);
    }

    public static List<ClientRegistration> loadClients() throws IOException {
        List<ClientRegistration> clients = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(CLIENTS_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                clients.add(new ClientRegistration(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        }
        return clients;
    }

    // Appointment operations
    public static void saveAppointment(Appointment appointment) throws IOException {
        String data = String.format("%s|%s|%s|%s|%s|%s",
                appointment.getAppointmentId(),
                appointment.getClientId(),
                appointment.getLawyerId(),
                appointment.getAppointmentDate(),
                appointment.getTimeSlot(),
                appointment.getStatus());
        FileStorage.appendToFile(APPOINTMENTS_FILE, data);
    }

    public static List<Appointment> loadAppointments() throws IOException {
        List<Appointment> appointments = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(APPOINTMENTS_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 6) {
                appointments.add(new Appointment(
                        parts[0],
                        parts[1],
                        parts[2],
                        LocalDate.parse(parts[3]),
                        parts[4],
                        parts[5]
                ));
            }
        }
        return appointments;
    }

    // Inquiry operations
    public static void saveInquiry(Inquiry inquiry) throws IOException {
        String data = String.format("%s|%s|%s|%s|%s|%s",
                inquiry.getInquiryId(),
                inquiry.getClientName(),
                inquiry.getDescription(),
                inquiry.getCategory(),
                inquiry.getInquiryDate(),
                inquiry.getStatus());
        FileStorage.appendToFile(INQUIRIES_FILE, data);
    }

    public static List<Inquiry> loadInquiries() throws IOException {
        List<Inquiry> inquiries = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(INQUIRIES_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 6) {
                inquiries.add(new Inquiry(parts[0], parts[1], parts[2], parts[3], LocalDate.parse(parts[4]), parts[5]));
            }
        }
        return inquiries;
    }

    // Case operations
    public static void saveCase(CaseUpdate caseData) throws IOException {
        String data = String.format("%s|%s|%s|%s|%s|%s",
                caseData.getCaseId(),
                caseData.getClientId(),
                caseData.getRemarks(),
                caseData.getLawyerId(),
                caseData.getHearingDate(),
                caseData.getCaseStatus());
        FileStorage.appendToFile(CASES_FILE, data);
    }

    public static List<CaseUpdate> loadCases() throws IOException {
        List<CaseUpdate> cases = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(CASES_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 6) {
                cases.add(new CaseUpdate(parts[0], parts[1], parts[2], parts[3], LocalDate.parse(parts[4]), parts[5]));
            }
        }
        return cases;
    }

    // Feedback operations
    public static void saveFeedback(ClientFeedback feedback) throws IOException {
        String data = String.format("%s|%s|%d|%s|%s",
                feedback.getFeedbackId(),
                feedback.getClientName(),
                feedback.getRating(),
                feedback.getMessage(),
                feedback.getReply());
        FileStorage.appendToFile(FEEDBACK_FILE, data);
    }

    public static List<ClientFeedback> loadFeedback() throws IOException {
        List<ClientFeedback> feedbackList = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(FEEDBACK_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                feedbackList.add(new ClientFeedback(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        parts[3],
                        parts[4]
                ));
            }
        }
        return feedbackList;
    }

    // Clear all CCR data
    public static void clearAllData() throws IOException {
        FileStorage.clearFile(CLIENTS_FILE);
        FileStorage.clearFile(APPOINTMENTS_FILE);
        FileStorage.clearFile(INQUIRIES_FILE);
        FileStorage.clearFile(CASES_FILE);
        FileStorage.clearFile(FEEDBACK_FILE);
    }
}
