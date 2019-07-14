package arun.pkg.geeksforgeeks.dp.maxchainlength;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
	int x;
	int y;

	public Pair(int a, int b) {
		x = a;
		y = b;
	}
}

public class MaxChainLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Pair pr[] = new Pair[n];
			int arr[] = new int[2 * n];
			for (int i = 0; i < 2 * n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0, j = 0; i < 2 * n - 1 && j < n; i = i + 2, j++) {
				pr[j] = new Pair(arr[i], arr[i + 1]);
			}
			GfG g = new GfG();
			System.out.println(g.maxChainLength(pr, n));
		}
	}
}

/*
 * This is a function problem.You only need to complete the function given below
 */

class CompareByFirst implements Comparator<Pair> {
	public int compare(Pair a, Pair b) {
		return a.y - b.y;
	}
}

class GfG {
	int maxChainLength(Pair arr[], int n) {
		Arrays.sort(arr, new CompareByFirst());
		int index = 0;
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[index].y < arr[i].x) {
				count++;
				index = i;
			}
		}
		return count;
	}
}
