package arun.pkg.hackerrank.organising_containers_of_balls;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
public class OrganisingContainersOfBalls {

	// Complete the organizingContainers function below.
	static String organizingContainers(int[][] container) {
		int[] sizeArr = new int[container.length];
		int[] ballsArr = new int[container.length];

		for (int i = 0; i < container.length; i++) {
			for (int j = 0; j < container[i].length; j++) {
				ballsArr[j] += container[i][j];
				sizeArr[i] += container[i][j];
			}
		}
		Arrays.sort(ballsArr);
		Arrays.sort(sizeArr);
		for (int i = 0; i < ballsArr.length; i++) {
			if (ballsArr[i] != sizeArr[i]) {
				return "Impossible";
			}
		}
		return "Possible";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		int q = 1;//scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//		for (int qItr = 0; qItr < q; qItr++) {
		int n = 3;// scanner.nextInt();
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] container = { { 1, 3, 1 }, { 2, 1, 2 }, { 3, 3, 3 } };// new int[n][n];

		String result = organizingContainers(container);

		System.out.println(result);
	}
}
