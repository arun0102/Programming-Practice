package arun.pkg.hackerrank.electronicsshop;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/electronics-shop/problem
public class ElectronicsShop {

	/*
	 * Complete the getMoneySpent function below.
	 */
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		Arrays.sort(keyboards);
		Arrays.sort(drives);

		int maxAmount = -1;
		for (int i = 0; i < drives.length; i++) {
			for (int j = 0; j < keyboards.length; j++) {
				int sum = drives[i] + keyboards[j];
				if (sum <= b && maxAmount < sum) {
					maxAmount = sum;
				}
			}
		}
		return maxAmount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

//		String[] bnm = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//		int b = Integer.parseInt(bnm[0]);
//
//		int n = Integer.parseInt(bnm[1]);
//
//		int m = Integer.parseInt(bnm[2]);
//
//		int[] keyboards = new int[n];
//
//		String[] keyboardsItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//		for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
//			int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
//			keyboards[keyboardsItr] = keyboardsItem;
//		}
//
//		int[] drives = new int[m];
//
//		String[] drivesItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//		for (int drivesItr = 0; drivesItr < m; drivesItr++) {
//			int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
//			drives[drivesItr] = drivesItem;
//		}

		/*
		 * The maximum amount of money she can spend on a keyboard and USB drive, or -1
		 * if she can't purchase both items
		 */

		int[] drives = { 4 };
		int[] keyboards = { 5 };
		int b = 5;
		int moneySpent = getMoneySpent(keyboards, drives, b);

		System.out.println(moneySpent);

		scanner.close();
	}
}
