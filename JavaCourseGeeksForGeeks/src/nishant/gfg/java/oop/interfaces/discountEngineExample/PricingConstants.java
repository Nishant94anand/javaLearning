package nishant.gfg.java.oop.interfaces.discountEngineExample;

/**
 * Interface holding application-wide constants.
 *
 * 🔹 Key Concept:
 * - All variables in interface are implicitly:
 *   public static final
 *
 * - Used for shared configuration values
 *
 * 🔹 Best Practice:
 * - Access using interface name (not via implementation)
 */
public interface PricingConstants {

    /** Tax percentage applied on final price */
    double TAX = 0.18;

    /** Maximum allowed discount (80%) */
    double MAX_DISCOUNT = 0.80;
}