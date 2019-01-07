package arun.pkg.sockmerchantproblem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SockMerchantProblem {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (array.contains(ar[i])) {
				array.remove(array.indexOf(ar[i]));
			} else {
				array.add(ar[i]);
			}
		}
		return array.size();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int[] ar = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };

		int result = sockMerchant(ar.length, ar);

		System.out.println(result);
	}
}
