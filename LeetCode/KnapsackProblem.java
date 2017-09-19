package leetcode.outco;

public class KnapsackProblem {
	public static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] value = { 60, 100, 120 };
		int[] weight = { 10, 20, 30 };
		int capacity = 50;

		solution(value, weight, 0, 0, 0, capacity);
		System.out.println(max);
	}

	public static void solution(int[] value, int[] weight, int val, int wei, int index, int cap) {
		if (wei <= cap) {
			if (val > max) {
				max = val;
			}
		}
		if (wei > cap) {
			return;
		}
		for (int i = index; i < value.length; i++) {
			solution(value, weight, val + value[i], wei + weight[i], i + 1, cap);
		}
	}
}
