package arun.pkg.hackerrank.dp.candies;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Candies {

	static long candy(int n, int[] arr) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) { // forward track
			if (arr[i] > arr[i - 1]) {
				dp[i] = 1 + dp[i - 1];
			} else {
				dp[i] = 1;
			}
		}
//		System.out.println(Arrays.toString(dp));
		for (int i = n - 2; i >= 0; i--) { // back track
			if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
				dp[i] = dp[i + 1] + 1;
			}
		}

//		System.out.println(Arrays.toString(dp));
		long sum = 0;
		for (int i = 0; i < dp.length; i++) {
			sum += dp[i];
		}
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

//		int n = 10;

		int[] arr = { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 }; // 19
//		int[] arr = { 2, 4, 3, 5, 2, 6, 4, 5 }; // 12
//		int[] arr = { 4, 3, 2, 1, 2 };
//		int[] arr = { 1, 2, 2 }; // 4
//		int[] arr = { 9, 8, 7, 7, 6, 6, 5, 4, 3 };
//		int[] arr = { 9, 2, 3, 6, 5, 4, 3, 2, 2, 2 };

//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] arr = new int[n];
//
//		for (int i = 0; i < n; i++) {
//			int arrItem = scanner.nextInt();
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//			arr[i] = arrItem;
//		} // 33556

		long result = candy(arr.length, arr);

		System.out.println(result);
		scanner.close();
	}
}
