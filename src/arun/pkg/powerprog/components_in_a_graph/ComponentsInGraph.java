package arun.pkg.powerprog.components_in_a_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/contests/cs-dsa-01/challenges/components-in-graph

public class ComponentsInGraph {

	static int[] componentsInGraph(int[][] gb) {
		Map<Integer, List<Integer>> vertMap = new HashMap<>();
		for (int i = 1; i <= gb.length * 2; i++) {
			List<Integer> valArr = new ArrayList<>();
			valArr.add(i);
			vertMap.put(i, valArr);
		}
		for (int i = 0; i < gb.length; i++) {
			List<Integer> arr1 = vertMap.get(gb[i][0]);
			List<Integer> arr2 = vertMap.get(gb[i][1]);
			if (arr1 != arr2) {
				arr1.addAll(arr2);
				arr2.forEach(x -> vertMap.put(x, arr1));
			}
		}

		int[] res = new int[2];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Iterator<List<Integer>> iter = vertMap.values().iterator();
		while (iter.hasNext()) {
			int size = iter.next().size();
			if (size > 1) {
				if (size > max) {
					max = size;
				}
				if (size < min) {
					min = size;
				}
			}
		}
		res[0] = min;
		res[1] = max;
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 5;// Integer.parseInt(scanner.nextLine().trim());

		int[][] gb = { { 1, 6 }, { 2, 7 }, { 3, 8 }, { 4, 9 }, { 2, 6 } };

		int[] result = componentsInGraph(gb);

		System.out.println(Arrays.toString(result));
	}

	static class Graph {
		HashMap<Integer, ArrayList<Integer>> nodes;

		Graph(int n) {
			nodes = new HashMap<>();
			for (int i = 1; i <= 2 * n; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				nodes.put(i, list);
			}
		}

		void set_edge(int n1, int n2) {
			ArrayList<Integer> list1 = nodes.get(n1);
			ArrayList<Integer> list2 = nodes.get(n2);
			if (list1 != list2) {
				list1.addAll(list2);
				list2.forEach(i -> nodes.put(i, list1));
			}
		}

		void print_answer() {
			ArrayList<Integer> vertices = new ArrayList<Integer>();

			for (ArrayList<Integer> list : nodes.values()) {
				if (list.size() > 1)
					vertices.add(list.size());
				list.clear();
			}
			System.out.print(Collections.min(vertices) + " ");
			System.out.println(Collections.max(vertices));
		}
	}

//	public static void main(String[] args) {
//		int[][] gb = { { 1, 6 }, { 2, 7 }, { 3, 8 }, { 4, 9 }, { 2, 6 } };
//
//		int N = 5;// in.nextInt();
//		Graph G = new Graph(N);
//		for (int i = 0; i < N; i++) {
//			int n1 = gb[i][0];
//			int n2 = gb[i][2];
//			G.set_edge(n1, n2);
//		}
//
//		G.print_answer();
//	}

	/*
	 * Complete the componentsInGraph function below.
	 */
	static int[] componentsInGraphOld(int[][] gb) {
		List<String> arr = new ArrayList<>();
		for (int i = 0; i < gb.length; i++) {
			String zero = String.valueOf(gb[i][0]);
			String one = String.valueOf(gb[i][1]);
			boolean isFound = false;
			for (int j = 0; j < arr.size(); j++) {
				if (arr.get(j).contains(zero)) {
					isFound = true;
					arr.set(j, arr.get(j) + one);
				} else if (arr.get(j).contains(one)) {
					isFound = true;
					arr.set(j, arr.get(j) + zero);
				}
			}
			if (!isFound) {
				arr.add(zero + one);
			}
		}
		boolean isChanged = false;
		while (!isChanged) {
			isChanged = false;
			for (int i = 0; i < arr.size(); i++) {
				for (int j = i + 1; j < arr.size(); j++) {
					char[] base = arr.get(i).toCharArray();
					for (int k = 0; k < base.length; k++) {
						if (arr.get(j).contains(String.valueOf(base[k]))) {
							isChanged = true;
							String a = arr.get(i);
							String b = arr.get(j);

							arr.remove(a);
							arr.remove(b);
							arr.add(getCommonKeys(a, b));
							break;
						}
					}
					if (isChanged) {
						break;
					}
				}
				if (isChanged) {
					break;
				}
			}
			break;
		}
		int[] res = new int[2];
		res[0] = Integer.MAX_VALUE;
		res[1] = Integer.MIN_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).length() > res[1]) {
				res[1] = arr.get(i).length();
			} else if (arr.get(i).length() < res[0]) {
				res[0] = arr.get(i).length();
			}
		}
		return res;
	}

	static String getCommonKeys(String a, String b) {
		String res = a;
		for (int i = 0; i < b.length(); i++) {
			if (!res.contains(String.valueOf(b.charAt(i)))) {
				res += String.valueOf(b.charAt(i));
			}
		}
		return res;
	}
}
