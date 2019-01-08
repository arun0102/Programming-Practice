package arun.pkg.powerprog.road_in_hackerland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HackerrankSolution {

	private static List<Edge> mstEdgs = new ArrayList<>();
	static long[] outputs;
	static int N, M;
	static Node[] nodes;

	static class Node {
		int nodeId;
		List<Edge> edges;

		public Node(int nodeId) {
			this.nodeId = nodeId;
			edges = new ArrayList<>();
		}
	}

	static class Edge implements Comparable<Edge> {
		int n1;
		int n2;
		int weight;
		long count;

		public Edge(int n1, int n2, int weight) {
			this.n1 = n1;
			this.n2 = n2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return (int) (this.weight - o.weight);
		}

		public String toString() {
			return n1 + " ---" + n2 + ". Weighe:: " + weight;
		}
	}

	static class DisjointSet {
		int[] parent;

		public DisjointSet(int n) {
			parent = new int[n + 1];
			Arrays.fill(parent, -1);
		}

		public int find(int x) {
			if (parent[x] < 0) {
				return x;
			}
			int next = x;
			while (parent[next] > 0) {
				next = parent[next];
			}
			return next;
		}

		public void union(int x, int y) {
			if (parent[y] < parent[x]) {
				parent[x] = y;
			} else {
				if (parent[x] == parent[y]) {
					parent[x]--;
				}
				parent[y] = x;
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		nodes = new Node[N + 1];
		Edge[] edges = new Edge[M];
		outputs = new long[2 * M];

		for (int n = 1; n <= N; n++) {
			nodes[n] = new Node(n);
		}
		List<Edge> graphEdges = new ArrayList<>();
		for (int m = 0; m < M; m++) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			int power = scan.nextInt();
			Edge edge = new Edge(node1, node2, power);
			edges[power] = edge;
			graphEdges.add(edge);
		}

		krushkalMST(graphEdges, N);
		// mstEdgs.forEach(System.out::println);
		Node firstNode = nodes[mstEdgs.get(0).n1];
		dfs(null, firstNode);

		for (Edge edge : mstEdgs) {
			outputs[edge.weight] = edge.count * (N - edge.count);
		}
		long extension;
		long number;
		long[] temp = new long[2 * M];

		for (int i = 0; i < 2 * M; i++) {
			number = outputs[i];
			int flag = 0;
			while (number > 0) {
				temp[i + flag] += number % 2;
				number /= 2;
				flag++;
			}
		}
		extension = 0;
		Arrays.fill(outputs, 0);
		for (int i = 0; i < 2 * M; i++) {
			outputs[i] = (temp[i] + extension) % 2;
			extension = (temp[i] + extension) / 2;
		}

		boolean init = false;
		for (int i = 2 * M - 1; i >= 0; i--) {
			if (outputs[i] == 0 && init)
				System.out.print(0);
			else if (outputs[i] == 1) {
				System.out.print(1);
				init = true;
			}
		}
		scan.close();

	}

	private static void krushkalMST(List<Edge> edges, int N) {
		Collections.sort(edges);
		DisjointSet disjointSet = new DisjointSet(N);
		for (int i = 0; i < edges.size() && mstEdgs.size() < N - 1; i++) {
			Edge currentEdge = edges.get(i);
			int root1 = disjointSet.find(currentEdge.n1);
			int root2 = disjointSet.find(currentEdge.n2);
			if (root1 != root2) {
				mstEdgs.add(currentEdge);
				disjointSet.union(root1, root2);
				nodes[currentEdge.n1].edges.add(currentEdge);
				nodes[currentEdge.n2].edges.add(currentEdge);
			}
		}
	}

	private static int dfs(Node root, Node child) {
		int count = 1;
		for (Edge edge : child.edges) {
			if (root != null && (edge.n1 == root.nodeId || edge.n2 == root.nodeId)) {
				continue;
			}
			Node nextNode = null;
			if (edge.n1 == child.nodeId) {
				nextNode = nodes[edge.n2];
			} else {
				nextNode = nodes[edge.n1];
			}
			edge.count = dfs(child, nextNode);
			count += edge.count;
		}
		return count;

	}
}
