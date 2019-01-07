package arun.pkg.powerprog.road_in_hackerland;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/contests/june-world-codesprint/challenges/johnland
// Solution with a faster approach using Dijkstra Algorithm. Passing 7 test cases out of 21
public class RoadsInHackerland3 {

	static String roadsInHackerland(int n, int[][] roads) {
		long oldTime = System.currentTimeMillis();
		int maxPow = Integer.MIN_VALUE;
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < roads.length; i++) {
			if (map.containsKey(roads[i][0])) {
				List<int[]> list = map.get(roads[i][0]);
				boolean isFound = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == roads[i][1]) {
						if (list.get(j)[1] > roads[i][2]) {
							list.get(j)[1] = roads[i][2];
							if (maxPow < list.get(j)[1]) {
								maxPow = list.get(j)[1];
							}
						}
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					if (maxPow < roads[i][2]) {
						maxPow = roads[i][2];
					}
					list.add(new int[] { roads[i][1], roads[i][2] });
					map.put(roads[i][0], list);
				}
			} else {
				if (maxPow < roads[i][2]) {
					maxPow = roads[i][2];
				}
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
							if (maxPow < roads[j][1]) {
								maxPow = roads[j][1];
							}
						}
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					if (maxPow < roads[i][2]) {
						maxPow = roads[i][2];
					}
					list.add(new int[] { roads[i][0], roads[i][2] });
					map.put(roads[i][1], list);
				}
			} else {
				if (maxPow < roads[i][2]) {
					maxPow = roads[i][2];
				}
				List<int[]> valArr = new ArrayList<>();
				valArr.add(new int[] { roads[i][0], roads[i][2] });
				map.put(roads[i][1], valArr);
			}
		}

		System.out.println("Map Time : " + (System.currentTimeMillis() - oldTime));
		BigInteger sum = BigInteger.ZERO;
		BigInteger MAX = new BigInteger("2").pow(maxPow + 1);
		for (int i = 1; i < n; i++) {
			BigInteger[] val = new BigInteger[n];
			// val[i - 1] = BigInteger.ZERO;
			Arrays.fill(val, MAX);
			List<int[]> arr = map.get(i);
			for (int j = 0; j < arr.size(); j++) {
				val[arr.get(j)[0] - 1] = new BigInteger("2").pow(arr.get(j)[1]);
			}
			Set<Integer> visitedArr = new HashSet<>();
			while (visitedArr.size() < n - 1) {
				// List<int[]> list = map.get(i);
				int minIndex = 0;
				BigInteger minVal = MAX;
				for (int j = 0; j < val.length; j++) {
					if (!visitedArr.contains(j + 1)) {
						if (val[j].compareTo(minVal) < 0) {
							minVal = val[j];
							minIndex = j + 1;
						}
					}
				}
				visitedArr.add(minIndex);

				List<int[]> valArr = map.get(minIndex);
				for (int j = 0; j < valArr.size(); j++) {
					if (i != (valArr.get(j)[0]) && !visitedArr.contains(valArr.get(j)[0]) && val[valArr.get(j)[0] - 1]
							.compareTo(minVal.add(new BigInteger("2").pow(valArr.get(j)[1]))) > 0) {
						val[valArr.get(j)[0] - 1] = minVal.add(new BigInteger("2").pow(valArr.get(j)[1]));
					}
				}
			}
			// System.out.println(visitedArr.toString());
//			 System.out.println(Arrays.toString(val));
			for (int j = i; j < val.length; j++) {
				sum = sum.add(val[j]);
			}
		}
		System.out.println(sum);
		return sum.toString(2);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String[] nm = scanner.nextLine().split(" ");

		int n = 18;// 100000;// Integer.parseInt(nm[0].trim());

		int m = 23;// 138000;//Integer.parseInt(nm[1].trim());

		int[][] roads = { { 5, 12, 18 }, { 17, 2, 5 }, { 7, 18, 3 }, { 17, 6, 0 }, { 15, 12, 16 }, { 2, 3, 8 },
				{ 14, 9, 20 }, { 4, 9, 11 }, { 13, 1, 21 }, { 13, 12, 15 }, { 15, 12, 10 }, { 6, 16, 9 }, { 11, 18, 2 },
				{ 9, 16, 17 }, { 12, 4, 4 }, { 7, 4, 19 }, { 17, 1, 12 }, { 10, 14, 7 }, { 8, 5, 13 }, { 18, 3, 14 },
				{ 4, 11, 6 }, { 15, 3, 1 }, { 12, 5, 22 } };
//		int[][] roads = { { 1, 3, 5 }, { 4, 5, 0 }, { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 4 }, { 2, 4, 2 } };

//		int[][] roads = new int[m][3];
//
//		for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
//			String[] roadsRowItems = scanner.nextLine().split(" ");
//
//			for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
//				int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr].trim());
//				roads[roadsRowItr][roadsColumnItr] = roadsItem;
//			}
//		}

		long oldTime = System.currentTimeMillis();
//		String result = roadsInHackerland(n, map);
		String result = roadsInHackerland(n, roads);

		System.out.println(result);
		System.out.println("Time : " + (System.currentTimeMillis() - oldTime));
	}
}
