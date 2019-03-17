package arun.pkg.practice.graphs.floyd_warshall;

import java.util.Arrays;
// for undirected graph
public class FloydWarshallAlgorithm2 {
	private static int nodes = 0;
	static int[][] P;

	public static void main(String[] args) {
		nodes = 5;
		P = new int[nodes][nodes];
		int[][] M = new int[nodes][nodes];
		for (int i = 0; i < M.length; i++) {
			Arrays.fill(M[i], 999);
		}
		int[][] val = { { 1, 3, 5 }, { 4, 5, 0 }, { 2, 1, 3 }, { 3, 2, 1 }, { 4, 3, 4 }, { 4, 2, 2 } };
		for (int i = 0; i < val.length; i++) {
			M[val[i][0] - 1][val[i][1] - 1] = (int) Math.pow(2, val[i][2]);
			M[val[i][1] - 1][val[i][0] - 1] = (int) Math.pow(2, val[i][2]);
		}

		int[][] path = findShortestPaths(M);
		for (int i = 0; i < path.length; i++) {
			System.out.println(Arrays.toString(path[i]));
		}
		System.out.println("-----------------------");
		for (int i = 0; i < P.length; i++) {
			System.out.println(Arrays.toString(P[i]));
		}
	}

	static int[][] findShortestPaths(int[][] M) {
		for (int k = 0; k < nodes; k++) {
			for (int i = 0; i < nodes; i++) {
				for (int j = 0; j < nodes; j++) {
					if (M[i][k] + M[k][j] < M[i][j]) {
						M[i][j] = M[i][k] + M[k][j];
						P[i][j] = k;
					}

					if (M[j][k] + M[k][i] < M[j][i]) {
						M[j][i] = M[j][k] + M[k][i];
						P[j][i] = k;
					}
				}
			}
		}
		return M;
	}
}
