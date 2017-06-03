package practiceProblem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		fourSum(nums, target);
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list= new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length-3; i++){
			if(i > 0 && nums[i] == nums[i-1]) continue;
			for(int j = i+1; j < nums.length-2; j++){
				if(nums[j] == nums[j-1]) continue;
				for(int k = j+1, l = nums.length-1; k<l;){
					if(nums[i]+nums[j]+nums[k]+nums[l] == target){
						list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
						k++;
						l--;
						while(k<l && (nums[k] == nums[k-1])) k++;
						while(k<l && (nums[l] == nums[l+1])) l--;
					}else if(nums[i]+nums[j]+nums[k]+nums[l] > target) l--;
					else
						k++;				
				}
			}
		}
		
		return list;
	}
}
