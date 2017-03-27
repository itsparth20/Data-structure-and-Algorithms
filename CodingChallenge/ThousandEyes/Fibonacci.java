package thousandEyes;

import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 3;
		System.out.println(Arrays.toString(fibonacci(number)));

	}

	static int[] fibonacci(int n) {
		int n1 = 0, n2 = 1, n3, i, count = 10;
		int[] arr = new int[n];
		if (n > 0) {
			arr[0] = 0;
		}

		if (n > 1) {
			arr[0] = 0;
		}

		for (i = 2; i < n; ++i) {
			n3 = n1 + n2;
			arr[i] = n3;
			n1 = n2;
			n2 = n3;
		}
		return arr;
	}

}
