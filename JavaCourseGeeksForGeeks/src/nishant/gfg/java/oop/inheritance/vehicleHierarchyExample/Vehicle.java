package nishant.gfg.java.oop.inheritance.vehicleHierarchyExample;

/**
 * Base class representing a generic vehicle.
 *
 * 🔹 Key Concepts:
 * - Base class in inheritance hierarchy
 * - Encapsulation (private field + getter/setter)
 * - Common behavior shared across all vehicles
 */
class Vehicle {

    private boolean isStarted;

    /**
     * Constructor initializes vehicle state
     */
    public Vehicle() {
        System.out.println("\n==> Into Vehicle Constructor");
        isStarted = false;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        this.isStarted = started;
    }

    /**
     * Starts the vehicle
     */
    public void start() {
        setStarted(true);
        System.out.println("==> Vehicle started .. Vroom Vroom!!");
    }

    /**
     * Stops the vehicle
     */
    public void switchOff() {
        setStarted(false);
        System.out.println("==> Vehicle stopped .. Vroom Vroom stopped!!");
    }
}
