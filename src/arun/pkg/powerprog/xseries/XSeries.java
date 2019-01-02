package arun.pkg.powerprog.xseries;

import java.util.ArrayList;
import java.util.Arrays;

public class XSeries {
	static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = { 11, 5, 19, 2, 8, 3, 4, 30 };
		Arrays.sort(nums);

		findPairs(nums.length - 1, nums.length - 2, nums);
		System.out.println("--------");

		findCommonAndMerge(0);

		// arr.stream().forEach(x -> System.out.println(x));

		if (0 == arr.size()) {
			System.out.println(-1);
		} else {
			int maxPos = 0;
			String maxVal = "";
			for (int i = 0; i < arr.size(); i++) {
				if (maxPos < arr.get(i).split(",").length) {
					maxPos = arr.get(i).split(",").length;
					maxVal = arr.get(i);
				}
			}
			System.out.println(maxVal);
		}
	}

	static void findPairs(int pos, int pivot, int[] nums) {
		if (pivot == 0) {
			pos = pos - 1;
			pivot = pos - 1;
		}
		if (pos == 1) {
			return;
		}
		for (int i = pivot - 1; i >= 0; i--) {
			if (nums[pos] == nums[pivot] + nums[i]) {
				// System.out.println(nums[i] + ", " + nums[pivot] + ", " + nums[pos]);
				arr.add(nums[i] + "," + nums[pivot] + "," + nums[pos]);
				break;
			}
		}
		findPairs(pos, pivot - 1, nums);
	}

	static void findCommonAndMerge(int pos) {
		if (pos == arr.size()) {
			return;
		}
		boolean isFound = false;

		for (int i = pos + 1; i < arr.size(); i++) {
			String[] posVal = arr.get(pos).split(",");
			int posCount = posVal.length;
			for (int j = 2; j < posCount; j++) {
				String sub = "";
				for (int k = 0; k < j; k++) {
					if (k == j - 1) {
						sub += posVal[k];
					} else {
						sub += posVal[k] + ",";
					}
				}

				if (arr.get(i).contains(sub)) {
					String add = arr.get(i)
							+ arr.get(pos).substring(sub.length(), arr.get(pos).length());
					System.out.println(add);
				}
			}

//			if (arr.get(i).contains(arr.get(pos).substring(0, arr.get(pos).lastIndexOf(',')))) {
//				String add = arr.get(i) + arr.get(pos).substring(arr.get(pos).lastIndexOf(','), arr.get(pos).length());
//				// System.out.println(add);
//				arr.add(0, add);
//				isFound = true;
//				break;
//			}
		}

		if (isFound) {
			findCommonAndMerge(pos + 2);
		} else {
			findCommonAndMerge(pos + 1);
		}
	}
}
