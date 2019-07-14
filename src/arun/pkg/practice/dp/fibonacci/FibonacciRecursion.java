package arun.pkg.practice.dp.fibonacci;

// https://www.youtube.com/watch?v=vYquumk4nWw&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2&t=0s
public class FibonacciRecursion {
	public static void main(String[] args) {
		int n = 50;
		System.out.println(fib(n));
	}

	private static int fib(int n) {
		int result = 0;
		if (n == 1 || n == 2) {
			result = 1;
		} else {
			result = fib(n - 1) + fib(n - 2);
		}
		return result;
	}
}
