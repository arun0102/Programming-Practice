package arun.pkg.hackerrank.repeatedstring;

import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {
		long count = s.chars().filter(x -> x == 'a').count();
		if (count == s.length()) {
			return n;
		} else {
			long mul =  (n / s.length());
			int left = (int)(n % s.length());
			return count * mul + s.substring(0, left).chars().filter(x -> x == 'a').count();
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// String s = scanner.nextLine();
		String s = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";

		long n = 736778906400L;// scanner.nextLong();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long result = repeatedString(s, n);

		System.out.println(result);
		// scanner.close();
	}
}
