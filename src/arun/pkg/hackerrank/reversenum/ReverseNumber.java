package arun.pkg.hackerrank.reversenum;

public class ReverseNumber {
	public static void main(String[] args) {
		reverseNumber(12345);
		checkPalindrome(123454321);
	}
	
	static int reverseNumber(int num) {
		if(num > 0) {
			int revNum = 0;
			while(num > 0) {
				revNum = revNum * 10 + num % 10;
				num = num / 10;
			}
			return revNum;
		}
		return 0;
	}
	
	static void checkPalindrome(int num) {
		if(reverseNumber(num) == num) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
