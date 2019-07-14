package arun.pkg.geeksforgeeks.dp.longestcommonsubstring;

import java.util.Scanner;

public class LongestCommonSubstring {
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
		String maxStr = "";
		for (int i = 0; i < str1.length(); i++) {
			int firstPos = i;
			int tempMax = 0;
			for (int j = 0; j < str2.length(); j++) {
				if (firstPos < str1.length() && str1.charAt(firstPos) == str2.charAt(j)) {
					firstPos++;
					tempMax++;
					if (max < tempMax) {
						max = tempMax;
						maxStr = str1.substring(i, firstPos);
					}
				} else {
					if (tempMax > 0) {
						j--;
					}
					if (max < tempMax) {
						max = tempMax;
						maxStr = str1.substring(i, firstPos);
					}
					tempMax = 0;
					firstPos = i;
				}
			}
		}
		System.out.println(maxStr);
		return max;
	}
}
