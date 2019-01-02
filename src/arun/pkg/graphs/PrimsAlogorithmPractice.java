package arun.pkg.graphs;

import java.util.Arrays;

public class PrimsAlogorithmPractice {
	public static void main(String[] args) {
		int[][] graph = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		primMST(graph);
	}

	static void primMST(int[][] graph) {
		int[] parent = new int[graph.length];
		int[] key = new int[graph.length];
		boolean[] mstSet = new boolean[graph.length];

		Arrays.fill(key, Integer.MAX_VALUE);
		Arrays.fill(mstSet, false);

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < graph.length - 1; i++) {
			int minIndex = getMinKeyIndex(key, mstSet);
			mstSet[minIndex] = true;
			for (int j = 0; j < graph.length; j++) {
				if (!mstSet[j] && 0 != graph[minIndex][j] && graph[minIndex][j] < key[j]) {
					parent[j] = minIndex;
					key[j] = graph[minIndex][j];
				}
			}
		}

		for (int i = 1; i < graph.length; i++) {
			System.out.println(graph[i][parent[i]]);
		}
	}

	static int getMinKeyIndex(int[] key, boolean[] mstSet) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < key.length; i++) {
			if (!mstSet[i] && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
