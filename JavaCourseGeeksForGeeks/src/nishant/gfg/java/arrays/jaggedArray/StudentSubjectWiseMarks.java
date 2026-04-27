package nishant.gfg.java.arrays.jaggedArray;

import java.util.Scanner;

/**
 * 
 * DSA Topic - Jagged Arrays (Student Subject-wise Marks)
 * 
 * 📘 Overview: Demonstrates the use of Jagged Arrays in Java, where each row
 * can have a different number of columns. This is useful for representing
 * non-uniform data structures.
 * 
 * In this example: Each row represents a student. Each column represents marks
 * of a subject. Each student can have a different number of subjects
 * 
 * 🧩 Example: Student 1 → [80, 90] Student 2 → [70, 85, 95] Student 3 → [88]
 * 
 * ⚙️ Approach:
 * 
 * Take number of students Initialize jagged array (only rows)
 * 
 * For each student: Take subject count Initialize row with that size Collect
 * marks
 * 
 * Traverse array: Print marks Calculate average Track topper based on highest
 * average
 * 
 * 🧮 Complexity Analysis: Time : O(N * M) → N = students, M = avg subjects per
 * student Space : O(N * M)
 * 
 * 
 * 🧠 Key Insights: Jagged arrays allow flexible row sizes. Avoids memory wastage
 * vs fixed 2D arrays. Each row must be initialized separately 
 * 🔍 Related Topics: Arrays, 2D Arrays, Input Handling, Aggregation
 * 
 * Author: Nishant Anand | Repository: Java Learning
 */
public class StudentSubjectWiseMarks {

	public static void main(String[] args) {

		int[][] classReport = getClassReport();
		printScoreChart(classReport);
	}

	private static int[][] getClassReport() {
		Scanner sc = new Scanner(System.in);

		int numOfStudents;

		do {
			System.out.println("==>Number of students: ");
			numOfStudents = sc.nextInt();

			validateNumberIsGreaterThanZero(numOfStudents);
		} while (numOfStudents <= 0);

		int[][] classReport = new int[numOfStudents][];

		for (int i = 0; i < numOfStudents; ++i) {
			classReport[i] = getStudentMarks(sc, (i + 1));
		}

		sc.close();

		return classReport;

	}

	private static int[] getStudentMarks(Scanner sc, int studentNumber) {
		int subjectCount;

		do {
			System.out.println("\n\n==>Number of subjects for Student #" + studentNumber);
			subjectCount = sc.nextInt();

			validateNumberIsGreaterThanZero(subjectCount);
		} while (subjectCount <= 0);

		int[] scores = new int[subjectCount];

		System.out.println("\n==>Enter subject scores");
		for (int i = 0; i < subjectCount; ++i) {

			int score;

			do {
				System.out.print("\nSubject #" + (i + 1) + " ");
				score = sc.nextInt();
				validateNumberIsPositive(score);
			} while (score < 0);

			scores[i] = score;
		}
		return scores;
	}

	private static void printScoreChart(int[][] classReport) {
		System.out.println("\n\n================== Class Exam Report ==================\n");

		int topperIndex = 0;
		double topperAverage = 0.0;

		for (int i = 0; i < classReport.length; ++i) {
			System.out.println("\n===== Student #" + (i + 1) + " =====\n");

			int[] studentScores = classReport[i];
			System.out.print("Number of Subjects: " + (studentScores.length) + "\n");
			System.out.print("Scores: ");
			double average = printScoresAndCalculateAverage(studentScores);

			if (average > topperAverage) {
				topperIndex = i;
				topperAverage = average;
			}

			System.out.printf("\nAverage: %.2f", average);
		}

		System.out.printf("\n\n==> Class Topper: Student #" + (topperIndex + 1) + " with highest average %.2f",
				topperAverage);

	}

	private static double printScoresAndCalculateAverage(int[] studentScores) {
		int subjectCount = studentScores.length;

		int total = 0;

		for (int j = 0; j < subjectCount; ++j) {
			System.out.print(studentScores[j] + " ");
			total += studentScores[j];
		}

		return (double) total / subjectCount;
	}

	private static void validateNumberIsPositive(int num) {
		if (num < 0) {
			System.out.println("Invalid Input!");
		}
	}

	private static void validateNumberIsGreaterThanZero(int num) {
		if (num <= 0) {
			System.out.println("Invalid Input!");
		}
	}

}