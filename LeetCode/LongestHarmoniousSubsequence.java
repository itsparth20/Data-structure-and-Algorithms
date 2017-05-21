package practiceProblem.leetcode;
/*
 * 
 * 594. Longest Harmonious Subsequence 
 * My SubmissionsBack To Contest
User Accepted: 789
User Tried: 989
Total Accepted: 803
Total Submissions: 2956
Difficulty: Easy
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
 */
import java.util.HashMap;

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,3,2,2,5,2,3,7};
		System.out.println(findLHS(a));
	}
	
	public static int findLHS(int[] nums) {
        int longest = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
        	map.putIfAbsent(i, 0);
        	map.put(i, map.get(i)+1);
        }
		
        for(int i : nums){
        	
        	if(map.containsKey(i-1))
        		longest = Math.max(longest, map.get(i-1)+map.get(i));        	
        }
		return longest;
    }

}
