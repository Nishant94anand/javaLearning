package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Interface representing subtraction capability.
 *
 * 🔹 Demonstrates:
 * - Abstraction of subtraction behavior
 * - Default method usage
 */
public interface MathSubtractable {

    /**
     * Performs subtraction.
     */
    public default double subtract(double num1, double num2) {
        return num1 - num2;
    }
}