package com.leetcode.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3, 1, 1};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int count = 0, num = 0;

        for (int i : nums) {
            if (count == 0) {
                num = i;
            }
            if (num != i) {
                count--;
            } else {
                count++;
            }
        }
        return num;
    }

}
