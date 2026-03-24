package nishant.gfg.java.oop.inheritance.vehicleHierarchyExample;

/**
 * Entry point demonstrating vehicle hierarchy
 *
 * 🔹 Concepts:
 * - Inheritance
 * - Multilevel inheritance
 * - Method overriding
 */
public class VehicleManagement {

	public static void main(String[] args) {
		
		// Vehicle
		Vehicle myVehicle = new Vehicle();
		System.out.println("==> myVehicle.isStarted() : "+ myVehicle.isStarted());
		myVehicle.start();
		System.out.println("==> myVehicle.isStarted() : "+ myVehicle.isStarted());
		myVehicle.switchOff();
		System.out.println("==> myVehicle.isStarted() : "+ myVehicle.isStarted());
		
		// Car
		Car myCar = new Car();
		System.out.println("==> myCar.isStarted() : "+ myCar.isStarted());
		myCar.start();
		System.out.println("==> myCar.isStarted() : "+ myCar.isStarted());
		System.out.println("==> myCar.isDriving() : "+ myCar.isDriving());
		myCar.drive();
		System.out.println("==> myCar.isDriving() : "+ myCar.isDriving());
		myCar.stopDriving();
		System.out.println("==> myCar.isDriving() : "+ myCar.isDriving());
		myCar.stopDriving();
		System.out.println("==> myCar.isStarted() : "+ myCar.isStarted());
		
		// Electric Car
		ElectricCar myElectricCar = new ElectricCar();
		System.out.println("==> myElectricCar.isStarted() : "+ myElectricCar.isStarted());
		myElectricCar.start();
		System.out.println("==> myElectricCar.isStarted() : "+ myElectricCar.isStarted());
		System.out.println("==> myElectricCar.isDriving() : "+ myElectricCar.isDriving());
		myElectricCar.drive();
		System.out.println("==> myElectricCar.isDriving() : "+ myElectricCar.isDriving());
		myElectricCar.stopDriving();
		System.out.println("==> myElectricCar.isDriving() : "+ myElectricCar.isDriving());
		myElectricCar.stopDriving();
		System.out.println("==> myElectricCar.isStarted() : "+ myElectricCar.isStarted());
		
		// Bike
		Bike myBike = new Bike();
		System.out.println("==> myBike.isStarted() : "+ myBike.isStarted());
		myBike.start();
		System.out.println("==> myBike.isStarted() : "+ myBike.isStarted());
		System.out.println("==> myBike.isRiding() : "+ myBike.isRiding());
		myBike.ride();
		System.out.println("==> myBike.isRiding() : "+ myBike.isRiding());
		myBike.stopRiding();
		System.out.println("==> myBike.isRiding() : "+ myBike.isRiding());
		
	}

}
