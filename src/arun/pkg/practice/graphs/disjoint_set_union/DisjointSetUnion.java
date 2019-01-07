package arun.pkg.practice.graphs.disjoint_set_union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DisjointSetUnion {
	public static void main(String[] args) {
//		int[][] arr = { { 1, 2, 1 }, { 1, 3, 7 }, { 3, 4, 2 }, { 4, 2, 5 }, { 2, 5, 6 }, { 5, 6, 3 }, { 6, 8, 8 },
//				{ 8, 7, 4 }, { 5, 7, 9 } };
		int[][] arr = { { 1, 2, 3 }, { 2, 6, 2 }, { 2, 3, 4 }, { 3, 4, 3 }, { 2, 4, 9 }, { 5, 7, 9 } };

		findMST(arr);
	}

	static void findMST(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		List<List<Integer>> setArr = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int[] set = arr[i];
			if (0 == setArr.size()) {
				List<Integer> list = new ArrayList<>();
				list.add(set[0]);
				list.add(set[1]);
				setArr.add(list);
			} else {
				int childIndex = -1;
				int parentIndex = -1;
				for (int j = 0; j < setArr.size(); j++) {
					if (setArr.get(j).contains(set[0])) {
						childIndex = j;
					}
					if (setArr.get(j).contains(set[1])) {
						parentIndex = j;
					}
				}
				if (childIndex == -1 && parentIndex == -1) {
					List<Integer> list = new ArrayList<>();
					list.add(set[0]);
					list.add(set[1]);
					setArr.add(list);
				} else if (childIndex == -1 || parentIndex == -1) {
					if (childIndex == -1) {
						setArr.get(parentIndex).add(set[0]);
					}
					if (parentIndex == -1) {
						setArr.get(childIndex).add(set[1]);
					}
				} else if (childIndex != parentIndex) {
					if (setArr.get(childIndex).size() > setArr.get(parentIndex).size()) {
						setArr.get(childIndex).addAll(setArr.get(parentIndex));
						setArr.remove(parentIndex);
					} else {
						setArr.get(parentIndex).addAll(setArr.get(childIndex));
						setArr.remove(childIndex);
					}
				}
			}
		}

		for (int i = 0; i < setArr.size(); i++) {
			System.out.println(setArr.get(i));
		}
	}
}
