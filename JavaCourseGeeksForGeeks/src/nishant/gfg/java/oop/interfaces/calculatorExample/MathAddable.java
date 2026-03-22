package nishant.gfg.java.oop.interfaces.calculatorExample;

public interface MathAddable {
	public default double add (double num1, double num2) {
		return num1 + num2;
	}
}
