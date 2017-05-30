package practiceProblem.leetcode;
/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    
    16. 3Sum Closest
    
    More Description: https://leetcode.com/problems/3sum-closest/#/description
 */
import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int threeSumClosest(int[] nums, int target) {
		int closest = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length-2; i++){
			int start = i + 1, end = nums.length - 1;
			while(start < end){
				int sum = nums[i] + nums[start] + nums[end];
				if(sum > target)
					end--;
				else
					start++;
				if(Math.abs(sum-target) < Math.abs(closest-target))
					closest = sum;
			}
		}
		return closest;
	}
}
