import java.util.Scanner;

public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount("123456", 0, -200);

        while (true) {
            System.out.println("\nYour current balance is " + account.getBalance());
            System.out.println("Type 1 for Withdrawal");
            System.out.println("Type 2 for Deposit");
            System.out.println("Type 3 to quit");
            System.out.print("Your choice? ");
            int choice = scanner.nextInt();

            if (choice == 3) break;

            System.out.print("Amount? ");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    account.withdraw(amount);
                    break;
                case 2:
                    account.deposit(amount);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("\nTransaction History:");
        for (String entry : account.getTransactionHistory()) {
            System.out.println(entry);
        }
        scanner.close();
    }
}
