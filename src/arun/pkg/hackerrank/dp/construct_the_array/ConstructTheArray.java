package arun.pkg.hackerrank.dp.construct_the_array;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstructTheArray {

	static Set<String> set = new HashSet<>();

	// Complete the countArray function below.
	static long countArray(int n, int k, int x) {
		// Return the number of ways to fill in the array.
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		arr[0] = 1;
		arr[n - 1] = x;

		rec(arr, 1, 2, k, x);
		return set.size();
	}

	static void rec(int[] arr, int pivot, int pos, int k, int x) {
		for (int i = 1; i <= k; i++) {
			if (arr[pivot - 1] != i) {
				arr[pivot] = i;
				loopPosition(arr, pos, k, x, 0);
			}
		}
	}

	static void loopPosition(int[] arr, int pos, int k, int x, long count) {
		if (pos == arr.length - 1) {
			return;
		}
		for (int i = 1; i <= k; i++) {
			if (arr[pos - 1] != i) {
				arr[pos] = i;
				if (arr[pos + 1] != i && !set.contains(Arrays.toString(arr))) {
//					System.out.println(Arrays.toString(arr));
					set.add(Arrays.toString(arr));
				}
				loopPosition(arr, pos + 1, k, x, count);
			}
		}
	}

	public static void main(String[] args) throws IOException {
//		String[] nkx = "33260 96055 24745".split(" "); // 266262299
//		String[] nkx = "4 3 2".split(" "); // 266262299
		String[] nkx = "761 99 1".split(" "); // 236568308
		int n = Integer.parseInt(nkx[0]);

		int k = Integer.parseInt(nkx[1]);

		int x = Integer.parseInt(nkx[2]);

//		long answer = countArray(n, k, x);
		long answer = countArrays(n, k, x);

		System.out.println(answer);
	}

	static int MOD = 1000000007;

//	static long countArrays(int n, int k, int x) {
//		int[] a = new int[n];
//		int[] b = new int[n];
//
//		a[0] = x == 1 ? 1 : 0;
//		b[0] = x == 1 ? 0 : 1;
//
//		for (int i = 1; i < n; i++) {
//			a[i] = b[i - 1] % MOD;
//			b[i] = (a[i - 1] * (k - 1) + b[i - 1] * (k - 2)) % MOD;
//		}
//		return a[n - 1];
//	}
	static long countArrays(int n, int k, int x) {
		if (n < 2)
			return 1L;
		long w = 1L, wo = (long) (k - 2), tmp = 0L, M = 1000000007, mult = (long) (k - 2);
		if (x == 1) {
			w -= 1;
			wo += 1;
		}
		for (int i = 2; i < n - 1; i++) {
			tmp = wo;
			wo *= mult;
			wo += w * (long) (k - 1);
			wo %= M;
			w = tmp;
			w %= M;
		}
		return wo % 1000000007;
	}
}
