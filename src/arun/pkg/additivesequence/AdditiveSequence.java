package arun.pkg.additivesequence;

public class AdditiveSequence {
	public static void main(String[] args) {
		String str = "235813";
		checkAdditiveSequence(str, 0);
	}

	private static void checkAdditiveSequence(String str, int startPos) {
		for (int i = startPos; i < str.length()/2; i++) {
			String firstNum = str.substring(startPos, i+1);
			for (int j = startPos + firstNum.length(); j < (str.length() - firstNum.length())/2; j++) {
				String secondNum = str.substring(j, j+1);
				// int first = firstNum - '0';
			}
		}
	}
}
