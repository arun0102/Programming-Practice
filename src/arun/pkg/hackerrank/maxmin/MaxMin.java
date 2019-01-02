package arun.pkg.hackerrank.maxmin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	// Complete the maxMin function below.
	static int maxMin(int k, int[] arr) {
		Arrays.sort(arr);
		int startIndex = 0;
		int unfairness = Integer.MAX_VALUE;
		while((startIndex + k - 1) != arr.length) {
			if(unfairness > (arr[startIndex + k - 1] - arr[startIndex])) {
				unfairness = arr[startIndex + k - 1] - arr[startIndex];
			}
			startIndex++;
		}
		return unfairness;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 7;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int k = 3;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = { 10, 100, 300, 200, 1000, 20, 30 };// new int[n];

//		for (int i = 0; i < n; i++) {
//			int arrItem = scanner.nextInt();
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//			arr[i] = arrItem;
//		}

		int result = maxMin(k, arr);

		System.out.println(result);

		scanner.close();
	}
}
