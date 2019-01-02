package arun.pkg.reformedstring;

public class ReformedString {
	public static void main(String[] args) throws java.lang.Exception {
		System.out.println("Converted - " + getReformedString("Python Is Truly Interesting Programming Language"));
		System.out.println("Result    - " + "yhnotP Xs rlyuT Xntxrxstxng rgamngimroP Lxngxxgx");
	}

	private static String getReformedString(String str) {
		String[] wordsArr = str.split(" ");
		for (int i = 0; i < wordsArr.length; i++) {
			if (i % 2 == 0) {
				// odd positioned words as the position starts from 1
				wordsArr[i] = getOddWordReformed(wordsArr[i]);
			} else {
				// even positioned words
				wordsArr[i] = getEvenWordReformed(wordsArr[i]);
			}
		}
		return getFormattedWords(wordsArr);
	}

	private static String getEvenWordReformed(String word) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		char[] vowelsUpper = { 'A', 'E', 'I', 'O', 'U' };
		char[] charArr = word.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (charArr[i] == vowels[j]) {
					charArr[i] = 'x';
				} else if (charArr[i] == vowelsUpper[j]) {
					charArr[i] = 'X';
				}
			}
		}
		return new String(charArr);
	}

	// Python -> yhnotP
	private static String getOddWordReformed(String word) {
		String oddWords = "";
		String evenWords = "";
		char[] charArr = word.toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if (i % 2 == 0) {
				// odd positioned character as the position starts from 1
				oddWords = charArr[i] + oddWords;
			} else {
				// even positioned character
				evenWords += charArr[i];
			}
		}
		return evenWords + oddWords;
	}

	private static String getFormattedWords(String[] wordsArr) {
		String para = "";
		for (int i = 0; i < wordsArr.length; i++) {
			if (i == wordsArr.length - 1) {
				para += wordsArr[i];
			} else {
				para += wordsArr[i] + " ";
			}
		}
		return para;
	}
}
