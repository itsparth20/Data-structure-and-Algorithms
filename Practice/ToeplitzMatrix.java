package practiceProblem;

/*
 * Given a square matrix, find if it is a Toeplitz matrix or not.
A Toeplitz (or diagonal-constant) matrix is a matrix where each descending diagonal from left to right is constant (i.e., all elements in a diagonal are same).

Input: An N x N matrix
Output: Boolean
Example
Input:    [[3, 4, 5, 6],
		[2, 3, 4, 5],
		[1, 2, 3, 4],
		[0, 1, 2, 3]]
=>	Output: True

 */

public class ToeplitzMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1, 5}};
		int b[][] = {{2, 1},
					 {3, 2}
		};
		int c[][] = {
				{3, 4, 5, 6},
				{2, 3, 4, 5},
				{1, 2, 3, 4},
				{0, 1, 2, 3}
		};
		
		int d[][] = {
				{3, 4, 5, 6},
				{2, 3, 4, 5},
				{1, 1, 3, 4},
				{0, 1, 2, 3}
		};
		int e[][] = {
				{0, 1},
				{2, 1}
				
	};
		
		System.out.println(isToeplitzMatrix(e));
	}

	private static boolean isToeplitzMatrix(int[][] a) {
		// TODO Auto-generated method stub
		
		int i = 0, j = 0;
		while(i<a[0].length && a.length > 1){
			int value = a[0][i];
			j= 1;
			int iTemp = i+1;
			while(j<a.length && iTemp<a[0].length){
				if(value == a[j][iTemp]){
					iTemp++;
					j++;
				}else
					return false;
			}
			i++;
			
		}
		
		i = 0; j = 0;
		while(i<a[0].length && a.length > 1){
			int value = a[i][0];
			j= 1;
			int iTemp = i+1;
			while(j<a.length && iTemp<a[0].length){
				if(value == a[iTemp][j]){
					iTemp++;
					j++;
				}else
					return false;
			}
			i++;
			
		}
		
		return true;
	}
	
	//Easy Way
	public static boolean solution(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i - 1 >= 0 && j - 1 >= 0) {
					if (arr[i - 1][j - 1] != arr[i][j]) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
