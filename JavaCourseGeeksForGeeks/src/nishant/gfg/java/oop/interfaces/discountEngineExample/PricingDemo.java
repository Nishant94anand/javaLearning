package nishant.gfg.java.oop.interfaces.discountEngineExample;

/**
 * Entry point class to demonstrate pricing strategies.
 *
 * 🔹 Key Concepts:
 * - Functional Interface usage
 * - Lambda-based strategy selection
 * - Interface constants usage
 */
public class PricingDemo {

    public static void main(String[] args) {

        double price = 1000;

        // Festive discount example
        System.out.println("==> Festive Discount");
        PricingStrategy festiveStrategy = BillingService.getFestiveStrategy();
        System.out.println("Final price: " +
                BillingService.calculateFinalPrice(price, festiveStrategy));

        // Premium discount example
        System.out.println("==> Premium Discount");
        PricingStrategy premiumStrategy = BillingService.getPremiumStrategy();
        System.out.println("Final price: " +
                BillingService.calculateFinalPrice(price, premiumStrategy));

        // Super premium (capped by MAX_DISCOUNT)
        System.out.println("==> Super Premium Discount");
        PricingStrategy superPremiumStrategy = BillingService.getSuperPremiumStrategy();
        System.out.println("Final price: " +
                BillingService.calculateFinalPrice(price, superPremiumStrategy));
    }
}