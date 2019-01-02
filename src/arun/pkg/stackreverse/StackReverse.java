package arun.pkg.stackreverse;

import java.util.Iterator;
import java.util.Stack;

public class StackReverse {
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		printStack(stack);
		reverseStack();
		printStack(stack);
	}
	
	static void reverseStack() {
		if(!stack.isEmpty()) {
			int val = stack.pop();
			reverseStack();
			insert(val);
		}
	}
	
	static void insert(int x) {
		if(stack.isEmpty()) {
			stack.push(x);
		} else {
			int val = stack.pop();
			insert(x);
			stack.push(val);
		}
	}

	private static void printStack(Stack<Integer> stack) {
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
		System.out.println();
	}
}
