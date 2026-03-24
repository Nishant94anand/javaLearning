package nishant.gfg.java.oop.abstractclass;

/**
 * Abstract Class Example: Shape
 *
 * 🔹 Purpose:
 * Demonstrates how abstract classes define a template for subclasses.
 *
 * 🔹 Key Concepts:
 * - Abstract class cannot be instantiated
 * - Can have both abstract and concrete methods
 * - Constructor execution flow in inheritance
 */
abstract class Shape {

    String color;

    /**
     * Constructor of abstract class
     * - Gets called when subclass object is created
     */
    public Shape(String color) {
        System.out.println("==> Shape Constructor called with Color: " + color);
        this.color = color;
    }

    /**
     * Abstract method (must be implemented by subclasses)
     */
    abstract double area();

    /**
     * Concrete method (shared behavior)
     */
    void printColor() {
        System.out.println("Color: " + color);
    }
}

/**
 * Circle implementation
 */
class Circle extends Shape {

    int radius;

    public Circle(String color, int radius) {
        super(color); // calling abstract class constructor
        System.out.println("==> Circle Constructor called with radius: " + radius);
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}

/**
 * Rectangle implementation
 */
class Rectangle extends Shape {

    int length;
    int width;

    public Rectangle(String color, int length, int width) {
        super(color);
        System.out.println("==> Rectangle Constructor called with length: " + length + " | width: " + width);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

/**
 * Entry point
 */
public class ShapeUsingAbstractClass {

    public static void main(String[] args) {

        // Polymorphism: reference of abstract class
        Shape circle = new Circle("Red", 5);
        circle.printColor();
        System.out.println("Circle Area: " + circle.area());

        Shape rect = new Rectangle("Blue", 10, 20);
        rect.printColor();
        System.out.println("Rectangle Area: " + rect.area());

        // Shape s = new Shape("Black"); ❌ Not allowed
    }
}