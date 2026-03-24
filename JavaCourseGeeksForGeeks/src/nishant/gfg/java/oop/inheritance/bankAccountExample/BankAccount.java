package nishant.gfg.java.oop.inheritance.bankAccountExample;

/**
 * Abstract base class representing a generic bank account.
 *
 * 🔹 Key Concepts:
 * - Abstract class (cannot be instantiated)
 * - Common state (accountNumber, balance)
 * - Common behavior (deposit, withdraw, showBalance)
 * - Abstract method (calculateInterest)
 *
 * 🔹 Design Intent:
 * - Provide shared functionality to all account types
 * - Force subclasses to define their own interest calculation logic
 */
abstract class BankAccount {

    String accountNumber;
    double balance;

    /**
     * Constructor initializes account with unique account number
     * and default balance = 0
     */
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0.0;
    }

    /**
     * Withdraw money from account
     *
     * 🔹 Includes validation for insufficient balance
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("==> Low Balance. Can't withdraw. Balance: " + balance);
            return;
        }

        balance -= amount;
        System.out.println("==> Withdraw Successful. New balance: " + balance);
    }

    /**
     * Deposit money into account
     */
    public void deposit(double amount) {
        balance += amount;
        System.out.println("==> Deposit Successful. New balance: " + balance);
    }

    /**
     * Display account details
     */
    public void showBalance() {
        System.out.println("==> Account Number: " + accountNumber + " | Balance: " + balance);
    }

    /**
     * Abstract method → must be implemented by subclasses
     *
     * 🔹 Demonstrates runtime polymorphism
     */
    abstract void calculateInterest();
}