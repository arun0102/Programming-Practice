package arun.pkg.hackerrank.counting_valleys;

import java.io.IOException;
import java.util.Scanner;
// https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {

	// Complete the countingValleys function below.
	static int countingValleys(int n, String s) {
		int count = 0;
		int base = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'U') {
				base++;
				if (base == 0) {
					count++;
				}
			} else {
				base--;
			}

		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 8;
		String s = "UDDDUDUU";

		int result = countingValleys(n, s);

		System.out.println(result);
	}
}
