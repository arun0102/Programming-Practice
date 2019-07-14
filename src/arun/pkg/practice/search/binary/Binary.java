package arun.pkg.practice.search.binary;

import java.util.Arrays;

public class Binary {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = 4;

		System.out.println(binarySearch(n, arr));
	}

	private static boolean binarySearch(int n, int[] arr) {
		int mid = (int) Math.floor(arr.length / 2);
		if (n < arr[0] || n > arr[arr.length - 1]) {
			return false;
		} else if (n == arr[mid]) {
			return true;
		} else if (n > arr[mid]) {
			return binarySearch(n, Arrays.copyOfRange(arr, mid, arr.length));
		} else {
			return binarySearch(n, Arrays.copyOfRange(arr, 0, mid));
		}
	}
}
