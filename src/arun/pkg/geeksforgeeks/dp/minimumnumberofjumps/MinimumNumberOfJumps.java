package arun.pkg.geeksforgeeks.dp.minimumnumberofjumps;

import java.util.Scanner;

public class MinimumNumberOfJumps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int count = sc.nextInt();

			int[] arr = new int[count];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println(jumps(arr, 0));
		}
		sc.close();
	}

	private static int jumps(int[] arr, int pos) {
//		if (pos == arr.length - 1) {
//			return 1;
//		} else if (pos > arr.length - 1) {
//			return -1;
//		} else {
//			
//		}
		return 0;
	}
}
