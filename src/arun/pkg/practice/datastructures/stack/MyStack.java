package arun.pkg.practice.datastructures.stack;

public class MyStack {
	private Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	public Node pop() {
		Node pop = head;
		head = head.next;
		return pop;
	}

	public Node peek() {
		return head;
	}

	public boolean isEmpty() {
		return null == head ? true : false;
	}

	public Node getHead() {
		return head;
	}
}
