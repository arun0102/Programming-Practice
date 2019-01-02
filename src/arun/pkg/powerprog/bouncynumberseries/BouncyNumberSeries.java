package arun.pkg.powerprog.bouncynumberseries;

public class BouncyNumberSeries {
	public static void main(String[] args) {
		int num = 14752;
		System.out.println(isBouncyNumber(num));
		int count = 0;
		for (int i = 0; i <= num; i++) {
			if (isBouncyNumber(i)) {
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isBouncyNumber(int num) {
		String numStr = String.valueOf(num);
		if (numStr.length() < 3 || numStr.length() % 2 == 0) {
			return false;
		}
		int midPos = numStr.length() / 2;
		char midChar = numStr.charAt(midPos);
		boolean isDecr = false;
		if (midChar - numStr.charAt(midPos - 1) > 0) {
			isDecr = true;
		}
		char lastChar = midChar;
		for (int i = midPos - 1; i >= 0; i--) {
			if (isDecr) {
				if (lastChar - numStr.charAt(i) <= 0) {
					return false;
				}
			} else {
				if (lastChar - numStr.charAt(i) >= 0) {
					return false;
				}
			}
			lastChar = numStr.charAt(i);
		}

		lastChar = midChar;
		for (int i = midPos + 1; i < numStr.length(); i++) {
			if (isDecr) {
				if (lastChar - numStr.charAt(i) <= 0) {
					return false;
				}
			} else {
				if (lastChar - numStr.charAt(i) >= 0) {
					return false;
				}
			}
			lastChar = numStr.charAt(i);
		}
		return true;
	}
}
