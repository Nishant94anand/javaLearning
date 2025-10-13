package jShellPracticePackage;

public class StringConcatenation {

	public static void main(String[] args) {
		// If any one is String, all others are treated as Strings
		System.out.println("1" + 2 + 3); // 123
		
		// Can give higher priority to evaluate first and then concatenate
		System.out.println("1" + (2 + 3)); // 15
	}

}
