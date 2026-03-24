package nishant.gfg.java.oop.interfaces.calculatorExample;

/**
 * Entry point of the application.
 *
 * 🔹 Purpose:
 * - Demonstrates how a class can use multiple interface-based behaviors.
 * - Shows real usage of abstraction via interfaces.
 *
 * 🔹 Key Concepts:
 * - Abstraction (via interfaces)
 * - Multiple inheritance (via interfaces)
 */
public class Calculations {

    public static void main(String[] args) {

        // Sample input values
        int num1 = 100;
        int num2 = 20;

        // Creating calculator instance
        MathCalculator calculator = new MathCalculator();

        // Calling individual operations inherited from interfaces
        System.out.println(calculator.add(num1, num2));
        System.out.println(calculator.subtract(num1, num2));
        System.out.println(calculator.multiply(num1, num2));
        System.out.println(calculator.divide(num1, num2));

        // Calling combined operation method
        calculator.performAllOperations(num1, num2);
    }
}