package arun.pkg.hackerrank.queens_attack_2;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttack2 {

	// Complete the queensAttack function below.
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int top = n - r_q;
		int bottom = r_q - 1;
		int left = c_q - 1;
		int right = n - c_q;
		int topLeft = Math.min(top, left);
		int topRight = Math.min(top, right);
		int bottomLeft = Math.min(bottom, left);
		int bottomRight = Math.min(bottom, right);

		for (int i = 0; i < k; i++) {
			int[] obs = obstacles[i];
			int r = obs[0];
			int c = obs[1];
			if (r == r_q) { // handling horizontal cases
				// row is same
				if (c == c_q) {
					// both row and column are same, do nothing as the obstacle position is queens
					// position itself which will never come
				} else {
					// column is changing
					if (c > c_q) {
						// column is greater
						if (right > c - c_q - 1) {
							right = c - c_q - 1;
						}
					} else {
						if (left > c_q - c - 1) {
							left = c_q - c - 1;
						}
					}
				}
			} else if (c == c_q) {// handling vertical cases
				// column is same
				if (r == r_q) {
					// both row and column are same, do nothing as the obstacle position is queens
					// position itself which will never come
				} else {
					// row is changing
					if (r > r_q) {
						// row is greater
						if (top > r - r_q - 1) {
							top = r - r_q - 1;
						}
					} else {
						if (bottom > r_q - r - 1) {
							bottom = r_q - r - 1;
						}
					}
				}
			} else if (r > r_q) {// handling diagonal cases
				// row is greater
				if (c > c_q) {
					// column is greater
					if (r - r_q == c - c_q) { // if lies on top right diagonal
						if (n - r_q > n - c_q) { // check if top > right for getting minimum value
							if (topRight > r - r_q - 1) {
								topRight = r - r_q - 1;
							}
						} else {
							if (topRight > c - c_q - 1) {
								topRight = c - c_q - 1;
							}
						}

					}
				} else {
					// column is less
					if (r - r_q == c_q - c) { // if lies on top left diagonal
						if (n - r_q > c_q - 1) {// check if top > left for getting minimum value
							if (topLeft > r - r_q - 1) {
								topLeft = r - r_q - 1;
							}
						} else {
							if (topLeft > c_q - c - 1) {
								topLeft = c_q - c - 1;
							}
						}
					}
				}
			} else {// handling diagonal cases
				// row is less
				if (c > c_q) {
					// column is greater
					if (r_q - r == c - c_q) { // if lies on bottom right diagonal
						if (r_q - 1 > n - c_q) {// check if bottom > right for getting minimum value
							if (bottomRight > r_q - r - 1) {
								bottomRight = r_q - r - 1;
							}
						} else {
							if (bottomRight > c - c_q - 1) {
								bottomRight = c - c_q - 1;
							}
						}
					}
				} else {
					// column is less
					if (r_q - r == c_q - c) { // if lies on bottom left diagonal
						if (r_q - 1 > c_q - 1) {// check if bottom > left for getting minimum value
							if (bottomLeft > r_q - r - 1) {
								bottomLeft = r_q - r - 1;
							}
						} else {
							if (bottomLeft > c_q - c - 1) {
								bottomLeft = c_q - c - 1;
							}
						}
					}
				}
			}
		}
		return top + left + right + bottom + topLeft + topRight + bottomLeft + bottomRight;
	}

	static int queensAttack2(int n, int k, int r_q, int c_q, int[][] obstacles) {
		int count = 0;

		// inc row
		for (int i = r_q + 1; i <= n; i++) {
			if (!isBlocked(i, c_q, obstacles)) {
				count++;
			} else {
				break;
			}
		}
		// dec row
		for (int i = r_q - 1; i > 0; i--) {
			if (!isBlocked(i, c_q, obstacles)) {
				count++;
			} else {
				break;
			}
		}
		// inc column
		for (int i = c_q + 1; i <= n; i++) {
			if (!isBlocked(r_q, i, obstacles)) {
				count++;
			} else {
				break;
			}
		}
		// dec column
		for (int i = c_q - 1; i > 0; i--) {
			if (!isBlocked(r_q, i, obstacles)) {
				count++;
			} else {
				break;
			}
		}

		// inc row, inc column
		for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
			if (!isBlocked(i, j, obstacles)) {
				count++;
			} else {
				break;
			}
		}

		// inc row, dec column
		for (int i = r_q + 1, j = c_q - 1; i <= n && j > 0; i++, j--) {
			if (!isBlocked(i, j, obstacles)) {
				count++;
			} else {
				break;
			}
		}

		// dec row, inc column
		for (int i = r_q - 1, j = c_q + 1; i > 0 && j <= n; i--, j++) {
			if (!isBlocked(i, j, obstacles)) {
				count++;
			} else {
				break;
			}
		}

		// dec row, dec column
		for (int i = r_q - 1, j = c_q - 1; i > 0 && j > 0; i--, j--) {
			if (!isBlocked(i, j, obstacles)) {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	static boolean isBlocked(int r, int c, int[][] obstacles) {
		for (int i = 0; i < obstacles.length; i++) {
			if (obstacles[i][0] == r && obstacles[i][1] == c) {
				return true;
			}
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = 100;// 1000;// 100000;// 4;// Integer.parseInt(nk[0]);

		int k = 100;// 1000;// 100000;// 0;// Integer.parseInt(nk[1]);

		int r_q = 48;// 372;// 6453;// 4;// Integer.parseInt(r_qC_q[0]);

		int c_q = 81;// 581;// 3654;// 4;// Integer.parseInt(r_qC_q[1]);

//		int[][] obstacles = { { 5, 5 }, { 4, 2 }, { 2, 3 } };// new int[k][2];
//		int[][] obstacles = {};// new int[k][2];

		int[][] obstacles = new int[k][2];

		for (int i = 0; i < k; i++) {
			String[] obstaclesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
				obstacles[i][j] = obstaclesItem;
			}
		}

		int result = queensAttack(n, k, r_q, c_q, obstacles);

		System.out.println(result);

		scanner.close();
	}
}
