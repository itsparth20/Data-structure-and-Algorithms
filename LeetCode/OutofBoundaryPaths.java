package practiceProblem.leetcode;

/*
 * 576. Out of Boundary Paths
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.
 * 
 * Example 1:
Input:m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6

Example 2:
Input:m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12

Note:
Once you move the ball out of boundary, you cannot move it back.
The length and height of the grid is in range [1,50].
N is in range [0,50].
 */
import practiceProblem.LackEscape;

public class OutofBoundaryPaths {
	private static long count = 0;
	static int m = 0;
	static int n = 0;
	static int i = 0;
	static int j = 0;
	static int N = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		m = 2;
		n = 2;
		N = 2;
		i = 0;
		j = 0;
		if (m != 0)
			walk(i, j, 1);

		System.out.println(count);
	}

	static private void walk(int i, int j, int occure) {
		if (i >= m || i < 0 || j >= n || j < 0) {
			count = (count + 1) % (10 ^ 9 + 7);
			return;
		}
		if (occure <= N && i < m && i >=0  && j < n && j >=0) {
			walk(i + 1, j, occure + 1);
			walk(i, j + 1, occure + 1);
			walk(i, j - 1, occure + 1);
			walk(i - 1, j, occure + 1);
		}
	}

}
