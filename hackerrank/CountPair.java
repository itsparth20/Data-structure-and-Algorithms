package practiceProblem.GeeksforGeeks;

import java.util.HashMap;

public class CountPair {
	public static void main(String args[]) {
		int[] a = { 1, 3, 46, 1, 3, 9 };
		System.out.println(numberOfPairs(a, 47));
	}

	private static int numberOfPairs(int[] arr, long sum) {
		int n = arr.length;
		HashMap<Long, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			
			if (!hm.containsKey(arr[i]))
				hm.put((long)arr[i], 0);

			hm.put((long)arr[i], hm.get((long)arr[i]) + 1);
		}
		int twice_count = 0;

		for (int i = 0; i < n; i++) {
			long x = sum - arr[i];
			if (hm.containsKey(x)) {
				twice_count += hm.get(sum - arr[i]);

				long p = sum - arr[i];
				if (p == arr[i])
					twice_count--;
			}
		}
		return twice_count / 2;
	}

}
