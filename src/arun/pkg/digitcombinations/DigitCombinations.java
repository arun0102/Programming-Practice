package arun.pkg.digitcombinations;

import java.util.Arrays;

public class DigitCombinations {
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		int r = 3;
		getCount(num, r);
	}

	private static void getCount(int[] num, int r) {
		getCombinations(num, r, 0);
	}
	
	static void getCombinations(int[] num, int r, int start) {
		
		if(start == num.length - r + 1) {
			return;
		}
		for (int i = start; i < num.length - r + 1; i++) {
			int[] data = {num[start], num[i+1], num[i+2]};
			System.out.println(Arrays.toString(data));
		}
		getCombinations(num, r, ++start);
	}
}
