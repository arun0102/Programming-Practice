package arun.pkg.pibonaccisum;

/*don't place package name!*/

import java.util.Scanner;

class PibonacciSum {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		int j = s.nextInt();

		System.out.println(getPrimonacciNumbersSum(i, j));
	}

	// 1 1 2 3 5 8 13 21 34 55 89
	private static int getPrimonacciNumbersSum(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (isFibonacciNumber(i)) {
				if (isPrimeNumber(i)) {
					sum = sum + i;
				}
			}
		}
		return sum;
	}

	private static boolean isFibonacciNumber(int num) {
		int a = 0, b = 1, c = 0;
		while (c < num) {
			c = a + b;
			a = b;
			b = c;
		}
		if (c == num) {
			return true;
		}
		return false;
	}

	private static boolean isPrimeNumber(int num) {
		if (0 == num) {
			return false;
		}
		if (1 == num) {
			return true;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}