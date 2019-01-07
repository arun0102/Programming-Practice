package arun.pkg.longestcommonsequence;

/**
 *  Longest common subsequence
 * @author arunkumar
 */
public class LCSRecursive {
	static char[] A = { 'b', 'd' };
	static char[] B = { 'a', 'b', 'c', 'd' };

	public static void main(String[] args) {
		int count = sequence(0, 0);
		System.out.println(count);
	}

	static int sequence(int i, int j) {
		if (i == A.length || j == B.length) {
			return 0;
		} else if (A[i] == B[j]) {
			return 1 + sequence(i + 1, j + 1);
		} else {
			return max(sequence(i + 1, j), sequence(i, j + 1));
		}
	}

	static int max(int x, int y) {
		return x > y ? x : y;
	}
}
