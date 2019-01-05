package arun.pkg.powerprog.road_in_hackerland;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/contests/june-world-codesprint/challenges/johnland
public class RoadsInHackerland2 {

	/*
	 * Complete the roadsInHackerland function below.
	 */
	static String roadsInHackerland(int n, int[][] roads) {
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < roads.length; i++) {
			if (map.containsKey(roads[i][0])) {
				List<int[]> list = map.get(roads[i][0]);
				boolean isFound = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == roads[i][1]) {
						if (list.get(j)[1] > roads[i][2]) {
							list.get(j)[1] = roads[i][2];
						}
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					list.add(new int[] { roads[i][1], roads[i][2] });
					map.put(roads[i][0], list);
				}
			} else {
				List<int[]> valArr = new ArrayList<>();
				valArr.add(new int[] { roads[i][1], roads[i][2] });
				map.put(roads[i][0], valArr);
			}

			if (map.containsKey(roads[i][1])) {
				List<int[]> list = map.get(roads[i][1]);
				boolean isFound = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == roads[i][0]) {
						if (list.get(j)[1] > roads[i][2]) {
							list.get(j)[1] = roads[i][2];
						}
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					list.add(new int[] { roads[i][0], roads[i][2] });
					map.put(roads[i][1], list);
				}
			} else {
				List<int[]> valArr = new ArrayList<>();
				valArr.add(new int[] { roads[i][0], roads[i][2] });
				map.put(roads[i][1], valArr);
			}
		}
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				List<Integer> nodesArr = new ArrayList<>();
				// nodesArr.add(i);
				sumTotal = BigInteger.ZERO;
				getMinDistance(i, j, BigInteger.ZERO, map, nodesArr);
				System.out.println(i + "-" + j + " = " + sumTotal);
//				System.out.println("------------------------");
				sum = sum.add(sumTotal);
			}
		}
		System.out.println(sum);
		return sum.toString(2);
	}

	static BigInteger sumTotal = BigInteger.ZERO;

	static void getMinDistance(int sourcePos, int destPos, BigInteger sum, Map<Integer, List<int[]>> map,
			List<Integer> nodesArr) {
		nodesArr.add(sourcePos);
		List<int[]> arr = map.get(sourcePos);
		for (int i = 0; i < arr.size(); i++) {
			if (!nodesArr.contains(arr.get(i)[0])) {
				if (arr.get(i)[0] == destPos) {
					BigInteger add = sum.add(new BigInteger("2").pow(arr.get(i)[1]));
					if (sumTotal == BigInteger.ZERO || sumTotal.compareTo(add) > 0) {
						sumTotal = add;
					}
//					System.out.println(nodesArr.toString());
				} else {
					BigInteger add = sum.add(new BigInteger("2").pow(arr.get(i)[1]));
					if (sumTotal == BigInteger.ZERO || sumTotal.compareTo(add) > 0) {
						getMinDistance(arr.get(i)[0], destPos, add, map, new ArrayList<>(nodesArr));
					}
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String[] nm = scanner.nextLine().split(" ");

		int n = 300;// // 100000;// Integer.parseInt(nm[0].trim());

		int m = 350;// // 138000;//Integer.parseInt(nm[1].trim());

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
