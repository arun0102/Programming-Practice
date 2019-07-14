package arun.pkg.geeksforgeeks.dp.longestincreasingsubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while (tests > 0) {
			int len = sc.nextInt();
			int[] arr = new int[len];
			for (int i = 0; i < len; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(sub(arr));

			tests--;
		}
		sc.close();
	}

	private static int sub(int[] arr) {
		int T[] = new int[arr.length];
		Arrays.fill(T, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					T[i] = max(T[i], T[j] + 1);
				}
			}
		}

		return Arrays.stream(T).max().getAsInt();
	}

	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}
