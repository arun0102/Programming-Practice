package arun.pkg.sort.insertionsort;

import java.util.Scanner;

public class InsertionSort {
	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		try {

//			int n = scan.nextInt();
//
//			int[] grades = new int[n];
//
//			for (int gradesItr = 0; gradesItr < n; gradesItr++) {
//				int gradesItem = scan.nextInt();
//				grades[gradesItr] = gradesItem;
//			}
			
			int[] grades = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};  
			System.out.println("Unsorted Array");
			printArr(grades);
			grades = insertionSortArray(1, grades);
			System.out.println("Sorted Array");
			printArr(grades);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int[] insertionSortArray(int position, int[] grades) {
		for (int i = 0; i < position; i++) {
			if(grades[position] < grades[i]) {
				int temp = grades[position];
				grades[position] = grades[i];
				grades[i] = temp;
			}
		}
		
		if(position == grades.length - 1) {
			return grades;
		} else {
			insertionSortArray(position + 1, grades);
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
