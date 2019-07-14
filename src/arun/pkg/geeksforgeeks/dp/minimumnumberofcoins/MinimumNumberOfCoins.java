package arun.pkg.geeksforgeeks.dp.minimumnumberofcoins;

import java.util.Scanner;

public class MinimumNumberOfCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while (tests > 0) {
			int num = sc.nextInt();
			int[] denArr = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

			while (num != 0) {
				for (int i = denArr.length - 1; i >= 0; i--) {
					if (denArr[i] <= num) {
						num -= denArr[i];
						System.out.print(denArr[i] + " ");
						break;
					}
				}
			}
			System.out.println();
			tests--;
		}
	}
}
