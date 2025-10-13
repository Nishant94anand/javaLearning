package jShellPracticePackage;

public class OddOrEvenSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1; // For Odd
		num = 2; //  For Even
		
		for (int i = 1; i <= 10; ++i) {
			System.out.printf("%d * %d = %d", num, num, num * num).println();
			num += 2;
		}

	}

}
