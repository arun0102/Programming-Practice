package arun.pkg.powerprog.ballbounce;

import java.util.Scanner;

public class BallBounceProblem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float h1 = 75.0f;// scan.nextFloat();
		float h2 = 58.0f;// scan.nextFloat();

		float f = 1.2f;// scan.nextFloat();

		System.out.println(getDropCounts(h1, h2, f) - 1);
		System.out.println(getDropCount(h1, h2, f));
	}

	private static int getDropCounts(float h1, float h2, float f) {
		if (h1 < h2) {
			return 0;
		}
		return 1 + getDropCounts(h1 / f, h2, f);
	}

	private static int getDropCount(float h1, float h2, float f) {
		return (int) (Math.log((float) h1 / h2) / Math.log(f));
	}
}
