package com.example.simulating_operation_of_a_daily_law_firm_group28.Storage;

import com.example.simulating_operation_of_a_daily_law_firm_group28.Accountant.Model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Storage manager for Accountant data
 */
public class AccountantStorage {
    private static final String PAYMENTS_FILE = "acc_payments.bin";
    private static final String EXPENSES_FILE = "acc_expenses.bin";
    private static final String COMMISSIONS_FILE = "acc_commissions.bin";
    private static final String BALANCES_FILE = "acc_balances.bin";
    private static final String CASHFLOW_FILE = "acc_cashflow.bin";
    private static final String REPORTS_FILE = "acc_reports.bin";

    // Payment operations
    public static void savePayment(Payment payment) throws IOException {
        String data = String.format("%s|%s|%.2f|%s|%s|%s",
                payment.getPaymentId(),
                payment.getClientId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getPaymentDate(),
                payment.getInvoiceNumber());
        FileStorage.appendToFile(PAYMENTS_FILE, data);
    }

    public static List<Payment> loadPayments() throws IOException {
        List<Payment> payments = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(PAYMENTS_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 6) {
                payments.add(new Payment(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        parts[3],
                        LocalDate.parse(parts[4]),
                        parts[5]
                ));
            }
        }
        return payments;
    }

    // Expense operations
    public static void saveExpense(Expense expense) throws IOException {
        String data = String.format("%s|%s|%.2f|%s|%s",
                expense.getExpenseId(),
                expense.getCategory(),
                expense.getAmount(),
                expense.getDate(),
                expense.getDescription());
        FileStorage.appendToFile(EXPENSES_FILE, data);
    }

    public static List<Expense> loadExpenses() throws IOException {
        List<Expense> expenses = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(EXPENSES_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                expenses.add(new Expense(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        LocalDate.parse(parts[3]),
                        parts[4]
                ));
            }
        }
        return expenses;
    }

    // Commission operations
    public static void saveCommission(LawyerCommission commission) throws IOException {
        String data = String.format("%s|%s|%.2f|%.2f|%.2f",
                commission.getLawyerId(),
                commission.getLawyerName(),
                commission.getCommissionPercentage(),
                commission.getTotalBilled(),
                commission.getCommissionAmount());
        FileStorage.appendToFile(COMMISSIONS_FILE, data);
    }

    public static List<LawyerCommission> loadCommissions() throws IOException {
        List<LawyerCommission> commissions = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(COMMISSIONS_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                commissions.add(new LawyerCommission(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4])
                ));
            }
        }
        return commissions;
    }

    // Outstanding Balance operations
    public static void saveBalance(OutstandingBalance balance) throws IOException {
        String data = String.format("%s|%s|%.2f|%s|%s",
                balance.getClientId(),
                balance.getClientName(),
                balance.getAmountDue(),
                balance.getDueDate(),
                balance.getStatus());
        FileStorage.appendToFile(BALANCES_FILE, data);
    }

    public static List<OutstandingBalance> loadBalances() throws IOException {
        List<OutstandingBalance> balances = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(BALANCES_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                balances.add(new OutstandingBalance(
                        parts[0],
                        parts[1],
                        Double.parseDouble(parts[2]),
                        LocalDate.parse(parts[3]),
                        parts[4]
                ));
            }
        }
        return balances;
    }

    // Cash Flow operations
    public static void saveCashFlow(CashFlow cashFlow) throws IOException {
        String data = String.format("%s|%s|%.2f|%.2f|%.2f",
                cashFlow.getCashFlowId(),
                cashFlow.getDate(),
                cashFlow.getIncome(),
                cashFlow.getExpense(),
                cashFlow.getNetCash());
        FileStorage.appendToFile(CASHFLOW_FILE, data);
    }

    public static List<CashFlow> loadCashFlow() throws IOException {
        List<CashFlow> cashFlows = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(CASHFLOW_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 5) {
                cashFlows.add(new CashFlow(
                        parts[0],
                        LocalDate.parse(parts[1]),
                        Double.parseDouble(parts[2]),
                        Double.parseDouble(parts[3]),
                        Double.parseDouble(parts[4])
                ));
            }
        }
        return cashFlows;
    }

    // Financial Report operations
    public static void saveFinancialReport(FinancialReport report) throws IOException {
        String data = String.format("%s|%.2f",
                report.getCategory(),
                report.getAmount());
        FileStorage.appendToFile(REPORTS_FILE, data);
    }

    public static List<FinancialReport> loadFinancialReports() throws IOException {
        List<FinancialReport> reports = new ArrayList<>();
        List<String> lines = FileStorage.readFromFile(REPORTS_FILE);
        
        for (String line : lines) {
            String[] parts = line.split("\\|");
            if (parts.length == 2) {
                reports.add(new FinancialReport(
                        parts[0],
                        Double.parseDouble(parts[1])
                ));
            }
        }
        return reports;
    }

    // Clear all Accountant data
    public static void clearAllData() throws IOException {
        FileStorage.clearFile(PAYMENTS_FILE);
        FileStorage.clearFile(EXPENSES_FILE);
        FileStorage.clearFile(COMMISSIONS_FILE);
        FileStorage.clearFile(BALANCES_FILE);
        FileStorage.clearFile(CASHFLOW_FILE);
        FileStorage.clearFile(REPORTS_FILE);
    }
}
