package arun.pkg.hackerrank.array_left_rotation;

import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
public class ArrayLeftRotation {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[(i + n - d) % n] = aItem;
		}

		Arrays.stream(a).forEach(i -> System.out.print(i + " "));
//		rotateArrayLeft(a, d);
		scanner.close();
	}

//	static void rotateArrayLeft(int[] a, int d) {
//		d = d % a.length;
//		for (int i = 0; i < d; i++) {
//			int temp = a[0];
//			for (int j = 0; j < a.length - 1; j++) {
//				a[j] = a[j + 1];
//			}
//			a[a.length - 1] = temp;
//		}
//
//		Arrays.stream(a).forEach(i -> System.out.print(i + " "));
//	}
}
