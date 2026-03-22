package nishant.gfg.java.oop.interfaces.calculatorExample;

public interface MathDividable {
	public default double divide (double num1, double num2) {
		return num1/num2;
	}
}
