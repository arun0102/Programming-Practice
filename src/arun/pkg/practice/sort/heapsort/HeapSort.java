package arun.pkg.practice.sort.heapsort;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 6, 7, 23, 52, 2, 7, 9 };

		new HeapSort().sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void sort(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// heap sort
		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// heapify root elements
			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		// find the largest among root, left and right
		int largest = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;

		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// swap and continue heapify if root is not largest
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}
}
