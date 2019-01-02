package arun.pkg.stackdemo;

import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(test(stack));
	}
	
	private static Integer test(Stack<Integer> a) {
		Integer x = a.pop();
		if(a.indexOf(x) != -1) {
			a = (Stack<Integer>) a.stream().filter(t->t!=x).collect(Collectors.toSet());
			return test(a);
		}
		return x;
	}
}
