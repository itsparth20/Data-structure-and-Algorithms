package practiceProblem.leetcode;



public class LongestLineofConsecutiveOneinMatrix {
	int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 1 } };
//		int[][] arr1 = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 } };
//		int[][] arr2 = { { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 1, 1 },
//				{ 1, 0, 0, 0, 1 } };
		int[][] arr3 = {
				{1,1,0,0,1,0,0,1,1,0},
				{1,0,0,1,0,1,1,1,1,1},
				{1,1,1,0,0,1,1,1,1,0},
				{0,1,1,1,0,1,1,1,1,1},
				{0,0,1,1,1,1,1,1,1,0},
				{1,1,1,1,1,1,0,1,1,1},
				{0,1,1,1,1,1,1,0,0,1},
				{1,1,1,1,1,0,0,1,1,1},
				{0,1,0,1,1,0,1,1,1,1},
				{1,1,1,0,1,0,1,1,1,1}
		};
		LongestLineofConsecutiveOneinMatrix obj = new LongestLineofConsecutiveOneinMatrix();
//		obj.longestLine(arr);
//		obj.longestLine(arr1);
//		obj.longestLine(arr2);
		obj.longestLine(arr3);
	}

	public void longestLine(int[][] arr) {
		// TODO Auto-generated method stub
		if (arr.length == 0) {
			return;
		}

		matrixValue[][] objArr = new matrixValue[arr.length + 1][arr[0].length + 2];

		for (int i = 0; i < arr.length + 1; i++) {
			for (int j = 0; j < arr[0].length + 2; j++) {
				matrixValue obj = new matrixValue();
				objArr[i][j] = obj;
				if (i == 0 || j == 0 || j == arr[0].length + 1) {
					continue;
				}

				if (arr[i - 1][j - 1] != 0) {
					objArr[i][j].value = arr[i - 1][j - 1];
					objArr[i][j].left = arr[i - 1][j - 1] + objArr[i][j - 1].left;
					objArr[i][j].up = arr[i - 1][j - 1] + objArr[i - 1][j].up;
					objArr[i][j].diagonal = arr[i - 1][j - 1] + objArr[i - 1][j - 1].diagonal;
					objArr[i][j].antiDiagonal = arr[i - 1][j - 1] + objArr[i - 1][j + 1].antiDiagonal;
					max = Math.max(max, Math.max(objArr[i][j].left,
							Math.max(objArr[i][j].up, Math.max(objArr[i][j].diagonal, objArr[i][j].antiDiagonal))));
				}
			}
		}

		System.out.println(max);
	}

	class matrixValue {
		int value = 0;
		int left = 0;
		int up = 0;
		int diagonal = 0;
		int antiDiagonal = 0;
	}

}
