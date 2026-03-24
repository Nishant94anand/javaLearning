package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Calculator class implementing multiple interfaces.
 *
 * 🔹 Key Concepts Demonstrated:
 *
 * 1️⃣ Multiple Inheritance via Interfaces
 *    - Java does not support multiple inheritance with classes,
 *      but allows it using interfaces.
 *
 * 2️⃣ Default Method Usage
 *    - This class inherits implementations directly from interfaces.
 *    - No need to override methods unless customization is required.
 *
 * 3️⃣ Abstraction
 *    - Each interface represents a specific capability (Add, Subtract, etc.)
 *    - This class composes those capabilities.
 */
public class MathCalculator implements MathAddable, MathDividable, MathMultipliable, MathSubtractable {
	
	/**
	 * Overriding default divide implementation to add validation.
	 *
	 * 🔹 Reason:
	 * - Default method provides basic behavior
	 * - This override ensures safe division (no divide-by-zero)
	 */
	@Override
	public double divide(double num1, double num2) {
		if (num2 == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		
		return num1/num2;
	}

    /**
     * Performs all operations together.
     *
     * 🔹 Demonstrates:
     * - How multiple inherited behaviors can be used in one place
     * - Code reuse via interfaces
     */
    public void performAllOperations(double num1, double num2) {
        System.out.println("====> Operation Results :-");
        System.out.println("==> Add: " + add(num1, num2));
        System.out.println("==> Subtract: " + subtract(num1, num2));
        System.out.println("==> Multiply: " + multiply(num1, num2));
        System.out.println("==> Divide: " + divide(num1, num2));
    }
}