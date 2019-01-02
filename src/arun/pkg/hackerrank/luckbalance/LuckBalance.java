package arun.pkg.hackerrank.luckbalance;

import java.io.IOException;

public class LuckBalance {

	// Complete the luckBalance function below.
	static int luckBalance(int k, int[][] contests) {
		int luckSum = 0;
		for (int i = 0; i < k; i++) {
			int maxVal = Integer.MIN_VALUE;
			int maxPos = -1;
			for (int j = 0; j < contests.length; j++) {
				if (1 == contests[j][1] && maxVal < contests[j][0]) {
					maxVal = contests[j][0];
					maxPos = j;
				}
			}
			if (-1 != maxPos) {
				luckSum += maxVal;
				contests[maxPos][0] = 0;
			}
		}

		for (int i = 0; i < contests.length; i++) {
			if (1 == contests[i][1]) {
				luckSum -= contests[i][0];
			} else {
				luckSum += contests[i][0];
			}
		}
		return luckSum;
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// String[] nk = scanner.nextLine().split(" ");

		int n = 6;// Integer.parseInt(nk[0]);

		int k = 3;// Integer.parseInt(nk[1]);

		int[][] contests = { { 5, 1 }, { 2, 1 }, { 1, 1 }, { 8, 1 }, { 10, 0 }, { 5, 0 } };

//		for (int i = 0; i < n; i++) {
//			String[] contestsRowItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//			for (int j = 0; j < 2; j++) {
//				int contestsItem = Integer.parseInt(contestsRowItems[j]);
//				contests[i][j] = contestsItem;
//			}
//		}

		int result = luckBalance(k, contests);

		System.out.println(result);

		// scanner.close();
	}
}
