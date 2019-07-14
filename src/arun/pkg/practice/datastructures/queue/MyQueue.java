package arun.pkg.practice.datastructures.queue;

public class MyQueue {
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
		Node n = new Node(data);
		if (null == head) {
			head = n;
			return;
		}
		Node cur = head;
		while (null != cur.next) {
			cur = cur.next;
		}
		cur.next = n;
	}
	
	public Node pop() {
		Node n = head;
		head = head.next;
		return n;
	}

	public Node getHead() {
		return head;
	}
}
