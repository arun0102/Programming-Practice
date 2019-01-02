package arun.pkg.hackerrank.pairsproblem;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class PairsProblem {

	// Complete the pairs function below.
	static int pairs(int k, int[] arr) {
		int count = 0;

		HashSet<Integer> map = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			map.add(arr[i]);
		}
		int pairCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (map.contains(arr[i] - k)) {
				pairCount++;
			}
		}
		return pairCount;
		// correct result but timeout
//		long count = numArr.stream().filter(i -> numArr.contains(i - k)).count();
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = i + 1; j < arr.length; j++) {
//				if(Math.abs(arr[i] - arr[j]) == k) {
//					count++;
//				}
//			}
//		}
//		return count;
	}

//	43253

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = pairs(k, arr);
		System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
	}
}
