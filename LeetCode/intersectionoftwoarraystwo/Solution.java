package com.leetcode.intersectionoftwoarraystwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/*
350. Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

 */

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int x : nums1){
            map1.merge(x, 1, (z,y)->z+y);
        }
        for(int x : nums2){
            map2.merge(x, 1, (z,y)->z+y);
        }

        List<Integer> lst = new ArrayList<>();
        int l = 0;
        for(Integer x : map1.keySet()){
            if(map2.containsKey(x)){
                l = map1.get(x) > map2.get(x) ? map2.get(x) : map1.get(x);
                IntStream.range(0, l).forEach(z -> lst.add(x));
            }
        }
        return convertIntegerToInt(lst);

    }
    private int[] convertIntegerToInt(List<Integer> lst){
        int[] arr = new int[lst.size()];
        IntStream.range(0, lst.size()).forEach(i -> arr[i] = lst.get(i));
        return arr;
    }
}