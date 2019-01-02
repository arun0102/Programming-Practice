package arun.pkg.hackerrank.absolutedifference;

import java.io.IOException;
import java.util.Scanner;

public class AbsoluteDifference {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println(Math.pow(2, 0));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = minimumAbsoluteDifference(arr);

		System.out.println(result);

		scanner.close();
	}

	static int minimumAbsoluteDifference(int[] arr) {
		int minSum = Integer.MAX_VALUE;
		System.out.println("checking");
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int diff = Math.abs(arr[i] - arr[j]);
				if (minSum > diff) {
					minSum = diff;
				}
			}
		}
		return minSum;
	}
}
