package arun.pkg.practice.datastructures.linkedlist;

import arun.pkg.practice.datastructures.linkedlist.LinkedList.Node;

public class LinkedListCheckPalindrome {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.appendToTail(1);
		ll.appendToTail(2);
		ll.appendToTail(3);
		ll.appendToTail(4);
		ll.appendToTail(5);
		ll.appendToTail(6);
		ll.appendToTail(7);

		// print(ll);

		checkPalindrome(ll);

		// print(ll);
	}

	private static void checkPalindrome(LinkedList ll) {
		LinkedList reversell = reverseLinkedList(ll);
		print(reversell);
	}

	private static LinkedList reverseLinkedList(LinkedList ll) {
		ll.head = reverse(ll.head);
		return ll;
	}

	private static Node reverse(Node node) {
		Node n = node;
		if (null != n.next) {
			reverse(n.next);
		}
		node.data = n.data;
		node.next = n.next;
		return node;
	}

	private static void print(LinkedList ll) {
		LinkedList.Node node = ll.getHead();
		if (null != node) {
			while (node.next != null) {
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);
		}
	}
}
