package arun.pkg.practice.datastructures.linkedlist;

public class LinkedListAppend {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.appendToTail(1);
		ll.appendToTail(2);
		ll.appendToTail(3);

		print(ll);

		ll.deleteNode(2);

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
