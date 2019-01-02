package arun.pkg.hackerrank.sherlockandcost;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SherlockAndCost {

	static HashMap<String, Integer> map = new HashMap<>();

	// Complete the cost function below.
	static int cost(int[] B) {
		map = new HashMap<>();
		int[] arr = new int[B.length];
		Arrays.fill(arr, 1);
		for (int i = 0; i < arr.length; i++) {
			rec(arr, B, i);
		}

		return map.values().stream().max(Comparator.naturalOrder()).get();
	}

	static void rec(int[] arr, int[] B, int incPos) {
		if (incPos == B.length) {
			return;
		}
		for (int i = 0; i < B[incPos]; i++) {
			arr[incPos] = i + 1;
			rec(arr, B, incPos + 1);
			addToMap(arr);
		}
	}

	static void addToMap(int[] arr) {
		if (!map.containsKey(Arrays.toString(arr))) {
			map.put(Arrays.toString(arr), findSumDiff(arr));
		}
	}

	static int findSumDiff(int[] arr) {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			sum += Math.abs(arr[i] - arr[i - 1]);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		String testcase = "100 2 100 2 100";
		String[] BItems = testcase.split(" ");
		int[] B = new int[BItems.length];

		for (int i = 0; i < B.length; i++) {
			int BItem = Integer.parseInt(BItems[i]);
			B[i] = BItem;
		}

		int result = cost(B);
		System.out.println(result);
	}
}
