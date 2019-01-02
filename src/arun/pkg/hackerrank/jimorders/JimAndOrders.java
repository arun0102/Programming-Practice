package arun.pkg.hackerrank.jimorders;

import java.io.IOException;
import java.util.Arrays;

public class JimAndOrders {

	// Complete the jimOrders function below.
	static int[] jimOrders(int[][] orders) {
		for (int i = 0; i < orders.length; i++) {
			orders[i][1] = orders[i][0] + orders[i][1];
			orders[i][0] = i + 1;
		}

		orders = bubbleSortArray(1, orders);
		int[] result = new int[orders.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = orders[i][0];
		}
		return result;
	}

	private static int[][] bubbleSortArray(int endPosition, int[][] orders) {
		boolean isSwitched = false;
		for (int i = 0; i < orders.length - endPosition; i++) {
			if (orders[i][1] > orders[i + 1][1]) { // switch places
				isSwitched = true;
				int tempIndex = orders[i + 1][0];
				int tempVal = orders[i + 1][1];
				orders[i + 1][1] = orders[i][1];
				orders[i + 1][0] = orders[i][0];
				orders[i][1] = tempVal;
				orders[i][0] = tempIndex;
			}
		}

		if (isSwitched) {
			bubbleSortArray(endPosition + 1, orders);
		} else {
			return orders;
		}
		return orders;
	}

//	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = 5;// scanner.nextInt();
		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[][] orders = { { 8, 1 }, { 4, 2 }, { 5, 6 }, { 3, 1 }, { 4, 3 } };// new int[n][2];

//		for (int i = 0; i < n; i++) {
//			String[] ordersRowItems = scanner.nextLine().split(" ");
//			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//			for (int j = 0; j < 2; j++) {
//				int ordersItem = Integer.parseInt(ordersRowItems[j]);
//				orders[i][j] = ordersItem;
//			}
//		}

		int[] result = jimOrders(orders);

		System.out.println(Arrays.toString(result));

//		scanner.close();
	}
}
