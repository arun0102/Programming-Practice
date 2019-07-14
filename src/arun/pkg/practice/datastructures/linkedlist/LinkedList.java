package arun.pkg.practice.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node deleteNode(int d) {
		if (head.data == d) {
			head = head.next;
		} else {
			Node node = head;
			while (node.next != null) {
				if (node.next.data == d) {
					node.next = node.next.next;
					return head;
				}
				node = node.next;
			}
		}
		return head;
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = head;
		if (n != null) {
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		} else {
			head = end;
		}
	}

	public void removeDuplicates() {
		Node current = head;
		while (current != null) {
			Node node = current;
			while (node.next != null) {
				if(node.next.data == current.data) {
					node.next = node.next.next;
				} else {
					node = node.next;
				}
			}
			current = current.next;
		}
	}

	public Node getHead() {
		return head;
	}
}
