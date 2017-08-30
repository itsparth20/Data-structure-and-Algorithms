package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 3, 1, 3 };
		int[] arr2 = { 1, 2, 3, 1 };
		System.out.println(getK(arr1, arr2, 2));
	}

	private static List<Index> getK(int[] arr1, int[] arr2, int k) {
		Map<Integer, List<Index>> map = new TreeMap<>();
		List<Index> list = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				int sum = arr1[i] + arr2[j];
				// sum exist
				if (map.containsKey(sum)) {
					List<Index> indexClass = map.get(sum);
					indexClass.add(new Index(sum, i, j));
				}
				// sum is not exist
				else {
					List<Index> ls = new ArrayList<>();
					ls.add(new Index(sum, i, j));
					map.put(sum, ls);
				}
			}
		}
		int z = 0;
		for (Map.Entry<Integer, List<Index>> entry : map.entrySet()) {
			for (Index x : entry.getValue()) {
				if (z++ < k)
					list.add(x);
			}
		}
		return list;
	}
}

class Index {
	int sum;
	int index1;
	int index2;

	/**
	 * @param sum
	 * @param index1
	 * @param index2
	 */
	public Index(int sum, int index1, int index2) {
		super();
		this.sum = sum;
		this.index1 = index1;
		this.index2 = index2;
	}

	public String toString() {

		return "" + index1 + " " + index2;

	}

}
