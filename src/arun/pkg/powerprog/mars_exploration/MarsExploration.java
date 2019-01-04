package arun.pkg.powerprog.mars_exploration;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/mars-exploration/problem
public class MarsExploration {

	// Complete the marsExploration function below.
	static int marsExploration(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (((i % 3 == 0 || i % 3 == 2) && s.charAt(i) != 'S') || (i % 3 == 1 && s.charAt(i) != 'O')) {
				count++;
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String s = scanner.nextLine();

		int result = marsExploration(s);

		System.out.println(result);
		scanner.close();
	}
}
