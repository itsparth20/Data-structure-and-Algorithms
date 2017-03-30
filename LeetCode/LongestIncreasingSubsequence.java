package practiceProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
	public static void main(String[] args){
		int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		System.out.println(obj.lengthOfLIS(arr));
	}
	
	public int lengthOfLIS(int[] nums) {
		List<Integer> list = new ArrayList<>(nums.length);
		if(nums.length == 0){
			return 0;
		}
		list.add(nums[0]);
		
		for(int num : nums){
			if(num > list.get(list.size()-1))
				list.add(num);
			else{
				int index = Collections.binarySearch(list, num);
				list.set((index<0) ? -index-1 : index, num);
			}			
		}
		
		return list.size();
	}
}
