package nishant.gfg.java.oop.inheritance.vehicleHierarchyExample;

/**
 * Car class extending Vehicle
 *
 * 🔹 Demonstrates:
 * - Single inheritance
 * - Additional state (isDriving)
 * - Extended behavior
 */
class Car extends Vehicle {

    boolean isDriving;

    public Car() {
        System.out.println("==> Into Car constructor");
        isDriving = false;
    }

    public boolean isDriving() {
        return isDriving;
    }

    public void setDriving(boolean isDriving) {
        this.isDriving = isDriving;
    }

    /**
     * Car-specific behavior
     */
    public void drive() {
        setDriving(true);
        System.out.println("==> Car driving.... Vroom Vroom!!");
    }

    public void stopDriving() {
        setDriving(false);
        System.out.println("==> Car stopped.... Vroom Vroom stopped!!");
    }
}
