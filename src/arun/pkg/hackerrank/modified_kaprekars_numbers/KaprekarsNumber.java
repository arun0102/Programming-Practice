package arun.pkg.hackerrank.modified_kaprekars_numbers;

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class KaprekarsNumber {

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		boolean isFound = false;
		for (int i = p; i <= q; i++) {
			if (isKaprekarNumber(i)) {
				isFound = true;
				System.out.print(i);
				System.out.print(" ");
			}
		}
		if (!isFound) {
			System.out.println("INVALID RANGE");
		}
	}

	static boolean isKaprekarNumber(long num) {
		String sqNum = String.valueOf(num * num);
		int numLen = String.valueOf(num).length();
		String r = sqNum.substring(sqNum.length() - numLen, sqNum.length());
		String l = "0";
		if (r.length() < sqNum.length()) {
			l = sqNum.substring(0, sqNum.length() - numLen);
		}

		if (Integer.parseInt(l) + Integer.parseInt(r) == num) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int p = 1;

		int q = 65536;

		kaprekarNumbers(p, q);
	}
}
