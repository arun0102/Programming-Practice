package arun.pkg.practice.longestcommonsequence;

/**
 * Longest common subsequence
 * 
 * @author arunkumar
 */
public class LCSRecursive {
	static char[] A = { 'a', 'b', 'c', 'b', 'd', 'a', 'b' };
	static char[] B = { 'b', 'd', 'c', 'a', 'b', 'a' };

	public static void main(String[] args) {
		String lcs = "";
		int count = sequence(0, 0, lcs);
		System.out.println(count);
	}

	static int sequence(int i, int j, String lcs) {
		if (i == A.length || j == B.length) {
			return 0;
		} else if (A[i] == B[j]) {
			if (1 != (lcs + String.valueOf(A[i])).length()) {
				System.out.println(lcs + A[i]);
			}
			return 1 + sequence(i + 1, j + 1, lcs + A[i]);
		} else {
			return max(sequence(i + 1, j, lcs), sequence(i, j + 1, lcs));
		}
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}
}
