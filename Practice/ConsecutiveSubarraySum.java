package practiceProblem;

/*
 * Given an array of positive integers and a target value, return true if there is a subarray of consecutive elements that sum up to this target value. 

Input: Array of integers, target value
Output: Boolean
Example
Input: [6,12,1,7,5,2,3], 14      	=>	Output: true (7+5+2)
Input: [8,3,7,9,10,1,13], 50		=>	Output: false

 */
public class ConsecutiveSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {6,12,1,7,5,2,3};
		int aTarget = 14;
		
		int b[] = {8,3,7,9,10,1,13};
		int bTarget = 50;
		
		System.out.println(sumExist(a, aTarget));
		System.out.println(sumExist(b, bTarget));
	}

	private static boolean sumExist(int[] b, int bTarget) {
		// TODO Auto-generated method stub
		int sum = 0;
		int j = 0;
		for(int i = 0; i<b.length; i++){
			if(sum < bTarget){
				sum+= b[i];
			}
			while(sum > bTarget){
				sum-= b[j];
				j++;
			}
			if(sum == bTarget)
				return true;
		}
		return false;
	}

}
