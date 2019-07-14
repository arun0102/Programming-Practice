package arun.pkg.crackingthecodinginterview.pg47_searchPermutations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Given a smaller string and bigger string. Design an algorithm to find all permutations of the shorter string
// within the longer one. print the location of each permutation.
public class SearchPermutations {
	public static void main(String[] args) {
		String s = "abbc";
		String b = "cbabadcbbabbcbabaabccbabc";

		Map<Character, Integer> countMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (countMap.containsKey(s.charAt(i))) {
				countMap.put(s.charAt(i), countMap.get(s.charAt(i)) + 1);
			} else {
				countMap.put(s.charAt(i), 1);
			}
		}
		int start = 0;
		int end = s.length();
		while (end <= b.length()) {
			String subB = b.substring(start, end);
			Iterator<Character> iter = countMap.keySet().iterator();
			boolean isMatching = true;
			while (iter.hasNext()) {
				char c = iter.next();
				int count = countMap.get(c);
				if (count != subB.chars().filter(x -> x == c).count()) {
					isMatching = false;
				}
			}
			if (isMatching) {
				System.out.println(start + " to " + (end - 1));
			}
			start++;
			end++;
		}
	}
}
