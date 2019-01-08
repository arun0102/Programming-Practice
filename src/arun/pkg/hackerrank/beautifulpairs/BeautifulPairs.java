package arun.pkg.hackerrank.beautifulpairs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
// https://www.hackerrank.com/challenges/beautiful-pairs/problem
public class BeautifulPairs {

	// Complete the beautifulPairs function below.
	static int beautifulPairs(int[] A, int[] B) {
		int N = A.length;

		Arrays.sort(A);
		Arrays.sort(B);

		int count = 0;
		int aindex = 0;
		int bindex = 0;
		while (aindex < N) {
			while (bindex < N && B[bindex] < A[aindex]) {
				bindex++;
			}
			if (bindex == N)
				break;
			if (A[aindex] == B[bindex]) {
				count++;
				bindex++;
			}
			aindex++;
		}

		if (count < N) {
			count++;
		} else {
			count--;
		}

		return count;
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
