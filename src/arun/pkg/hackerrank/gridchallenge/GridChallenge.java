package arun.pkg.hackerrank.gridchallenge;

import java.io.IOException;
import java.util.Arrays;

public class GridChallenge {

	// Complete the gridChallenge function below.
	static String gridChallenge(String[] grid) {
		int gridSize = grid.length;
		int wordLength = grid[0].length();

		for (int i = 0; i < gridSize; i++) {
			char[] line = grid[i].toCharArray();
			Arrays.sort(line);
			grid[i] = new String(line);
		}
		boolean isOrdered = true;
		for (int j = 0; j < wordLength; j++) {
			char lastChar = '\0';
			for (int i = 0; i < gridSize; i++) {
				if (lastChar == '\0') {
					lastChar = grid[i].charAt(j);
				} else if (grid[i].charAt(j) - lastChar < 0) {
					isOrdered = false;
					break;
				}
			}
			if (!isOrdered) {
				break;
			}
		}
		if (isOrdered) {
			return "YES";
		}
		return "NO";
	}

	// private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int t = 1;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = 5; // scanner.nextInt();
			// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			String[] grid = new String[n];
			grid[0] = "ebacd";
			grid[1] = "fghij";
			grid[2] = "olmkn";
			grid[3] = "trpqs";
			grid[4] = "xywuv";
//			for (int i = 0; i < n; i++) {
//				String gridItem = scanner.nextLine();
//				grid[i] = gridItem;
//			}

			String result = gridChallenge(grid);

			System.out.println(result);
		}

//		bufferedWriter.close();

		// scanner.close();
	}
}
