package arun.pkg.climbleaderboard;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class ClimbLeaderboardProblem {

	// Complete the climbingLeaderboard function below.
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		// 100 100 50 40 40 20 10
		// 5 4 3 2 120
		int[] ranksArr = new int[alice.length];
		ArrayList<Integer> rankArr = new ArrayList<Integer>();
		for (int j = 0; j < scores.length; j++) {
			if (!rankArr.contains(scores[j])) {
				boolean isAdded = false;
				for (int i = 0; i < rankArr.size(); i++) {
					if (scores[j] > rankArr.get(i)) {
						rankArr.add(i, scores[j]);
						isAdded = true;
						break;
					}
				}
				if (!isAdded) {
					rankArr.add(scores[j]);
				}
			}
		}
		for (int i = 0; i < alice.length; i++) {
			if (!rankArr.contains(alice[i])) {
				boolean isAdded = false;
				for (int j = 0; j < rankArr.size(); j++) {
					if (alice[i] > rankArr.get(j)) {
						rankArr.add(j, alice[i]);
						isAdded = true;
						break;
					}
				}
				if (!isAdded) {
					rankArr.add(alice[i]);
				}
			}
			ranksArr[i] = rankArr.indexOf(alice[i]) + 1;
		}
		return ranksArr;

		// for(int i=0; i<alice.length; i++) {
		// int rank = 1;
		// int currentRank = 1;
		// for(int j=0; j<scores.length; j++) {
		// if(alice[i] >= scores[j]) {
		// rank = currentRank;
		// break;
		// }
		// if((j < (scores.length - 1) && scores[j] > scores[j+1]) || (i < (alice.length
		// - 1) && alice[i] > alice[i+1])) {
		// currentRank++;
		// } else if(j == scores.length -1) {
		// currentRank++;
		// }
		// }
		// ranksArr[i] = currentRank;
		// }
		// return ranksArr;
	}

	public static void main(String[] args) throws IOException {
		int[] scores = {99999291, 99999252, 99999170, 99998537, 99998535, 99998386, 99998178, 99998168, 99997705, 99997602, 99997179, 99995830, 99995696, 99994263, 99993436, 99993240, 99993016, 99991535, 99991014, 99989878, 99989562, 99988069, 99988050, 99987578, 99987198, 99985818, 99985353, 99985299, 99984538, 99984018, 99983901, 99983362, 99982558, 99981719, 99981681, 99981137, 99980741, 99980586, 99980581, 99980420, 99980412, 99979665, 99978892, 99977963, 99977673, 99977505, 99976283, 99976228, 99976058, 99975577, 99974437, 99973903, 99973671, 99973484, 99973152, 99970400, 99969479, 99969237, 99968968, 99967707, 99967612, 99967609, 99967539, 99965934, 99965326, 99965134, 99964104, 99964081, 99963645 };

		int[] alice = { 5, 25, 5, 3 };

		int[] result = climbingLeaderboard(scores, alice);

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
