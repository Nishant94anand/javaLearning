package nishant.gfg.java.oop.inheritance.vehicleHierarchyExample;

/**
 * Bike class extending Vehicle
 *
 * 🔹 Demonstrates:
 * - Hierarchical inheritance (Vehicle → Car, Bike)
 */
class Bike extends Vehicle {

    boolean isRiding;

    public Bike() {
        System.out.println("==> Into Bike Constructor!");
        isRiding = false;
    }

    public boolean isRiding() {
        return isRiding;
    }

    public void setRiding(boolean isRiding) {
        this.isRiding = isRiding;
    }

    public void ride() {
        setRiding(true);
        System.out.println("==> Bike riding.... Vroom Vroom!!");
    }

    public void stopRiding() {
        setRiding(false);
        System.out.println("==> Bike stopped.... Vroom Vroom stopped!!");
    }
}
