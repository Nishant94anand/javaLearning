package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Interface representing addition capability.
 *
 * 🔹 Key Concept:
 * - Uses a default method to provide implementation directly in interface.
 *
 * - Classes implementing this interface can use this method
 *   without overriding it.
 *
 * 🔹 Why default method?
 * - Allows adding behavior without breaking existing implementations.
 */
public interface MathAddable {

    /**
     * Performs addition of two numbers.
     *
     * @param num1 first number
     * @param num2 second number
     * @return sum of two numbers
     */
    public default double add(double num1, double num2) {
        return num1 + num2;
    }
}