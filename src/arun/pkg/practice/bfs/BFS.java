package arun.pkg.practice.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void main(String[] args) {
		Node root = initNodes();

		traverse(root);
	}

	private static void traverse(Node root) {
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			Node node = que.remove();
			System.out.println(node.data);

			Node left = node.left;
			Node right = node.right;

			if (null != left) {
				que.add(left);
			}
			if (null != right) {
				que.add(right);
			}
		}
	}

	private static Node initNodes() {
		Node root = new Node(new Node(new Node("D"), new Node("E"), "B"),
				new Node(new Node(new Node("H"), null, "F"), new Node("G"), "C"), "A");
		return root;
	}
}

//				A
//		|				|
//		B				C
//	|		|		|		|
//	D		E		F		G
//					|
//					H