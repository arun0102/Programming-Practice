package arun.pkg.minuniqueintegers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MinUniqueIntegers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String knValue = s.nextLine();
		String numStr = s.nextLine();

		String[] knArr = knValue.split(",");
		int k = Integer.parseInt(knArr[0]);
		int n = Integer.parseInt(knArr[1]);

		String[] numArr = numStr.split(",");
		Map<String, Integer> uniqueMap = getCountOfUniques(numArr);
		Map<String, Integer> uniqueKeys = removeMin(uniqueMap, k);

		System.out.println(uniqueKeys.size());
	}

	private static Map<String, Integer> getCountOfUniques(String[] numArr) {
		Map<String, Integer> countMap = new HashMap<>();
		for (int i = 0; i < numArr.length; i++) {
			if (countMap.containsKey(numArr[i])) {
				countMap.put(numArr[i], countMap.get(numArr[i]) + 1);
			} else {
				countMap.put(numArr[i], 1);
			}
		}
		return countMap;
	}

	private static Map<String, Integer> removeMin(Map<String, Integer> uniqueMap, int k) {
		for (int i = 0; i < k; i++) {
			int minCount = Integer.MAX_VALUE;
			String minKey = "";
			Iterator<String> keySet = uniqueMap.keySet().iterator();
			while (keySet.hasNext()) {
				String key = keySet.next();
				if (minCount > uniqueMap.get(key)) {
					minKey = key;
					minCount = uniqueMap.get(key);
				}
			}
			if (1 < uniqueMap.get(minKey)) {
				uniqueMap.put(minKey, uniqueMap.get(minKey) - 1);
			} else {
				uniqueMap.remove(minKey);
			}
		}
		return uniqueMap;
	}
}
