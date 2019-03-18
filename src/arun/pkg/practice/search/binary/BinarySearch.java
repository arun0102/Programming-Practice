package arun.pkg.practice.search.binary;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] numArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int num = 5;

		System.out.println(binarySearch(numArr, num));
	}

	static boolean binarySearch(int[] numArr, int num) {
		int mid = (int) Math.floor(numArr.length / 2);
		if (num > numArr[numArr.length - 1] || num < numArr[0]) {
			return false;
		} else if (numArr[mid] == num) {
			return true;
		} else if (numArr[mid] > num) {
			int[] leftArr = Arrays.copyOfRange(numArr, 0, mid);
			return binarySearch(leftArr, num);
		} else {
			int[] rightArr = Arrays.copyOfRange(numArr, mid, numArr.length);
			return binarySearch(rightArr, num);
		}
	}
}
