package arun.pkg.hackerrank.hangingposters;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// https://www.hackerrank.com/contests/hourrank-31/challenges/hanging-posters
class Result {

	/*
	 * Complete the 'solve' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER h 2. INTEGER_ARRAY wallPoints 3. INTEGER_ARRAY lengths
	 */

	public static int solve(int h, List<Integer> wallPoints, List<Integer> lengths) {
		int maxH = 0;
		for (int i = 0; i < lengths.size(); i++) {
			double height = Math.ceil((double) wallPoints.get(i) - ((double) lengths.get(i) * 0.25));
			if (maxH < height) {
				maxH = (int) height;
			}
		}
		return maxH <= h ? 0 : maxH - h;
	}
}

public class HangingPosters {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int h = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> wallPoints = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> lengths = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int answer = Result.solve(h, wallPoints, lengths);

		System.out.println(answer);
		bufferedReader.close();
	}
}
