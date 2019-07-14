package arun.pkg.practice.sort.selectionsort;

import java.util.Scanner;

public class SelectionSort {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			int n = scan.nextInt();

			int[] grades = new int[n];

			for (int gradesItr = 0; gradesItr < n; gradesItr++) {
				int gradesItem = scan.nextInt();
				grades[gradesItr] = gradesItem;
			}
			printArr(grades);
			grades = selectionSortArray(0, grades);
			printArr(grades);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] selectionSortArray(int switchPos, int[] grades) {
		int minVal = Integer.MAX_VALUE;
		int minPos = -1;

		for (int i = switchPos; i < grades.length; i++) {
			if (minVal > grades[i]) {
				minVal = grades[i];
				minPos = i;
			}
		}

		if (minPos != -1) {
			// switch with minimum value with the left position
			int temp = grades[switchPos];
			grades[switchPos] = grades[minPos];
			grades[minPos] = temp;

			selectionSortArray(switchPos + 1, grades);
		} else {
			return grades;
		}
		return grades;
	}

	private static void printArr(int[] grades) {
		for (int i = 0; i < grades.length; i++) {
			System.out.print(grades[i] + ", ");
		}
		System.out.println();
	}
}