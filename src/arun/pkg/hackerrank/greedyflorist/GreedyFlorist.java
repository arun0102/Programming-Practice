package arun.pkg.hackerrank.greedyflorist;

import java.io.IOException;
import java.util.Arrays;

public class GreedyFlorist {

	// Complete the getMinimumCost function below.
	static int getMinimumCost(int k, int[] c) {
		int cost = 0;
		Arrays.sort(c);
		int multiplier = 0;
		int count = k;
		for (int i = c.length - 1; i >= 0; i--) {
			cost += (multiplier + 1) * c[i];
			count--;
			if (0 == count) {
				multiplier++;
				count = k;
			}
		}
		return cost;
	}

//    private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		// String[] nk = scanner.nextLine().split(" ");

		int n = 5; // Integer.parseInt(nk[0]);

		int k = 3; // Integer.parseInt(nk[1]);

		int[] c = new int[n];

		String[] cItems = { "1", "3", "5", "7", "9" }; // scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int minimumCost = getMinimumCost(k, c);
		System.out.println(minimumCost);

//        bufferedWriter.write(String.valueOf(minimumCost));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
	}
}
