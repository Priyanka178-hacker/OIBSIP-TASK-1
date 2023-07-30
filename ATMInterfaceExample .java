import java.util.Scanner;

interface ATM {
    void checkBalance();
    void deposit();
    void withdraw();
    void exit();
}

class ATMImpl implements ATM {
    private double balance;

    public ATMImpl(double initialBalance) {
        balance = initialBalance;
    }

    @Override
    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    @Override
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Amount deposited successfully. New balance: $" + balance);
    }

    @Override
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Unable to withdraw.");
        }
    }

    @Override
    public void exit() {
        System.out.println("Thank you for using the ATM. Goodbye!");
        System.exit(0);
    }
}

public class ATMInterfaceExample {
    public static void main(String[] args) {
        ATMImpl atm = new ATMImpl(1000.0);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    atm.deposit();
                    break;
                case 3:
                    atm.withdraw();
                    break;
                case 4:
                    atm.exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
