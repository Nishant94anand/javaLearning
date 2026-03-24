package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Interface representing multiplication capability.
 *
 * 🔹 Demonstrates:
 * - Reusable behavior using default methods
 */
public interface MathMultipliable {

    /**
     * Performs multiplication.
     */
    public default double multiply(double num1, double num2) {
        return num1 * num2;
    }
}