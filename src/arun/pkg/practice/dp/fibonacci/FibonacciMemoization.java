package arun.pkg.practice.dp.fibonacci;

//https://www.youtube.com/watch?v=vYquumk4nWw&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2&t=0s
public class FibonacciMemoization {
	public static void main(String[] args) {
		int n = 1000;
		int[] memo = new int[n + 1];
		System.out.println(fib(n, memo));
	}

	private static int fib(int n, int[] memo) {
		if(memo[n] != 0) {
			return memo[n];
		}
		int result = 0;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = fib(n - 1, memo) + fib(n - 2, memo);
		}
		memo[n] = result;
		return result;
	}
}