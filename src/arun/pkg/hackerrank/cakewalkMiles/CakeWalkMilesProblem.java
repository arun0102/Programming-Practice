package arun.pkg.hackerrank.cakewalkMiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// https://www.hackerrank.com/challenges/marcs-cakewalk/problem
public class CakeWalkMilesProblem {

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 3;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		// int[] calorie = new int[n];

		List<Integer> cal = new ArrayList<>();
		String[] calorieItems = "1 3 2".split(" ");// scanner.nextLine().split(" ");
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int calorieItem = Integer.parseInt(calorieItems[i]);
			cal.add(calorieItem);
		}

		List<Integer> sortedDist = cal.stream().sorted().collect(Collectors.toList());
		long result = marcsCakewalk(sortedDist);

		System.out.println(result);

		// scanner.close();
	}

	// Complete the marcsCakewalk function below.
	static long marcsCakewalk(List<Integer> calorie) {
		long miles = 0;
		int power = 0;
		for (int i = calorie.size() - 1; i >= 0; i--) {
			miles += Math.pow(2, power) * calorie.get(i);
			power++;
		}
		System.out.println(miles);
		return miles;
	}
}
