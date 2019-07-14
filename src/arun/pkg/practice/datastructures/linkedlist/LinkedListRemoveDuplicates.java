package arun.pkg.practice.datastructures.linkedlist;

public class LinkedListRemoveDuplicates {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.appendToTail(1);
		ll.appendToTail(2);
		ll.appendToTail(1);
		ll.appendToTail(3);
		ll.appendToTail(4);
		ll.appendToTail(2);
		ll.appendToTail(3);
		ll.appendToTail(5);

		// print(ll);

		ll.removeDuplicates();

		print(ll);
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


