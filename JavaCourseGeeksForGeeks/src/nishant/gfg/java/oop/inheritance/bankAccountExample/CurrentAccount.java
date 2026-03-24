package nishant.gfg.java.oop.inheritance.bankAccountExample;

/**
 * CurrentAccount implementation
 *
 * 🔹 Business Rule:
 * - No interest is provided for current accounts
 */
class CurrentAccount extends BankAccount {

    private static int num = 1;
    private static final String PREFIX = "CURRENT_ACC_NO_";

    public CurrentAccount() {
        super(PREFIX + num++);
    }

    /**
     * Overridden method → no interest logic
     */
    @Override
    void calculateInterest() {
        System.out.println("==> No Interest for Current Account");
    }
}
