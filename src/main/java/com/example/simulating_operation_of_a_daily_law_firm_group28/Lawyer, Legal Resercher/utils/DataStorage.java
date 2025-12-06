package com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.utils;

import com.example.simulating_operation_of_a_daily_law_firm_group28.LawyerLegalResearcher.models.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorage {
    private static DataStorage instance;
    private List<User> users;
    private List<CaseFile> cases;
    private List<Client> clients;
    private List<ResearchRecord> researchRecords;
    private List<Precedent> precedents;
    private List<Document> documents;
    private List<Billing> billings;
    private User currentUser;

    private DataStorage() {
        users = new ArrayList<>();
        cases = new ArrayList<>();
        clients = new ArrayList<>();
        researchRecords = new ArrayList<>();
        precedents = new ArrayList<>();
        documents = new ArrayList<>();
        billings = new ArrayList<>();
        initializeSampleData();
    }

    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    private void initializeSampleData() {
        // Sample Lawyer
        Lawyer lawyer = new Lawyer("John Smith", "lawyer@lawfirm.com", "password", "BAR12345");
        users.add(lawyer);

        // Sample Legal Researcher
        LegalResearcher researcher = new LegalResearcher("Jane Doe", "researcher@lawfirm.com", "password", "EMP67890");
        users.add(researcher);

        // Sample Client
        Client client1 = new Client("CLI001", "ABC Corporation", "abc@corp.com", "555-0101", "123 Main St");
        clients.add(client1);

        // Sample Case
        CaseFile case1 = new CaseFile("CASE001", "Contract Dispute", "Civil", client1, "Breach of contract case");
        cases.add(case1);
        lawyer.getCases().add(case1);
        client1.getCaseHistory().add(case1);

        // Sample Precedents
        precedents.add(new Precedent("PREC001", "Smith v. Jones", "Landmark contract case", "Supreme Court", 2020));
        precedents.add(new Precedent("PREC002", "Doe v. Roe", "Property rights case", "Appellate Court", 2019));
        precedents.add(new Precedent("PREC003", "Brown v. White", "Employment law case", "District Court", 2021));
    }

    public User authenticate(String email, String password) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addCase(CaseFile caseFile) {
        cases.add(caseFile);
        if (currentUser instanceof Lawyer) {
            ((Lawyer) currentUser).getCases().add(caseFile);
        }
    }

    public List<CaseFile> getCases() {
        return cases;
    }

    public void addClient(Client client) {
        clients.add(client);
        if (currentUser instanceof Lawyer) {
            ((Lawyer) currentUser).getClients().add(client);
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addResearchRecord(ResearchRecord record) {
        researchRecords.add(record);
        if (currentUser instanceof LegalResearcher) {
            ((LegalResearcher) currentUser).getResearchRecords().add(record);
        }
    }

    public List<ResearchRecord> getResearchRecords() {
        return researchRecords;
    }

    public void addPrecedent(Precedent precedent) {
        precedents.add(precedent);
    }

    public List<Precedent> getPrecedents() {
        return precedents;
    }

    public void savePrecedentToLibrary(Precedent precedent) {
        if (currentUser instanceof LegalResearcher) {
            ((LegalResearcher) currentUser).getSavedPrecedents().add(precedent);
        }
    }

    public List<Precedent> getSavedPrecedents() {
        if (currentUser instanceof LegalResearcher) {
            return ((LegalResearcher) currentUser).getSavedPrecedents();
        }
        return new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public List<Document> getDocumentsByCase(String caseId) {
        return documents.stream()
                .filter(doc -> doc.getCaseId().equals(caseId))
                .collect(Collectors.toList());
    }

    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    public List<Billing> getBillings() {
        return billings;
    }

    public List<Billing> getBillingsByCase(String caseId) {
        return billings.stream()
                .filter(billing -> billing.getCaseId().equals(caseId))
                .collect(Collectors.toList());
    }

    public List<Precedent> searchPrecedents(String keyword, String court, Integer year) {
        return precedents.stream()
                .filter(p -> (keyword == null || keyword.isEmpty() || 
                             p.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                             p.getSummary().toLowerCase().contains(keyword.toLowerCase()))
                        && (court == null || court.isEmpty() || p.getCourt().equals(court))
                        && (year == null || p.getYear() == year))
                .collect(Collectors.toList());
    }
}

