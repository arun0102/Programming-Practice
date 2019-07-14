package arun.pkg.geeksforgeeks.dp.coinchange;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		int[] coinArr = { 2, 3, 5, 6 };
		int amount = 10;
		System.out.println("DP - " + casesDP(amount, coinArr));
		System.out.println("TD - " + casesTD(amount, coinArr, coinArr.length));
		System.out.println("BU - " + casesBU(0, amount, coinArr, coinArr.length));
	}

	// top down approach
	private static int casesTD(int n, int[] arr, int m) {
		int result = 0;
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			result = 1;
		} else if (m <= 0 && n > 0) {
			result = 0;
		} else {
			result = casesTD(n - arr[m - 1], arr, m) + casesTD(n, arr, m - 1);
		}
		return result;
	}

	// bottom up approach
	private static int casesBU(int s, int n, int[] arr, int m) {
		int result = 0;
		if (s > n) {
			return 0;
		} else if (s == n) {
			result = 1;
		} else if (m <= 0 && s < n) {
			result = 0;
		} else {
			result = casesBU(s + arr[m - 1], n, arr, m) + casesBU(s, n, arr, m - 1);
		}
		return result;
	}

	// DP
	private static int casesDP(int amount, int[] coinArr) {
		int[] T = new int[amount + 1];

		Arrays.fill(T, 0);

		T[0] = 1;

		for (int i = 0; i < coinArr.length; i++) {
			for (int j = coinArr[i]; j <= amount; j++) {
				T[j] += T[j - coinArr[i]];
			}
		}
		return T[amount];
	}
}
