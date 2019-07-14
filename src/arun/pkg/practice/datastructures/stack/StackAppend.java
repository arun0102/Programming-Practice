package arun.pkg.practice.datastructures.stack;

import arun.pkg.practice.datastructures.stack.MyStack.Node;

public class StackAppend {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.isEmpty());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println(stack.isEmpty());
		
		stack.pop();
		stack.pop();
		
		stack.peek();
		
		print(stack);
	}

	private static void print(MyStack stack) {
		Node node = stack.getHead();
		while (null != node) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
