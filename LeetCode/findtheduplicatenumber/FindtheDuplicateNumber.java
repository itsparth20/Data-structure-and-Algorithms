package com.leetcode.findtheduplicatenumber;

import java.util.Arrays;
/*
287. Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/description/
 */
public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] == nums[i]){
                return nums[i];
            }
        }
        return -1;
    }
}
