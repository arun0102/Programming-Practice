package arun.pkg.practice.datastructures.queue;

import arun.pkg.practice.datastructures.queue.MyQueue.Node;

public class QueueAppend {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);

		queue.pop();
		queue.pop();
		queue.pop();
		
		print(queue);
	}

	private static void print(MyQueue queue) {
		Node node = queue.getHead();
		while (null != node) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
