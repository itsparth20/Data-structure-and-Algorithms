package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}

	// Two Sum Program
	public static int[] findTwoSum(int[] list, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.length; i++) {

			if (map.containsKey(list[i])) {
				return new int[] { map.get(list[i]), i };
			}
			int complement = sum - list[i];
			map.put(complement, i);
		}
		return null;
	}

}
