package nishant.java.oops;

public class MotorBike {
	
	private int speed;
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed > 0) {
			this.speed = speed;
		}
	}
	
	public void increaseSpeed(int speedDiff) {
		if (speedDiff > 0) {
			setSpeed(this.speed + speedDiff);
		}
	}
	
	public void decreaseSpeed(int speedDiff) {
		if (speedDiff < 0) {
			setSpeed(this.speed + speedDiff);
		}
	}

	void start() {
		System.out.println("Starting.. Vroom Vroom !!");
	}
}
