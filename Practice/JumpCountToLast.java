package practiceProblem;

/*Given an array of non-negative integers, starting at the first index of
 *     the array. Each element in the array represents your maximum jump length
 *     at that position. What is the minimum number of jumps to reach the last 
 *     index?
 *
 *  Input: Array of non-negative integers
 *  Output: Integer
 *
 *  Example: jump([2,3,1,1,4])
 *  Result: 2 because traveling from 2 -> 3 -> 4 uses 2 jumps
 */
public class JumpCountToLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 1, 1, 4 };
		int[] arr1 = { 3, 1, 1, 2, 4, 6, 2, 1, 3, 2, 2, 4, 3, 1, 4, 2, 1, 3, 1, 2, 5, 2, 5, 7, 4, 1, 3, 1, 2, 5, 2, 5,
				7, 4, 1, 3, 2, 3, 1, 1, 7, 4, 1, 3, 2, 3, 1, 1, 7, 4, 1, 3, 2, 3, 1, 1, 3, 2, 1 };
		int[] input = { 1, 2, 5, 2, 5, 7, 4, 1, 3, 2, 3, 1, 1, 3, 2, 1 };

		System.out.println(countJump(arr1));
	}

	private static int countJump(int[] arr) {
		int count = 0;
		if (arr.length == 0)
			return count;
		int increment = 1;
		int curIndex = 0;
		int index = 0, max = 0;
		while (curIndex < arr.length - 1) {
			increment = 1;
			while (increment <= arr[curIndex]) {
				if (curIndex + increment < arr.length) {
					if (max < arr[curIndex + increment] + curIndex + increment) {
						index = curIndex + increment;
						max = arr[curIndex + increment] + curIndex + increment;
					}				
				}else{
					index = arr.length;
				}
				increment++;
			}
			count++;
			curIndex = index;
		}
		return count;
	}

}
