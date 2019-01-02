package arun.pkg.hackerrank.beautifulpairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulPairs {

	// Complete the beautifulPairs function below.
	static int beautifulPairs(int[] A, int[] B) {
		return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] A = { 1, 2, 3, 4 };// new int[n];

//        String[] AItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int AItem = Integer.parseInt(AItems[i]);
//            A[i] = AItem;
//        }

		int[] B = { 1, 2, 3, 3 };// new int[n];

//        String[] BItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int BItem = Integer.parseInt(BItems[i]);
//            B[i] = BItem;
//        }

		int result = beautifulPairs(A, B);

		System.out.println(result);

		scanner.close();
	}
}
