package com.leetcode.largestnumber;

/*
179. Largest Number
https://leetcode.com/problems/largest-number/description/
 */

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String arr[] = Arrays.stream(nums).mapToObj(String::valueOf).sorted((x, y) -> (y + x).compareTo(x + y)).toArray(String[]::new);
        return (arr[0].charAt(0) == '0') ? "0" : String.join("", arr);
    }

    @Test
    public void testLargestNumber() {
        assertEquals("321", new LargestNumber().largestNumber(new int[]{1, 2, 3}));
        assertEquals("0", new LargestNumber().largestNumber(new int[]{0,0}));
    }
}
