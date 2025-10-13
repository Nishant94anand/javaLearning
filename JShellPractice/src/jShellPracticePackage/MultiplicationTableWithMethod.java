package jShellPracticePackage;

public class MultiplicationTableWithMethod {

	public static void main(String[] args) {
		int num = 6;
		printTable(num);
	}
	
	private static void printTable(int num) {
		for (int i = 1; i <= 10; ++i) {
			System.out.printf("%d x %d = %d", num, i, 5 * i).println();
		}
	}

}
