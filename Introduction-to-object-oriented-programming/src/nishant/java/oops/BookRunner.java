package nishant.java.oops;

public class BookRunner {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setName("Art of Computer Programming");
		
		Book b2 = new Book();
		b2.setName("Effective Java");
		
		Book b3 = new Book();
		b3.setName("Clean code");
		
		b1.printName();
		b2.printName();
		b3.printName();

	}

}
