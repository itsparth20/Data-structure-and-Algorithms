package com.leetcode.WiggleSortII;

import java.util.Arrays;

/*
324. Wiggle Sort II
https://leetcode.com/problems/wiggle-sort-ii/description/

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.
 */
public class WiggleSortII {
}

class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length < 2) return;
        int[] arr = new int[nums.length];
        int size = nums.length;
        Arrays.sort(nums);
        int even = size%2 == 0 ? 1 : 0;
        int mid=size/2, i, j;
        for(i=1, j=size-1; i<size; i=i+2, j--){
            arr[i] = nums[j];
        }
        for(i=0, j=j; i<size; i=i+2, j--){
            arr[i] = nums[j];
        }
        System.arraycopy(arr, 0, nums, 0, size);
    }
}
