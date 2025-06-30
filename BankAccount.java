import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;
    private double negativeLimit;

    public BankAccount(String accountNumber, double initialBalance, double negativeLimit) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.negativeLimit = negativeLimit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            transactionHistory.add("Failed deposit: " + amount);
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: " + amount + ", New balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            transactionHistory.add("Failed withdrawal: " + amount);
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amount < negativeLimit) {
            transactionHistory.add("Failed withdrawal: " + amount + " (Negative limit reached)");
            System.out.println("Not allowed, your negative limit is " + negativeLimit);
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrew: " + amount + ", New balance: " + balance);
        return true;
    }
}
