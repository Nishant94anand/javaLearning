package nishant.gfg.java.oop.inheritance.bankAccountExample;

/**
 * SavingsAccount implementation
 *
 * 🔹 Demonstrates:
 * - Inheritance from BankAccount
 * - Method overriding
 * - Static fields for shared configuration
 */
class SavingsAccount extends BankAccount {

    private static int num = 1;
    private static double interest = 0.04;
    private static final String PREFIX = "SAVINGS_ACC_NO_";

    /**
     * Constructor generates unique account number
     */
    public SavingsAccount() {
        super(PREFIX + num++);
    }

    /**
     * Overridden method for interest calculation
     *
     * 🔹 Runtime polymorphism:
     * - Called based on actual object type
     */
    @Override
    void calculateInterest() {
        System.out.println("==> Savings Account Interest: " + (this.balance * interest));
    }
}
