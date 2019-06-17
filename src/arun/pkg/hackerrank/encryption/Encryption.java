package arun.pkg.hackerrank.encryption;

import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/encryption/problem
public class Encryption {

	// Complete the encryption function below.
	static String encryption(String s) {
		int ceilRows = s.length() > 2 ? (int) Math.sqrt(s.length()) : 0;
		int floorColumns = ceilRows * ceilRows == s.length() ? ceilRows : ceilRows + 1;
		System.out.println(ceilRows + " , " + floorColumns);
		String[] arr = new String[floorColumns];
		int beginIndex = 0;
		int endIndex = floorColumns;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.substring(beginIndex, endIndex);
			beginIndex = endIndex;
			endIndex = endIndex + floorColumns > s.length() ? s.length() : endIndex + floorColumns;
			System.out.println(arr[i]);
		}
		String str = "";
		for (int i = 0; i < arr[0].length(); i++) {
			for (int j = 0; j < arr.length; j++) {
				str += (i < arr[j].length() ? arr[j].charAt(i) : "");
			}
			str += " ";
		}
		return str.trim();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String s = scanner.nextLine();
		String s = "iuo";
		String result = encryption(s);

		System.out.println(result);

		scanner.close();
	}
}
