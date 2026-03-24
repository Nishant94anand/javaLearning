package nishant.gfg.java.oop.inheritance.vehicleHierarchyExample;

/**
 * ElectricCar extending Car (Multilevel Inheritance)
 *
 * 🔹 Demonstrates:
 * - Method overriding
 * - Specialized behavior
 */
class ElectricCar extends Car {

    /**
     * Overriding start behavior
     */
    @Override
    public void start() {
        setStarted(true);
        System.out.println("==> Electric Car started .. <silently> !!");
    }

    @Override
    public void switchOff() {
        setStarted(false);
        System.out.println("==> Electric Car stopped .. <silently> stopped!!");
    }

    @Override
    public void drive() {
        setDriving(true);
        System.out.println("==> Electric Car driving.... <silently> !!");
    }

    @Override
    public void stopDriving() {
        setDriving(false);
        System.out.println("==> Electric Car stopped.... <silently> stopped!!");
    }
}
