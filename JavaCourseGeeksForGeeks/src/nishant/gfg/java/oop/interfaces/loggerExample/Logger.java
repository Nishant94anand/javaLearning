package nishant.gfg.java.oop.interfaces.loggerExample;

/**
 * Logger Interface
 *
 * 🔹 Purpose:
 * Demonstrates how interfaces in Java can contain:
 * - Static methods
 * - Main method
 *
 * 🔹 Key Concepts Covered:
 *
 * 1️⃣ Static Methods in Interface
 *    - Static methods belong to the interface itself.
 *    - They cannot be overridden by implementing classes.
 *    - Used for utility/helper functionality.
 *
 * 2️⃣ Main Method inside Interface
 *    - Interfaces can have a main method because it is static.
 *    - JVM can directly execute it without any implementing class.
 *
 * 3️⃣ Interface as Utility Holder
 *    - Interfaces can act as lightweight utility classes (Java 8+)
 */
public interface Logger {

    /**
     * Logs a message to the console.
     *
     * 🔹 Why static?
     * - No need to create object
     * - Belongs to interface itself
     *
     * @param msg message to log
     */
    static void log(String msg) {
        System.out.println("==>[LOG]: " + msg);
    }

    /**
     * Entry point inside interface.
     *
     * 🔹 Demonstrates:
     * - Interface can act as execution entry point
     * - Static methods can be directly invoked
     *
     * 🔹 Note:
     * - This is mainly used for testing or demonstration
     * - Not commonly used as main application entry in production
     */
    static void main(String[] args) {

        // Calling static method directly within interface
        log("Application started");
        log("Processing...");
    }
}