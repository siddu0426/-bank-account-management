package myprojects;

import java.util.*;

public class BankAccountManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANK ACCOUNT MANAGEMENT SYSTEM =====");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Display All Accounts");
            System.out.println("6. View Transaction History");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");

            try {

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        depositMoney();
                        break;

                    case 3:
                        withdrawMoney();
                        break;

                    case 4:
                        displaySingleAccount();
                        break;

                    case 5:
                        displayAllAccounts();
                        break;

                    case 6:
                        showTransactionHistory();
                        break;

                    case 7:
                        deleteAccount();
                        break;

                    case 8:
                        System.out.println("Thank you for using the system.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine();

            }
        }
    }

    static void createAccount() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        if (findAccount(accountNumber) != null) {
            System.out.println("Account already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
                new BankAccount(balance, accountNumber, name);

        accounts.add(account);

        System.out.println("Account created successfully.");
    }

    static void depositMoney() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        account.deposit(amount);
    }

    static void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        account.withdraw(amount);
    }

    static void displaySingleAccount() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayAccountDetails();
    }

    static void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            System.out.println("---------------------");
        }
    }

    static void showTransactionHistory() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayTransactions();
    }

    static void deleteAccount() {

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.next();

        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        accounts.remove(account);

        System.out.println("Account deleted successfully.");
    }

    static BankAccount findAccount(String accountNumber) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }
}

class BankAccount {

    private double balance;
    private String accountNumber;
    private String name;

    private ArrayList<String> transactions =
            new ArrayList<>();

    public BankAccount(double balance,
                       String accountNumber,
                       String name) {

        this.balance = balance;
        this.accountNumber = accountNumber;
        this.name = name;

        transactions.add(
                "Account created with balance ₹" + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {

        if (amount > 0) {

            balance += amount;

            transactions.add(
                    "Deposited ₹" + amount);

            System.out.println(
                    "Deposit successful.");
        } else {

            System.out.println(
                    "Amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            balance -= amount;

            transactions.add(
                    "Withdrawn ₹" + amount);

            System.out.println(
                    "Withdrawal successful.");
        } else {

            System.out.println(
                    "Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {

        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }

    public void displayTransactions() {

        System.out.println("\nTransaction History");

        for (String transaction : transactions) {

            System.out.println(transaction);
        }
    }
}
