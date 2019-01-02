package arun.pkg.hackerrank.dp.coinchange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TheCoinChangeProblem {

	// Complete the getWays function below.
	static long getWays(long n, long[] c) {
//		long count = 0;
//		List<Long> numArr = Arrays.stream(c).sorted().boxed().collect(Collectors.toList());
		Arrays.sort(c);
		System.out.println("Sum - " + n);
		System.out.println("Denominations - " + Arrays.toString(c));
//		System.out.println("Denominations - " + numArr.toString());
//		if (n % c[0] == 0) {
//			long[] minArr = new long[(int) (n / c[0])];
//			for (int i = 0; i < minArr.length; i++) {
//				minArr[i] = c[0];
//			}
//			System.out.println(Arrays.toString(minArr));
//			count++;
//		}

//		getArray(c.length - 1, c.length - 1, c, n, new ArrayList<Long>());
		System.out.println("getCount - " + getCount(c.length - 1, c.length - 1, c, n, 0));
		System.out.println(getWays2(n, c, 0, new HashMap<String, Long>()));
		return 0;
	}

	static long getWays2(long n, long[] c, int i, HashMap<String, Long> map) {
		if (map.get(n + ":" + i) != null)
			return map.get(n + ":" + i);
		if (n == 0)
			return 1;
		if (n < 0 || i == c.length)
			return 0;
		long ways = getWays2(n - c[i], c, i, map) + getWays2(n, c, i + 1, map);
		map.put(n + ":" + i, ways);
		return ways;
	}

	private static long getCount(int pivot, int position, long[] c, long n, long sum) {
		if (-1 == position) {
			pivot--;
			position = pivot;
		}
		if (-1 == pivot) {
			return 0;
		}

		if (sum == n) {
			return 1;
		} else {
			if (sum < n) {
				return getCount(pivot, position, c, n, sum + c[position]) + getCount(pivot, position - 1, c, n, sum);
			} else {
				return 0;
			}
		}
	}

	private static void getArray(int pivot, int position, long[] c, long n, List<Long> sumList) {
		if (-1 == position) {
			pivot--;
			position = pivot;
		}
		if (-1 == pivot) {
			return;
		}
		Long sum = sumList.stream().reduce(0L, Long::sum);
		if (sum == n) {
			System.out.println(sumList.toString());
			sumList = new ArrayList<Long>();
		} else {
			if (sum + c[position] == n) {
				sumList.add(c[position]);
			} else if (sum + c[position] < n) {
				getArray(pivot, position - 1, c, n, sumList);
				sumList.add(c[position]);
				getArray(pivot, position, c, n, sumList);
			} else {
				position--;
				getArray(pivot, position, c, n, sumList);
			}
		}
	}

//	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        String[] nm = scanner.nextLine().split(" ");

		int n = 10;// Integer.parseInt(nm[0]);

		int m = 4;// Integer.parseInt(nm[1]);

		long[] c = new long[m];

		String[] cItems = "2 5 3 6".split(" ");// scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			long cItem = Long.parseLong(cItems[i]);
			c[i] = cItem;
		}

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = getWays(n, c);
		System.out.println(ways);
		// bufferedWriter.close();

		// scanner.close();
	}
}
