package nishant.gfg.java.oop.interfaces.discountEngineExample;

/**
 * Functional Interface representing a pricing strategy.
 *
 * 🔹 Key Concept:
 * - Functional Interface → Only ONE abstract method
 * - Enables use of lambda expressions
 *
 * 🔹 Why Functional Interface?
 * - Allows dynamic behavior injection (Strategy Pattern)
 * - Reduces need for multiple classes
 */
@FunctionalInterface
public interface PricingStrategy {

    /**
     * Applies discount logic to given price.
     *
     * @param price original price
     * @return discounted price
     */
    double applyDiscount(double price);
}