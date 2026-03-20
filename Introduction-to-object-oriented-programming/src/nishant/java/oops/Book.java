package nishant.java.oops;

public class Book {
	private String name;
	private int noOfCopies;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNoOfCopies() {
		return noOfCopies;
	}
	
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	void printName() {
		System.out.println("Name: " + name);
	}

}
