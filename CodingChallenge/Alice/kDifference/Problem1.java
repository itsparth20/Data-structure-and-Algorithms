package alice.kDifference;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,5,3,4,2};
		int k = 2;
		System.out.println(kDifference(a, k));

	}

	static int kDifference(int a[], int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int pair = 0;
		for (int i = 0; i < a.length; i++) {

			map.put(a[i], 1);
		}
		for (int j = 0; j < a.length; j++) {
			int val = a[j] + k;
			if (map.containsKey(val)) {
				pair++;
			}
		}
		return pair;

	}
}
