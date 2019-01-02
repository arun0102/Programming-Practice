package arun.pkg.reversestring;

public class ReverseString {
	static char[] data;
	public static void main(String[] args) {
		char[] in = "123456789".toCharArray();
		data = new char[in.length];
		reverseString(in, 0);
		System.out.println(String.valueOf(data));
	}

	private static void reverseString(char[] val, int x) {
		if(x == val.length) {
			return;
		}
		char chr = val[x];
		reverseString(val, ++x);
		data[val.length - x] = chr;
	}
}
