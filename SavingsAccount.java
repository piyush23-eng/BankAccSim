public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double negativeLimit, double interestRate) {
        super(accountNumber, initialBalance, negativeLimit);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        getTransactionHistory().add("Interest added: " + interest);
    }
}

