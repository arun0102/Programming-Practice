package arun.pkg.powerprog.travel_in_hackerland;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TravelInHackerland2 {

	/*
	 * Complete the travel function below.
	 */
	static int travel(int[] t, int[][] roads, int[][] queries) {
//		for (int i = 0; i < queries.length; i++) {
		List<Integer> setArr = findMST(roads, t, queries[0]);
		System.out.println(setArr);
//		}

		return getMaxCrowd(setArr, roads);
	}

	static int getMaxCrowd(List<Integer> setArr, int[][] roads) {
		int maxCrowd = Integer.MIN_VALUE;
		for (int i = 0; i < setArr.size() - 1; i++) {
			for (int j = 1; j < setArr.size(); j++) {
				int child = setArr.get(i);
				int parent = setArr.get(j);
				int crowd = findFromRoads(child, parent, roads);
				if (-1 != crowd) {
					if (crowd > maxCrowd) {
						maxCrowd = crowd;
					}
				}
			}
		}
		return maxCrowd;
	}

	static int findFromRoads(int child, int parent, int[][] roads) {
		for (int i = 0; i < roads.length; i++) {
			if (roads[i][0] == child && roads[i][1] == parent) {
				return roads[i][2];
			} else if (roads[i][0] == parent && roads[i][1] == child) {
				return roads[i][2];
			}
		}
		return -1;
	}

	static List<Integer> findMST(int[][] arr, int[] t, int[] query) {
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		Map<List<Integer>, Integer> setTypeMap = new HashMap<>();
//		List<Integer> typeArr = new ArrayList<>();
//		List<List<Integer>> setArr = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int[] set = arr[i];
			if (0 == setTypeMap.size()) {
				List<Integer> list = new ArrayList<>();
				list.add(set[0]);
				list.add(set[1]);
				int typeCount = 1;
				if (t[set[0]] != t[set[1]]) {
					typeCount = 2;
				}
				setTypeMap.put(list, typeCount);

				list = getIndex(setTypeMap, query);
				if (null != list) {
					return list;
				}
			} else {
				List<Integer> childIndex = null;
				List<Integer> parentIndex = null;

				Iterator<List<Integer>> iterator = setTypeMap.keySet().iterator();
				while (iterator.hasNext()) {
					List<Integer> list = (List<Integer>) iterator.next();
					if (list.contains(set[0]) && list.contains(set[1])) {
						// do nothing
						childIndex = list;
						parentIndex = list;
						break;
					} else if (list.contains(set[0]) && !list.contains(set[1])) {
						childIndex = list;
					} else if (!list.contains(set[0]) && list.contains(set[1])) {
						parentIndex = list;
					}
				}

				if (childIndex == null && parentIndex == null) {
					List<Integer> list = new ArrayList<>();
					list.add(set[0]);
					list.add(set[1]);
					int typeCount = 1;
					if (t[set[0] - 1] != t[set[1] - 1]) {
						typeCount = 2;
					}
					setTypeMap.put(list, typeCount);

					list = getIndex(setTypeMap, query);
					if (null != list) {
						return list;
					}
				} else if (childIndex == null) {
					parentIndex.add(set[0]);
					int[] typeArr = new int[parentIndex.size()];
					for (int j = 0; j < parentIndex.size(); j++) {
						typeArr[j] = t[parentIndex.get(j) - 1];
					}
					int typeCount = (int) Arrays.stream(typeArr).distinct().count();

					setTypeMap.put(parentIndex, typeCount);

					List<Integer> list = getIndex(setTypeMap, query);
					if (null != list) {
						return list;
					}
				} else if (parentIndex == null) {
					childIndex.add(set[0]);
					int[] typeArr = new int[childIndex.size()];
					for (int j = 0; j < childIndex.size(); j++) {
						typeArr[j] = t[childIndex.get(j) - 1];
					}
					int typeCount = (int) Arrays.stream(typeArr).distinct().count();
					setTypeMap.put(childIndex, typeCount);
					List<Integer> list = getIndex(setTypeMap, query);
					if (null != list) {
						return list;
					}
				} else if (childIndex != parentIndex) {
					setTypeMap.remove(childIndex);
					setTypeMap.remove(parentIndex);
					if (childIndex.size() > parentIndex.size()) {
						childIndex.addAll(parentIndex);
						int[] typeArr = new int[childIndex.size()];
						for (int j = 0; j < childIndex.size(); j++) {
							typeArr[j] = t[childIndex.get(j) - 1];
						}
						int typeCount = (int) Arrays.stream(typeArr).distinct().count();
						setTypeMap.put(childIndex, typeCount);
					} else {
						parentIndex.addAll(childIndex);
						int[] typeArr = new int[parentIndex.size()];
						for (int j = 0; j < parentIndex.size(); j++) {
							typeArr[j] = t[parentIndex.get(j) - 1];
						}
						int typeCount = (int) Arrays.stream(typeArr).distinct().count();
						setTypeMap.put(parentIndex, typeCount);
					}

					List<Integer> list = getIndex(setTypeMap, query);
					if (null != list) {
						return list;
					}
				}
			}
		}

		Iterator<List<Integer>> iterator = setTypeMap.keySet().iterator();
		while (iterator.hasNext()) {
			List<Integer> list = (List<Integer>) iterator.next();
			System.out.println(list);
		}
		return null;
	}

	static List<Integer> getIndex(Map<List<Integer>, Integer> setTypeMap, int[] query) {
		if (setTypeMap.values().contains(query[2])) {
			Iterator<List<Integer>> iterator = setTypeMap.keySet().iterator();
			while (iterator.hasNext()) {
				List<Integer> list = (List<Integer>) iterator.next();
				if (list.contains(query[0]) && list.contains(query[1])) {
					return list;
				}
			}
		}
		return null;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		String[] nmq = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

//		int n = 7;// Integer.parseInt(nmq[0]);
//
//		int m = 6;// Integer.parseInt(nmq[1]);
//
//		int q = 1;// Integer.parseInt(nmq[2]);

		int[] t = { 1, 1, 4, 5, 1, 3, 2 };// new int[n];

//		String[] tItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//		for (int tItr = 0; tItr < n; tItr++) {
//			int tItem = Integer.parseInt(tItems[tItr]);
//			t[tItr] = tItem;
//		}

		int[][] roads = { { 1, 2, 3 }, { 2, 6, 2 }, { 2, 3, 4 }, { 3, 4, 3 }, { 2, 4, 9 }, { 5, 7, 9 } };// new
																											// int[m][3];

//		for (int roadsRowItr = 0; roadsRowItr < m; roadsRowItr++) {
//			String[] roadsRowItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//			for (int roadsColumnItr = 0; roadsColumnItr < 3; roadsColumnItr++) {
//				int roadsItem = Integer.parseInt(roadsRowItems[roadsColumnItr]);
//				roads[roadsRowItr][roadsColumnItr] = roadsItem;
//			}
//		}

		int[][] queries = { { 1, 2, 4 } };// new int[q][3];

//		for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
//			String[] queriesRowItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
//
//			for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
//				int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr]);
//				queries[queriesRowItr][queriesColumnItr] = queriesItem;
//			}
//		}

		int result = travel(t, roads, queries);

		System.out.println(result);

		scanner.close();
	}
}
