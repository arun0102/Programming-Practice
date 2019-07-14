package arun.pkg.practice.dp.nstairsproblem;

import java.util.Scanner;

public class NStairsProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int stairs = sc.nextInt();

			int[] memo = new int[stairs + 1];
			System.out.println(fun(stairs, memo));
		}
		sc.close();
	}

	private static int fun(int n, int[] memo) {
		int result = 0;
		if (memo[n] != 0) {
			return memo[n];
		}
		if (n == 0 || n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			result = fun(n - 1, memo) + fun(n - 2, memo) + fun(n - 3, memo);
		}
		memo[n] = result;
		return result;
	}
}
