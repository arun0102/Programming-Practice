package arun.pkg.powerprog.road_in_hackerland;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/contests/june-world-codesprint/challenges/johnland
public class RoadsInHackerland {

	/*
	 * Complete the roadsInHackerland function below.
	 */
	static String roadsInHackerland(int n, int[][] roads) {
		BigInteger sum = BigInteger.ZERO;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < roads.length; i++) {
			if (map.containsKey(roads[i][0] + "-" + roads[i][1])) {
				int val = map.get(roads[i][0] + "-" + roads[i][1]);
				if (roads[i][2] < val) {
					map.put(roads[i][0] + "-" + roads[i][1], roads[i][2]);
				} else {
					roads[i][2] = val;
				}
			} else if (map.containsKey(roads[i][1] + "-" + roads[i][0])) {
				int val = map.get(roads[i][1] + "-" + roads[i][0]);
				if (roads[i][2] < val) {
					map.put(roads[i][0] + "-" + roads[i][1], roads[i][2]);
				} else {
					roads[i][2] = val;
				}
			} else {
				map.put(roads[i][0] + "-" + roads[i][1], roads[i][2]);
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				BigInteger dist = getMinDistance(i, j, roads);
				System.out.println(i + "-" + j + " = " + dist);
				System.out.println("------------------------");
				sum = sum.add(dist);
			}
		}
		System.out.println(sum);
		return sum.toString(2);
	}

	static BigInteger getMinDistance(int sourcePos, int destPos, int[][] roads) {
		sumTotal = BigInteger.ZERO;
		// pre-populate min distance if there is a direct path
		for (int i = 0; i < roads.length; i++) {
			if ((roads[i][0] == sourcePos && roads[i][1] == destPos)
					|| (roads[i][0] == destPos && roads[i][1] == sourcePos)) {
				sumTotal = new BigInteger("2").pow(roads[i][2]);
			} else if ((roads[i][0] == sourcePos || roads[i][1] == sourcePos)) {
				int x = sourcePos;
				int y = roads[i][0] == sourcePos ? roads[i][1] : roads[i][0];
				List<Integer> nodesArr = new ArrayList<>();
				nodesArr.add(x);
				BigInteger sum = new BigInteger("2").pow(roads[i][2]);
				minD(sourcePos, destPos, x, y, sum, roads, nodesArr);
			}
		}

		return sumTotal;
	}

	static BigInteger sumTotal = BigInteger.ZERO;// BigInteger.valueOf(Integer.MAX_VALUE);

	static void minD(int sourcePos, int destPos, int x, int y, BigInteger sum, int[][] roads, List<Integer> nodesArr) {
		nodesArr.add(y);
		if ((x == sourcePos && y == destPos) || (x == destPos && y == sourcePos)) {
			// System.out.println(nodesArr.toString());
			if (sumTotal == BigInteger.ZERO || sumTotal.compareTo(sum) > 0) {
				sumTotal = sum;
			}
		} else {
			for (int i = 0; i < roads.length; i++) {
				if ((roads[i][0] == sourcePos && roads[i][1] == destPos)
						|| (roads[i][0] == destPos && roads[i][1] == sourcePos)) {
					// skip this case
				} else if ((y == roads[i][0] || y == roads[i][1])) {
					BigInteger add = sum.add(new BigInteger("2").pow(roads[i][2]));
					if (sumTotal == BigInteger.ZERO || sumTotal.compareTo(add) > 0) {
						if (y == roads[i][0] && !nodesArr.contains(roads[i][1])) {
							minD(sourcePos, destPos, x, roads[i][1], add, roads, new ArrayList<Integer>(nodesArr));
						} else if (!nodesArr.contains(roads[i][0])) {
							minD(sourcePos, destPos, x, roads[i][0], add, roads, new ArrayList<Integer>(nodesArr));
						}
					}
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String[] nm = scanner.nextLine().split(" ");

		int n = 300;// Integer.parseInt(nm[0].trim());

		int m = 350;// Integer.parseInt(nm[1].trim());

//		int[][] roads = { { 5, 12, 18 }, { 17, 2, 5 }, { 7, 18, 3 }, { 17, 6, 0 }, { 15, 12, 16 }, { 2, 3, 8 },
//				{ 14, 9, 20 }, { 4, 9, 11 }, { 13, 1, 21 }, { 13, 12, 15 }, { 15, 12, 10 }, { 6, 16, 9 }, { 11, 18, 2 },
//				{ 9, 16, 17 }, { 12, 4, 4 }, { 7, 4, 19 }, { 17, 1, 12 }, { 10, 14, 7 }, { 8, 5, 13 }, { 18, 3, 14 },
//				{ 4, 11, 6 }, { 15, 3, 1 }, { 12, 5, 22 } };
//		int[][] roads = { { 1, 3, 5 }, { 4, 5, 0 }, { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 4 }, { 2, 4, 2 } };

		int[][] roads = new int[m][3];

		for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
			String[] roadsRowItems = scanner.nextLine().split(" ");

			for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
				int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
				roads[roadsRowItr][roadsColumnItr] = roadsItem;
			}
		}
		long oldTime = System.currentTimeMillis();
		String result = roadsInHackerland(n, roads);

		System.out.println(result);
		System.out.println("Time : " + (System.currentTimeMillis() - oldTime));
	}
}
