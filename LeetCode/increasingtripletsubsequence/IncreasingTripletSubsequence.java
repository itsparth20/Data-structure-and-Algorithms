package com.leetcode.increasingtripletsubsequence;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
334. Increasing Triplet Subsequence

https://leetcode.com/problems/increasing-triplet-subsequence/description/

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 */

public class IncreasingTripletSubsequence {
    private static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int min1 = Integer.MAX_VALUE, max1 = Integer.MAX_VALUE, min2=Integer.MAX_VALUE, max2 = Integer.MAX_VALUE;
        for(int x:nums){
            if(x > min2 && x > max2){
                return true;
            }
            else if(x > min1 && x > max1){
                return true;
            }
            else if(x < min1){
                min2= min1;
                max2= max1;
                max1=Integer.MAX_VALUE;
                min1=x;
            }
            else if(x > min1 && x < max1){
                max1=x;
            }

        }
        return false;
    }

    private static boolean increasingTriplet1(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i <= x) {
                x = i;
            } else if (i <= y) {
                y = i;
            } else {
                return true;
            }

        }
        return false;
    }
    @Test
    public void test1() {
        assertEquals(false, IncreasingTripletSubsequence.increasingTriplet(new int[]{1,1,-2,6}));
    }


    @Test
    public void test2() {
        assertEquals(true, IncreasingTripletSubsequence.increasingTriplet(new int[]{1,2,3,4,5}));
    }

    @Test
    public void test3() {
        assertEquals(false, IncreasingTripletSubsequence.increasingTriplet1(new int[]{1,1,-2,6}));
    }

    @Test
    public void test4() {
        assertEquals(true, IncreasingTripletSubsequence.increasingTriplet1(new int[]{1,2,3,4,5}));
    }

}
