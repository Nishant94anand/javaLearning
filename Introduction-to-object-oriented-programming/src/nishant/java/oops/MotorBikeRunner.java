package nishant.java.oops;

public class MotorBikeRunner {

	public static void main(String[] args) {
		MotorBike ducati = new MotorBike();
		MotorBike honda = new MotorBike();
		
		ducati.start();
		honda.start();
		
		ducati.setSpeed(200);
		honda.setSpeed(100);
		
		System.out.println(ducati.getSpeed());
		System.out.println(honda.getSpeed());
		
		ducati.increaseSpeed(50);
		honda.increaseSpeed(30);
		
		System.out.println(ducati.getSpeed());
		System.out.println(honda.getSpeed());

	}

}
