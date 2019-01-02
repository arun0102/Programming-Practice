package arun.pkg.midstack;

import java.util.Scanner;
import java.util.Stack;

class Mid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Stack<Integer> s = new Stack<>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				s.push(x);
			}
			if (n == 1) {
				System.out.println(s.peek());
				continue;
			}
			GfG g = new GfG();
			s = g.deleteMid(s, n, 0);
			while (!s.isEmpty()) {
				int x = s.peek();
				s.pop();
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

// User function Template for Java
class GfG {
	public Stack<Integer> deleteMid(Stack<Integer> s, int n, int current) {

		return s;

	}
}