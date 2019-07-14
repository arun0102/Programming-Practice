package arun.pkg.practice.recursion.nqueensproblem;

public class NQueensProblem {
	public static void main(String[] args) {
		int n = 4;
		Position[] posArr = solveNQueens(n);
		for (int i = 0; i < posArr.length; i++) {
			System.out.println(posArr[i].row + "," + posArr[i].column);
		}
	}

	private static Position[] solveNQueens(int n) {
		Position[] psArr = new Position[n];
		boolean hasSolution = solve(n, 0, psArr);
		if (hasSolution) {
			return psArr;
		}
		return new Position[0];
	}

	private static boolean solve(int n, int row, Position[] psArr) {
		if (n == row) {
			return true;
		}

		for (int col = 0; col < n; col++) {
			boolean isSafe = true;

			for (int queen = 0; queen < row; queen++) {
				if (psArr[queen].column == col || psArr[queen].row - psArr[queen].column == row - col
						|| psArr[queen].row + psArr[queen].column == row + col) {
					isSafe = false;
					break;
				}
			}
			if (isSafe) {
				psArr[row] = new Position(row, col);
				if (solve(n, row + 1, psArr)) {
					return true;
				}
			}
		}
		return false;
	}
}

class Position {
	int row, column;

	Position(int row, int column) {
		this.row = row;
		this.column = column;

	}
}