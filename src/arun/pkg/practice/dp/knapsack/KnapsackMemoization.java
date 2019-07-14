package arun.pkg.practice.dp.knapsack;

//https://www.youtube.com/watch?v=xOlhR_2QCXY&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2
public class KnapsackMemoization {
	static int[] W = { 1, 2, 4, 2, 5 };
	static int[] V = { 5, 3, 5, 3, 2 };

	public static void main(String[] args) {
		int n = W.length - 1;
		int C = 10;
		int[][] arr = new int[W.length][C];
		System.out.println(KS(n, C, arr));
	}

	private static int KS(int n, int C, int[][] arr) {
		int result = 0;
		if (arr[n][C - 1] != 0) {
			return arr[n][C - 1];
		}
		if (n == 0 || C == 0) {
			result = 0;
		} else if (W[n] > C) {
			result = KS(n - 1, C, arr);
		} else {
			int temp1 = KS(n - 1, C, arr);
			int temp2 = V[n] + KS(n - 1, C - W[n], arr);
			result = max(temp1, temp2);
		}
		arr[n][C - 1] = result;
		return result;
	}

	private static int max(int temp1, int temp2) {
		return temp1 > temp2 ? temp1 : temp2;
	}
}
