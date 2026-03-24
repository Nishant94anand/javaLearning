package nishant.gfg.java.oop.interfaces.discountEngineExample;

/**
 * Service class responsible for applying pricing strategies
 * and calculating final price.
 *
 * 🔹 Key Concepts Demonstrated:
 *
 * 1️⃣ Functional Interface Usage
 *    - Uses PricingStrategy (functional interface) to inject behavior.
 *
 * 2️⃣ Strategy Pattern (via Lambda)
 *    - Different discount strategies are dynamically created.
 *
 * 3️⃣ Encapsulation of Business Rules
 *    - MAX_DISCOUNT logic is enforced centrally.
 *
 * 4️⃣ Interface Constants Usage
 *    - TAX and MAX_DISCOUNT are accessed from PricingConstants.
 */
public class BillingService {

    /**
     * Internal helper method to generate a pricing strategy.
     *
     * 🔹 Purpose:
     * - Encapsulates discount logic
     * - Ensures discount never exceeds MAX_DISCOUNT
     *
     * @param discount requested discount percentage (0–1)
     * @return PricingStrategy implementation using lambda
     */
    private static PricingStrategy getStrategy(double discount) {

        PricingStrategy strategy;

        // Enforcing maximum discount rule
        if (discount > PricingConstants.MAX_DISCOUNT) {

            // If requested discount exceeds allowed limit,
            // apply maximum allowed discount instead
            strategy = price -> price - (price * PricingConstants.MAX_DISCOUNT);

        } else {

            // Apply requested discount
            strategy = price -> price - (price * discount);
        }

        return strategy;
    }

    /**
     * Returns festive discount strategy.
     */
    public static PricingStrategy getFestiveStrategy() {
        return getStrategy(0.8);
    }

    /**
     * Returns premium user discount strategy.
     */
    public static PricingStrategy getPremiumStrategy() {
        return getStrategy(0.7);
    }

    /**
     * Returns super premium strategy.
     *
     * 🔹 Note:
     * Even though 90% discount is requested,
     * it will be capped by MAX_DISCOUNT.
     */
    public static PricingStrategy getSuperPremiumStrategy() {
        return getStrategy(0.9);
    }

    /**
     * Calculates final price after applying discount and tax.
     *
     * @param price original price
     * @param strategy pricing strategy (functional interface)
     * @return final price after discount + tax
     */
    public static double calculateFinalPrice(double price, PricingStrategy strategy) {

        // Apply discount using strategy
        double discountedPrice = strategy.applyDiscount(price);
        System.out.println("- Discounted Price: " + discountedPrice);

        // Apply tax on discounted price
        double finalPrice = discountedPrice + (discountedPrice * PricingConstants.TAX);

        return finalPrice;
    }
}