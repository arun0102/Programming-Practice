package arun.pkg.stringlength;

import java.util.ArrayList;

public class StringLength {
	public static void main(String[] args) {
		String str = "123456789";
		// System.out.println(findLengthRec(str));
		// 0 1 1 2 3 5 8 13
		test(12, 6);
	}

	static void test(int m, int n) {
		while (m != n) {
			if (m > n)
				m = m - n;
			else
				n = n - m;
		}
		System.out.println(n);
	}

	private static int findLengthRec(String str) {
		if (str.equals("")) {
			return 0;
		}
		return 1 + findLengthRec(str.substring(1));
	}
}
