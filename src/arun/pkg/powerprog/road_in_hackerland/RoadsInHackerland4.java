package arun.pkg.powerprog.road_in_hackerland;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/contests/june-world-codesprint/challenges/johnland
// Solution using Floyd-Warshall Algorithm. Passing 5 test cases out of 21
public class RoadsInHackerland4 {

	private static int nodes = 0;
	private static BigInteger MAX;

	static String roadsInHackerland(int n, int[][] roads, int maxVal) {
		nodes = n;
		MAX = new BigInteger("2").pow(maxVal);
		for (int i = 0; i < n; i++) {
			MAX = MAX.add(MAX);
		}

		MAX = MAX.add(new BigInteger("1"));

		BigInteger[][] M = new BigInteger[nodes][nodes];
		for (int i = 0; i < M.length; i++) {
			Arrays.fill(M[i], MAX);
		}
		int[][] val = roads;// { { 1, 3, 5 }, { 4, 5, 0 }, { 2, 1, 3 }, { 3, 2, 1 }, { 4, 3, 4 }, { 4, 2, 2
							// } };
		for (int i = 0; i < val.length; i++) {
			BigInteger a = new BigInteger("2").pow(val[i][2]);
			if (M[val[i][0] - 1][val[i][1] - 1] == MAX || M[val[i][0] - 1][val[i][1] - 1].compareTo(a) > 0) {
				M[val[i][0] - 1][val[i][1] - 1] = a;
				M[val[i][1] - 1][val[i][0] - 1] = a;
			}
			if (M[val[i][1] - 1][val[i][0] - 1] == MAX || M[val[i][1] - 1][val[i][0] - 1].compareTo(a) > 0) {
				M[val[i][0] - 1][val[i][1] - 1] = a;
				M[val[i][1] - 1][val[i][0] - 1] = a;
			}
		}

		BigInteger[][] path = findShortestPaths(M);
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < path.length; i++) {
			// System.out.println(Arrays.toString(path[i]));
			for (int j = i + 1; j < path[i].length; j++) {
				sum = sum.add(path[i][j]);
			}
		}
		System.out.println(sum);
		return sum.toString(2);
	}

	static BigInteger[][] findShortestPaths(BigInteger[][] M) {
		for (int k = 0; k < nodes; k++) {
			for (int i = 0; i < nodes; i++) {
				for (int j = 0; j < nodes; j++) {
					if (M[i][k].add(M[k][j]).compareTo(M[i][j]) < 0) {
						M[i][j] = M[i][k].add(M[k][j]);
					}

					if (M[j][k].add(M[k][i]).compareTo(M[j][i]) < 0) {
						M[j][i] = M[j][k].add(M[k][i]);
					}
				}
			}
		}
		return M;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0].trim()); // 5;// 18;// 100000;//

		int m = Integer.parseInt(nm[1].trim()); // 6;// 23;// 138000;//

//		int[][] roads = { { 5, 12, 18 }, { 17, 2, 5 }, { 7, 18, 3 }, { 17, 6, 0 }, { 15, 12, 16 }, { 2, 3, 8 },
//				{ 14, 9, 20 }, { 4, 9, 11 }, { 13, 1, 21 }, { 13, 12, 15 }, { 15, 12, 10 }, { 6, 16, 9 }, { 11, 18, 2 },
//				{ 9, 16, 17 }, { 12, 4, 4 }, { 7, 4, 19 }, { 17, 1, 12 }, { 10, 14, 7 }, { 8, 5, 13 }, { 18, 3, 14 },
//				{ 4, 11, 6 }, { 15, 3, 1 }, { 12, 5, 22 } };
//		int[][] roads = { { 1, 3, 5 }, { 4, 5, 0 }, { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 4 }, { 2, 4, 2 } };

		int[] weights = new int[m];
		int[][] roads = new int[m][3];

		for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
			String[] roadsRowItems = scanner.nextLine().split(" ");

			for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
				int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
				roads[roadsRowItr][roadsColumnItr] = roadsItem;
				if (2 == roadsColumnItr) {
					weights[roadsRowItr] = roadsItem;
				}
			}
		}

		int maxVal = Arrays.stream(weights).max().getAsInt();

//		long oldTime = System.currentTimeMillis();
		String result = roadsInHackerland(n, roads, maxVal);

		System.out.println(result);
//		System.out.println("Time : " + (System.currentTimeMillis() - oldTime));
	}
}
