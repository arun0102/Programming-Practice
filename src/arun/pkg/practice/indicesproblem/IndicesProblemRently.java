package arun.pkg.practice.indicesproblem;

import java.util.Arrays;

public class IndicesProblemRently {
	public static void main(String[] args) {
		int[] arr = { 0, 3, 3, 7, 5, 3, 11, 1 };
		System.out.println(new IndicesProblemRently().solution(arr));
	}

	public int solution(int[] A) {
		int minDis = getMinDistance(A);
		if (100000000 == minDis) {
			return -1;
		} else if (Integer.MAX_VALUE == minDis) {
			return -2;
		} else {
			return minDis;
		}
	}

	private int getMinDistance(int[] arr) {
		int minDis = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int diff = Math.abs(arr[i] - arr[j]);
				if (1 < diff) {
					boolean isValid = true;
					if (arr[i] > arr[j]) {
						for (int k = arr[j] + 1; k < arr[i]; k++) {
							final int val = k;
							if (0 < Arrays.stream(arr).filter(x -> x == val).count()) {
								isValid = false;
							}
						}
					} else {
						for (int k = arr[i] + 1; k < arr[j]; k++) {
							final int val = k;
							if (0 < Arrays.stream(arr).filter(x -> x == val).count()) {
								isValid = false;
							}
						}
					}
					if (isValid) {
						if (minDis > diff) {
							minDis = diff;
						}
					}
				} else {
					if (minDis > diff) {
						minDis = diff;
					}
				}
			}
		}
		return minDis;
	}
}
