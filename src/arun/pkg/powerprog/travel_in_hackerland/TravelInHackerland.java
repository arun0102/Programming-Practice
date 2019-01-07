package arun.pkg.powerprog.travel_in_hackerland;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TravelInHackerland {

	/*
	 * Complete the travel function below.
	 */
	static int travel(int[] t, int[][] roads, int[][] queries) {
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

		List<Integer> cityArr = new ArrayList<>();
		List<Integer> crowdArr = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			int startCity = queries[i][0];
			int endCity = queries[i][1];
			int types = queries[i][2];
			cityArr.add(startCity);
			int currentCity = startCity;
			int typeCount = 1;
			while (currentCity != endCity && typeCount != types) {
				List<int[]> valArr = map.get(currentCity);
				int minCrowd = Integer.MAX_VALUE;
				int minCity = 0;
				for (int j = 0; j < valArr.size(); j++) {
					if (valArr.get(j)[1] < minCrowd) {
						minCrowd = valArr.get(j)[1];
						minCity = valArr.get(j)[0];
					}
				}
				// check if next city is in the city array,
				// if yes, then check for the less crowded route and add cities in the array
				// again
				// if no, then check for the shortest route to next city type
				if (cityArr.contains(minCity)) {
					List<Integer> subArr = cityArr.subList(cityArr.lastIndexOf(minCity), cityArr.size());
					int sum = subArr.stream().reduce(Integer::sum).get();
					if (sum > minCrowd) {
						cityArr.add(minCity);
						crowdArr.add(minCrowd);
					} else {
						cityArr.addAll(subArr);
					}
					currentCity = minCity;
				} else {
					// find the next type of city with min crowd
					cityArr.add(minCity);
					crowdArr.add(minCrowd);
					currentCity = minCity;
				}
//					}
//				}
			}
		}
		System.out.println(cityArr);
		return crowdArr.stream().max(Comparator.naturalOrder()).get();
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
