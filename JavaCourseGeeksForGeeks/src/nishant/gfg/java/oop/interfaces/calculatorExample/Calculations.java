package nishant.gfg.java.oop.interfaces.calculatorExample;

public class Calculations {

	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 5;
		
		MathCalculator calculator = new MathCalculator();
		System.out.println(calculator.add(num1, num2));
		System.out.println(calculator.subtract(num1, num2));
		System.out.println(calculator.multiply(num1, num2));
		System.out.println(calculator.divide(num1, num2));
		calculator.performAllOperations(num1, num2);
	}

}
