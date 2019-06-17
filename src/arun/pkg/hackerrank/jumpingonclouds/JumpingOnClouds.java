package arun.pkg.hackerrank.jumpingonclouds;

import java.io.IOException;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class JumpingOnClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int jumpsCount = 0;
		for (int i = 0; i < c.length - 1; i++) {
			if (i + 2 < c.length && 0 == c[i + 2]) {
				i++;
			}
			jumpsCount++;
		}
		return jumpsCount;
	}

	public static void main(String[] args) throws IOException {
		int[] c = { 0, 0, 1, 0, 0, 1, 0 };

		int result = jumpingOnClouds(c);

		System.out.println(result);
	}
}
