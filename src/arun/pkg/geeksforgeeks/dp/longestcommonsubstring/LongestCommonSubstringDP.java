package arun.pkg.geeksforgeeks.dp.longestcommonsubstring;

import java.util.Scanner;

public class LongestCommonSubstringDP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while (tests > 0) {
			int len1 = sc.nextInt();
			int len2 = sc.nextInt();

			String str1 = sc.next();
			String str2 = sc.next();

			System.out.println(commonSubstring(str1, str2));

			tests--;
		}
		sc.close();
	}

	private static int commonSubstring(String str1, String str2) {
		int max = 0;
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					matrix[i + 1][j + 1] = matrix[i][j] + 1;
					if (max < matrix[i + 1][j + 1]) {
						max = matrix[i + 1][j + 1];
					}
				} else {
					matrix[i + 1][j + 1] = 0;
				}
			}
		}
		return max;
	}
}
