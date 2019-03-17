package arun.pkg.hackerrank.linked_list_tail_add;

import java.io.IOException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
public class LinkedListTailAdd {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;

		public SinglyLinkedList() {
			this.head = null;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
		while (node != null) {
			System.out.println(String.valueOf(node.data));

			node = node.next;
		}
	}

	// Complete the insertNodeAtTail function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		if(null == head) {
			return new SinglyLinkedListNode(data);
		}
		SinglyLinkedListNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		tail.next = node;
		return head;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		SinglyLinkedList llist = new SinglyLinkedList();

		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

			llist.head = llist_head;
		}

		printSinglyLinkedList(llist.head, "\n");

		scanner.close();
	}
}
