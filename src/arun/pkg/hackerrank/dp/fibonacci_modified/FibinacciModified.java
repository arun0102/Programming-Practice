package arun.pkg.hackerrank.dp.fibonacci_modified;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class FibinacciModified {

	// Complete the fibonacciModified function below.
	static String fibonacciModified(int t1, int t2, int n) {
		if (1 == n) {
			return String.valueOf(t1);
		} else if (2 == n) {
			return String.valueOf(t2);
		}
		String val = "";
		String one = String.valueOf(t1);
		String two = String.valueOf(t2);
		for (int i = 3; i <= n; i++) {
			val = sum(one, square(two));
			one = two;
			two = val;
			System.out.println(i + " - " + val);
		}
		return val;
	}

	static String sum(String one, String two) {
		int len = one.length() > two.length() ? one.length() : two.length();
		int extra = 0;
		String val = "";
		for (int i = 0; i < len; i++) {
			int sum = extra;

			if (i >= one.length()) {
				sum += two.charAt(two.length() - i - 1) - '0';
			} else if (i >= two.length()) {
				sum += one.charAt(one.length() - i - 1) - '0';
			} else {
				sum += (one.charAt(one.length() - i - 1) - '0') + (two.charAt(two.length() - i - 1) - '0');
			}

			if (i == len - 1) {
				val = sum + val;
			} else {
				val = (sum % 10 == 0 ? "0" : sum % 10) + val;
				extra = sum / 10;
			}
		}
		return val;
	}

	static String square(String num) {
		char[] numOneArr = num.toCharArray();
		char[] numTwoArr = numOneArr;
		String[] arr = new String[numTwoArr.length];
		Arrays.fill(arr, "");
		for (int i = numTwoArr.length - 1; i >= 0; i--) {
			int extra = 0;
			for (int j = numOneArr.length - 1; j >= 0; j--) {
				int mul = extra + (numTwoArr[i] - '0') * (numOneArr[j] - '0');
				if (j == 0) {
					String zeroes = "";
					for (int k = 0; k < numTwoArr.length - i - 1; k++) {
						zeroes += "0";
					}
					arr[numTwoArr.length - i - 1] = mul + arr[numTwoArr.length - i - 1] + zeroes;
				} else {
					arr[numTwoArr.length - i - 1] = (mul % 10 == 0 ? "0" : mul % 10) + arr[numTwoArr.length - i - 1];
					extra = mul / 10;
				}
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		int extra = 0;
		String val = "";
		for (int i = 0; i < arr[arr.length - 1].length(); i++) {
			int sum = extra;
			for (int j = 0; j < arr.length; j++) {
				if (i < arr[j].length()) {
					sum += arr[j].charAt(arr[j].length() - i - 1) - '0';
				}
			}

			if (i == arr[arr.length - 1].length() - 1) {
				val = sum + val;
			} else {
				val = (sum % 10 == 0 ? "0" : sum % 10) + val;
				extra = sum / 10;
			}
		}
		return val;
	}


	public static void main(String[] args) throws IOException {
		
		// Approach gives timeout if n > 15
//		String[] t1T2n = "1 1 20".split(" ");
//
//		int t1 = Integer.parseInt(t1T2n[0]);
//
//		int t2 = Integer.parseInt(t1T2n[1]);
//
//		int n = Integer.parseInt(t1T2n[2]);
//
////		System.out.println(square("27"));
//		String result = fibonacciModified(t1, t2, n);
//
//		System.out.println(result);
//
////		System.out.println(sum("20", "300"));
		
		
		// Another approach using BigInteger
		Scanner scn = new Scanner(System.in);
	    BigInteger t1 = new BigInteger(scn.nextInt()+"");
	    BigInteger t2 = new BigInteger(scn.nextInt()+"");
	    int n = scn.nextInt();

	    BigInteger temp = new BigInteger("0");
	    for(int i=3;i<=n;i++){
	        temp = t2;
	        t2 = t2.multiply(t2);
	        t2 = t2.add(t1);
	        t1 = temp;
	    }
	    System.out.println(t2);
	    scn.close();
	}
}
