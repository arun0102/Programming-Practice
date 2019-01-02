package arun.pkg.hackerrank.graph.kruskal_really_special_subtree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

	/*
	 * Complete the 'kruskals' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * WEIGHTED_INTEGER_GRAPH g as parameter.
	 */

	/*
	 * For the weighted graph, <name>:
	 *
	 * 1. The number of nodes is <name>Nodes. 2. The number of edges is <name>Edges.
	 * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the
	 * edge is <name>Weight[i].
	 *
	 */

	public static int kruskals(int nodes, List<Integer> fromArr, List<Integer> toArr, List<Integer> weightArr) {
		int sum = 0;
		boolean[] mstSet = new boolean[weightArr.size()];
		int[] key = new int[nodes];
		for (int i = 0; i < weightArr.size(); i++) {
			int minIndex = getMinWeight(weightArr);
			mstSet[minIndex] = true;
			for (int j = 0; j < weightArr.size(); j++) {
				if (!mstSet[j] && 0 == key[fromArr.get(minIndex)]) {
					key[fromArr.get(minIndex)] = 1;
					sum += weightArr.get(minIndex);
					weightArr.remove(minIndex);
					fromArr.remove(minIndex);
					toArr.remove(minIndex);
					break;
				}
			}
		}
		return sum;
	}

	static int getMinWeight(List<Integer> weightArr) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < weightArr.size(); i++) {
			if (weightArr.get(i) < min) {
				min = weightArr.get(i);
				minIndex = i;
			}
		}
		return minIndex;
	}
}

public class KrushkalReallySpecialSubtree {
	public static void main(String[] args) throws IOException {

		String[] gNodesEdges = "4 6".split(" ");

		int gNodes = Integer.parseInt(gNodesEdges[0]);
		int gEdges = Integer.parseInt(gNodesEdges[1]);

		List<Integer> gFrom = new ArrayList<>();
		List<Integer> gTo = new ArrayList<>();
		List<Integer> gWeight = new ArrayList<>();
		String[] data = { "1 2 5", "1 3 3", "4 1 6", "2 4 7", "3 2 4", "3 4 5" };
		Arrays.asList(data).forEach(i -> {
			try {
				String[] gFromToWeight = i.split(" ");

				gFrom.add(Integer.parseInt(gFromToWeight[0]));
				gTo.add(Integer.parseInt(gFromToWeight[1]));
				gWeight.add(Integer.parseInt(gFromToWeight[2]));
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		});

		int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

		System.out.println(res);
	}
}
