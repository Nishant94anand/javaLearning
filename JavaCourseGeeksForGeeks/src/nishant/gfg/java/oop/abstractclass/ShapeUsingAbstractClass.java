package nishant.gfg.java.oop.abstractclass;

abstract class Shape {
	String color;
	
	// Construction
	public Shape(String color) {
		System.out.println("==> Shape Constructor called with Color: " + color);
		this.color = color;
	}
	
	// Abstract method
	abstract double area();
	
	// Concrete Method
	void printColor() {
		System.out.println("Color: " + color);
	}
}

class Circle extends Shape {
	
	int radius;
	
	public Circle (String color, int radius) {
		super(color);
		System.out.println("==> Circle Constructor called with radius: " + radius);
		this.radius = radius;
	}

	@Override
	double area() {
		return 3.14 * radius * radius;
	}	
}

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


public class ShapeUsingAbstractClass {

	public static void main(String[] args) {
		Shape circle = new Circle("Red", 5);
		circle.printColor();
		System.out.println("Circle Area: " + circle.area());
		
		Shape rect = new Rectangle("Blue", 10, 20);
		rect.printColor();
		System.out.println("Rectangle Area: " + rect.area());
		
		// Shape s = new Shape("Black"); // Gives error: Cannot instantiate
	}

}
