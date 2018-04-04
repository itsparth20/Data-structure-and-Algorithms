package com.leetcode.rotatearray;

import org.junit.Assert;
import org.junit.Test;

/*
189. Rotate Array
https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
 */

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    //Better performance
    public void rotateArrayElement(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) return;
        int[] tmp = new int[k];
        System.arraycopy(nums, len-k, tmp, 0, k);
        System.arraycopy(nums, 0, nums, k, len-k);
        System.arraycopy(tmp, 0, nums, 0, k);
    }

    @Test
    public void testRotate() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr1, 3);
        Assert.assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, arr1);
    }

    @Test
    public void testRotateWithTwoSize() {
        int[] arr1 = {1,2};
        rotate(arr1, 2);
        Assert.assertArrayEquals(arr1, arr1);
    }

    @Test
    public void testRotateWithFiveSize() {
        int[] arr1 = {1,2,3,4,5,6};
        rotate(arr1, 2);
        Assert.assertArrayEquals(new int[] {5,6,1,2,3,4}, arr1);
    }
}
