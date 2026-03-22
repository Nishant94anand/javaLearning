package nishant.gfg.java.oop.interfaces.calculatorExample;

public interface MathMultipliable {
	public default double multiply (double num1, double num2) {
		return num1 * num2;
	}
}
