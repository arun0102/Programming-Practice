package arun.pkg.practice.dp.longestcommonsubsequence;

public class LCSMemoization {
	public static void main(String[] args) {
		String P = "BATD";
		String Q = "ABACD";
		int[][] arr = new int[P.length() + 1][Q.length() + 1];
		System.out.println(LCS(P, Q, P.length(), Q.length(), arr));
	}

	private static int LCS(String P, String Q, int n, int m, int[][] arr) {
		if (arr[n][m] != 0) {
			return arr[n][m];
		}
		int result = 0;
		if (n == 0 || m == 0) {
			result = 0;
		} else if (P.charAt(n - 1) == Q.charAt(m - 1)) {
			result = 1 + LCS(P, Q, n - 1, m - 1, arr);
		} else {
			int temp1 = LCS(P, Q, n - 1, m, arr);
			int temp2 = LCS(P, Q, n, m - 1, arr);
			result = max(temp1, temp2);
		}
		arr[n][m] = result;
		return result;
	}

	private static int max(int temp1, int temp2) {
		return temp1 > temp2 ? temp1 : temp2;
	}
}
