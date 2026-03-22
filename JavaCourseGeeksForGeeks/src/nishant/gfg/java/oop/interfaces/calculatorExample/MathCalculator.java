package nishant.gfg.java.oop.interfaces.calculatorExample;

public class MathCalculator implements MathAddable, MathDividable, MathMultipliable, MathSubtractable {
	
	public void performAllOperations(double num1, double num2) {
		System.out.println("====> Operation Results :-");
		System.out.println("==> Add: " + add(num1, num2));
		System.out.println("==> Subtract: " + subtract(num1, num2));
		System.out.println("==> Multiply: " + multiply(num1, num2));
		System.out.println("==> Divide: " + divide(num1, num2));
	}
}
