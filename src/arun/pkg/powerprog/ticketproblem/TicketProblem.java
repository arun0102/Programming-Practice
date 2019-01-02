package arun.pkg.powerprog.ticketproblem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TicketProblem {
	public static void main(String[] args) {
		List<Integer> buyersQ = Arrays.asList(1, 3, 1, 4, 3, 4);
//		1, 3, 1, 4, 3, 4
//		2, 3, 2, 3
//		1, 2, 1, 2
//		1, 1
//		
		int jessePosition = 5;
		System.out.println("Your result   - " + getCount(buyersQ, jessePosition));
		System.out.println("Actual result - " + countTicketIteration(buyersQ, jessePosition));

	}

	private static int getCount(List<Integer> que, int pos) {
		int count = 0;
		for (int i = 0; i < que.size(); i++) {
			if (que.get(i) >= que.get(pos - 1)) {
				count += que.get(pos - 1);
				if (i >= pos)
					--count;
			} else
				count += que.get(i);
		}
		return count;
	}

	public static int countTicketIteration(List<Integer> buyersQ, int jessePosition) {
		int count = 0;
		int mJessP = buyersQ.size();
		jessePosition--;
		int index = 0;
		while (buyersQ.get(jessePosition) != 0) {
			int x = buyersQ.get(index);
			if (x != 0) {
				buyersQ.set(index, --x);
				count++;
			}
			index++;
			if (index == mJessP)
				index = 0;
		}
		return count;
	}
}
