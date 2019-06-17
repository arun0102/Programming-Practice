package arun.pkg.hackerrank.biggerisgreater;

import java.io.IOException;

// https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsGreater {

	// helping logic for finding the next lexicographical permutation or next word
	// in the dictionary
	// https://stackoverflow.com/a/54986557/4689184

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {
		String res = "no answer";
		// find longest non-increasing suffix
		int pivot = -1;
		for (int i = w.length() - 1; i > 0; i--) {
			if (w.charAt(i - 1) < w.charAt(i)) {
				pivot = i - 1;
				break;
			}
		}
		if (pivot == -1) {
			return res;
		}
		System.out.println(pivot);

		// find rightmost successor value than pivot
		int succ = 0;
		for (int i = w.length() - 1; i > pivot; i--) {
			if (w.charAt(pivot) < w.charAt(i)) {
				succ = i;
				break;
			}
		}

		// swap pivot with successor
		String newStr = w.substring(0, pivot) + w.charAt(succ) + w.substring(pivot + 1, succ) + w.charAt(pivot)
				+ w.substring(succ + 1, w.length());

		// reverse the complete suffix
		res = newStr.substring(0, pivot + 1);
		for (int i = newStr.length() - 1; i > pivot; i--) {
			res += newStr.charAt(i);
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		String w = "ab";

		String result = biggerIsGreater(w);

		System.out.println(result);
	}
}
