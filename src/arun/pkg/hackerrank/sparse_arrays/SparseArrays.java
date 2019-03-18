package arun.pkg.hackerrank.sparse_arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sparse-arrays/problem
public class SparseArrays {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] countArr = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			final int pos = i;
			countArr[i] = (int) Arrays.asList(strings).stream().filter(x -> x.equals(queries[pos])).count();
		}

		return countArr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);

		for (int i = 0; i < res.length; i++) {
			System.out.println(String.valueOf(res[i]));
		}

		scanner.close();
	}
}

// Test data

//13
//abcde
//sdaklfj
//asdjf
//na
//basdn
//sdaklfj
//asdjf
//na
//asdjf
//na
//basdn
//sdaklfj
//asdjf
//5
//abcde
//sdaklfj
//asdjf
//na
//basdn
