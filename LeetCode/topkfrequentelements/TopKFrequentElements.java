package com.leetcode.topkfrequentelements;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/*
347. Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/description/

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        Stream<Map.Entry<Integer, Long>> sorted = map.entrySet().stream().sorted(Comparator.comparing(x->x.getValue(), Comparator.reverseOrder()));
        return sorted.map(x->x.getKey()).limit(k).collect(Collectors.toList());

        /*
        List<Map.Entry<Integer, Long>> collect = map.entrySet().stream().sorted(Comparator.comparing(x -> x.getValue(), Comparator.reverseOrder())).collect(Collectors.toList());
        List<Integer> lst = new ArrayList<>();
        int i = 0;
        for (Map.Entry<Integer, Long> c : collect) {
            if (i == k) break;
            i++;
            lst.add(c.getKey());
        }
        return lst;
         */
    }

    @Test
    public void test() {
        int[] nums = {1,1,2,2,1,1,3};
        int k = 1;
        assertEquals(List.of(1), topKFrequent(nums, k));
    }



}
