package arun.pkg.hackerrank.gridsearch;

import java.io.IOException;
import java.util.Scanner;

public class GridSearch {

	// Complete the gridSearch function below.
	static String gridSearch(String[] G, String[] P) {
		String res = "NO";
		for (int i = 0; i < G.length; i++) {
			for (int index = G[i].indexOf(P[0]); index >= 0; index = G[i].indexOf(P[0], index + 1)) {
				res = "YES";
				for (int j = i + 1, k = 1; j < G.length && k < P.length; j++, k++) {
					if (!G[j].substring(index, index + P[k].length()).equals(P[k])) {
						res = "NO";
						break;
					}
				}
				if (res.equals("YES")) {
					return res;
				}
			}
		}
		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] RC = scanner.nextLine().split(" ");

			int R = Integer.parseInt(RC[0]);

			int C = Integer.parseInt(RC[1]);

			String[] G = new String[R];

			for (int i = 0; i < R; i++) {
				String GItem = scanner.nextLine();
				G[i] = GItem;
			}

			String[] rc = scanner.nextLine().split(" ");

			int r = Integer.parseInt(rc[0]);

			int c = Integer.parseInt(rc[1]);

			String[] P = new String[r];

			for (int i = 0; i < r; i++) {
				String PItem = scanner.nextLine();
				P[i] = PItem;
			}

			String result = gridSearch(G, P);

			System.out.println(result);
		}
		scanner.close();
	}
}
/**
 * Test case 2 10 10 7283455864 6731158619 8988242643 3830589324 2229505813
 * 5633845374 6473530293 7053106601 0834282956 4607924137 3 4 9505 3845 3530 15
 * 15 400453592126560 114213133098692 474386082879648 522356951189169
 * 887109450487496 252802633388782 502771484966748 075975207693780
 * 511799789562806 404007454272504 549043809916080 962410809534811
 * 445893523733475 768705303214174 650629270887160 2 2 99 99
 * 
 **/
