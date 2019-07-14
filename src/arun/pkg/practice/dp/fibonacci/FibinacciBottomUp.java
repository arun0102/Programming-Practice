package arun.pkg.practice.dp.fibonacci;

//https://www.youtube.com/watch?v=vYquumk4nWw&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2&t=0s
public class FibinacciBottomUp {
	public static void main(String[] args) {
		int n = 10000;
		System.out.println(fib(n));
	}

	private static long fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			long[] bottomUp = new long[n + 1];
			bottomUp[1] = 1;
			bottomUp[2] = 1;

			for (int i = 3; i <= n; i++) {
				bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
			}
			return bottomUp[n];
		}
	}
}
