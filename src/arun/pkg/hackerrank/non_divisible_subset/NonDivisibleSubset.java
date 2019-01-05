package arun.pkg.hackerrank.non_divisible_subset;

import java.io.IOException;
import java.util.Scanner;
// https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class NonDivisibleSubset {

	// Complete the nonDivisibleSubset function below.
	static int nonDivisibleSubset(int k, int[] s) {
		int[] arr = new int[k];
		for (int i = 0; i < s.length; i++) {
			arr[s[i] % k]++;
		}
		int result = 0;
		if (k % 2 == 0)
			result++; // it will not have any conjugate pair
		result = result + Math.min(arr[0], 1);// If no number wholly divisible don't add it to pair else add once
		for (int j = 1; j <= k / 2; j++)
			if (j != k - j)
				result += Math.max(arr[j], arr[k - j]);
		return result;
	}

//	static int nonDivisibleSubset(int k, int[] s) {
//		int maxCount = Integer.MIN_VALUE;
//		for (int i = 0; i < s.length; i++) {
//			List<Integer> list = new ArrayList<>();
//			list.add(s[i]);
//			for (int j = 0; j < s.length; j++) {
//				if (i != j) {
//					boolean isDivisible = false;
//					for (int x = 0; x < list.size(); x++) {
//						if ((list.get(x) + s[j]) % k == 0) {
//							isDivisible = true;
//						}
//					}
//					if (!isDivisible) {
//						list.add(s[j]);
//					}
//				}
//			}
//			if (maxCount < list.size()) {
//				maxCount = list.size();
//			}
//		}
//
//		return maxCount;
//	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String[] nk = scanner.nextLine().split(" ");

		int n = 100000;// Integer.parseInt(nk[0]);

		int k = 7;// 100;// 7;// Integer.parseInt(nk[1]);

		int[] S = { 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436 };// new int[n];
//		long[] S = new long[n];
//
//		String[] SItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			long SItem = Long.parseLong(SItems[i]);
//			S[i] = SItem;
//		}

		int result = nonDivisibleSubset(k, S);

		System.out.println(result);

		scanner.close();
	}
}
