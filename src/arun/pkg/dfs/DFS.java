package arun.pkg.dfs;

public class DFS {
	public static void main(String[] args) {
		Node root = initNodes();

		traverse(root);
	}

	private static void traverse(Node node) {
		if (null == node) {
			return;
		}
		
		System.out.println(node.data);

		traverse(node.left);
		traverse(node.right);
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