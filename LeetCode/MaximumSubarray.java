/*
https://leetcode.com/problems/maximum-subarray/description/
53. Maximum Subarray
*/
class Solution {
    public int maxSubArray(int[] nums) { 
        int left = 0, right = 0, len = nums.length, sum=0;
        int max = Integer.MIN_VALUE;
        if (len == 1) return nums[0];
        if (len > 1) max = nums[0];
        while(left < len || right < len){
            if(right < len){
                sum += nums[right];
                if (max < sum) max = sum;
                while(sum < 0 && left <= right) {
                    sum -= nums[left];
                    left++;
                }
                right++;
            }
            while(right == len && left < right){ 
                sum -= nums[left];
                if (max < sum) max = sum;
                left++;
            }            
        }
        return max;
    }
}