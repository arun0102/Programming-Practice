package arun.pkg.powerprog.lonelyinteger;

import java.util.Arrays;
import java.util.List;

public class LonelyInteger {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 5, 4, 3, 3, 5, 6, 7, 2, 7, 6, 2);
		
		System.out.println(list.stream().reduce((x, y) -> x ^ y).orElse(-1));
	}
}
