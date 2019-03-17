package arun.pkg.practice.sort.bubblesort;

import java.util.Scanner;

public class BubbleSort {
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
			grades = bubbleSortArray(1, grades);
			printArr(grades);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] bubbleSortArray(int endPosition, int[] grades) {
		boolean isSwitched = false;
		for (int i = 0; i < grades.length - endPosition; i++) {
			if(grades[i] > grades[i+1]) { // switch places
				isSwitched = true;
				int temp = grades[i+1];
				grades[i+1] = grades[i];
				grades[i] = temp;
			}
			
			printArr(grades);
		}
		
		if(isSwitched) {
			bubbleSortArray(endPosition + 1, grades);
		} else {
			return grades;
		}
		return grades;
	}
	
	private static void printArr(int[] grades) {
		for(int i=0;i<grades.length;i++) {
			System.out.print(grades[i] + ", ");
		}
		System.out.println();
	}
}
