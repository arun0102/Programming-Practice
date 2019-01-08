package arun.pkg.hackerrank.divisiblesumpairs;

import java.io.IOException;
// https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
public class DivisibleSumPairsProblem {

	// Complete the divisibleSumPairs function below.
	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;
		count = checkSum(0, count, k, ar);
		return count;
	}

	private static int checkSum(int start, int count, int k, int[] ar) {
		if (start != ar.length - 1) {
			int ar1 = ar[start];
			for (int i = start + 1; i < ar.length; i++) {
				if ((ar1 + ar[i]) % k == 0) {
					count++;
				}
			}
			return checkSum(start + 1, count, k, ar);
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		int n = 6;
		int k = 3;
		int[] ar = { 1, 3, 2, 6, 1, 2 };

		int result = divisibleSumPairs(n, k, ar);

		System.out.println(result);
	}
}
