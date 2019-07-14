package arun.pkg.practice.dp.knapsack;

//https://www.youtube.com/watch?v=xOlhR_2QCXY&list=PLBZBJbE_rGRU5PrgZ9NBHJwcaZsNpf8yD&index=2
public class KnapsackRecursion {
	static int[] W = { 1, 2, 4, 2, 5 };
	static int[] V = { 5, 3, 5, 3, 2 };

	public static void main(String[] args) {
		int n = W.length - 1;
		int C = 10;
		System.out.println(KS(n, C));
	}

	private static int KS(int n, int C) {
		int result = 0;
		if (n == 0 || C == 0) {
			result = 0;
		} else if (W[n] > C) {
			result = KS(n - 1, C);
		} else {
			int temp1 = KS(n - 1, C);
			int temp2 = V[n] + KS(n - 1, C - W[n]);
			result = max(temp1, temp2);
		}
		return result;
	}

	private static int max(int temp1, int temp2) {
		return temp1 > temp2 ? temp1 : temp2;
	}
}
