package com.leetcode.missingnumber;

import java.util.stream.IntStream;
/*
268. Missing Number
https://leetcode.com/problems/missing-number/description/
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int missingSum = IntStream.of(nums).sum();

        int length = nums.length;

        int sum = (length*(length+1))/2;

        return sum - missingSum;
    }

}
