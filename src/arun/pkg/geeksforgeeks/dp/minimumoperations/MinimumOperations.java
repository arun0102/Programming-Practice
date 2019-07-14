package arun.pkg.geeksforgeeks.dp.minimumoperations;

import java.util.Scanner;

class MinimumOperations {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int tests = scanner.nextInt();
		while (tests > 0) {
			int num = scanner.nextInt();
			System.out.println(getNumberOperations(num));
			tests--;
		}
		scanner.close();
	}

	private static int getNumberOperations(int num) {
		if (num == 0) {
			return 0;
		} else if (num < 0) {
			return -1;
		} else {
			if (num % 2 == 0) {
				return 1 + getNumberOperations(num / 2);
			} else {
				return 1 + getNumberOperations(num - 1);
			}
		}
	}
}