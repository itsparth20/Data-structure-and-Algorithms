/*
41. First Missing Positive
https://leetcode.com/problems/first-missing-positive/description/
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        Arrays.sort(nums);
        int m = 1;
        for(int i = 0; i < nums.length; i++){
            if(m > nums[i]) continue;
            else if (m == nums[i]) m++;
            else return m;
        }
        return m;
    }
}