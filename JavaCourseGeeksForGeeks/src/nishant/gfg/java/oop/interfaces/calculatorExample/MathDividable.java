package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Interface representing division capability.
 *
 * 🔹 Important Note:
 * - No validation added here intentionally to keep interface simple.
 * - Validation can be handled at implementation level if needed.
 */
public interface MathDividable {

    /**
     * Performs division.
     */
    public default double divide(double num1, double num2) {
        return num1 / num2;
    }
}