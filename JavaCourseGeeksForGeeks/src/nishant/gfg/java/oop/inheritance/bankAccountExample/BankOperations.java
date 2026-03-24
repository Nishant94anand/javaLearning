package nishant.gfg.java.oop.inheritance.bankAccountExample;

/**
 * Entry point for demonstrating Bank Account operations
 *
 * 🔹 Key Concepts:
 * - Runtime Polymorphism
 * - Same reference (BankAccount) → different behavior
 */

public class BankOperations {

	public static void main(String[] args) {
		/**
         * 🔹 Polymorphism:
         * - Reference type: BankAccount
         * - Object type: SavingsAccount
         */
		// Open Savings Account 1
		BankAccount savingAcc1 = new SavingsAccount();
		savingAcc1.showBalance();
		savingAcc1.deposit(5000);
		savingAcc1.calculateInterest();
		savingAcc1.withdraw(20);
		savingAcc1.calculateInterest();

		// Open Savings Account 2
		System.out.println("\n");
		BankAccount savingAcc2 = new SavingsAccount();
		savingAcc2.showBalance();
		savingAcc2.deposit(2000);
		savingAcc2.calculateInterest();
		savingAcc2.withdraw(200);
		savingAcc2.calculateInterest();

		// Open Savings Account 2
		System.out.println("\n");
		BankAccount currAcc1 = new CurrentAccount();
		currAcc1.showBalance();
		currAcc1.deposit(5000);
		currAcc1.calculateInterest();
		currAcc1.withdraw(20);
		currAcc1.calculateInterest();

		// Open Savings Account 2
		System.out.println("\n");
		BankAccount currAcc2 = new CurrentAccount();
		currAcc2.showBalance();
		currAcc2.deposit(2000);
		currAcc2.calculateInterest();
		currAcc2.withdraw(200);
		currAcc2.calculateInterest();

	}

}
