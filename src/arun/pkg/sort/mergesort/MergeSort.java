package arun.pkg.sort.mergesort;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 9, 1, 4, 7, 2, 8, 3, 6, 5 }; // 9 elements
		System.out.println(Arrays.toString(sort(arr)));
	}

	static int[] sort(int[] arr) {
		return divide(arr);
	}

	static int[] divide(int[] arr) {
		if (arr.length < 2) {
			return arr;
		} else {
			int mid = (int) Math.floor(arr.length / 2);
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];
			for (int i = 0; i < arr.length; i++) {
				if (i < mid) {
					left[i] = arr[i];
				} else {
					right[i - mid] = arr[i];
				}
			}

			int[] leftArr = divide(left);
			int[] rightArr = divide(right);

			return merge(leftArr, rightArr);
		}
	}

	static int[] merge(int[] leftArr, int[] rightArr) {
		int[] merged = new int[leftArr.length + rightArr.length];
		int i = 0, j = 0, k = 0;
		while (i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] > rightArr[j]) {
				merged[k++] = rightArr[j++];
			} else {
				merged[k++] = leftArr[i++];
			}
		}

		while (i < leftArr.length) {
			merged[k++] = leftArr[i++];
		}

		while (j < rightArr.length) {
			merged[k++] = rightArr[j++];
		}

		return merged;
	}
}
