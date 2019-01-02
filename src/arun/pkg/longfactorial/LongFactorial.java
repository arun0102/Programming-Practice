package arun.pkg.longfactorial;

import java.math.BigInteger;
import java.util.Scanner;

public class LongFactorial {

	// Complete the extraLongFactorials function below.
	static void extraLongFactorials(int n) {
		BigInteger big = BigInteger.valueOf(n);
		while (n > 1) {
			big = big.multiply(BigInteger.valueOf(--n));
		}
		System.out.print(big);
	}

	public static void main(String[] args) {

		extraLongFactorials(25);
	}
}
