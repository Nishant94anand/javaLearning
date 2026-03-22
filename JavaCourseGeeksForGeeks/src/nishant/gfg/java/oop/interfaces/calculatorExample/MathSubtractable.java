package nishant.gfg.java.oop.interfaces.calculatorExample;

public interface MathSubtractable {
	public default double subtract (double num1, double num2) {
		return num1-num2;
	}
}
