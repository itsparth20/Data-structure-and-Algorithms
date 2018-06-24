package com.leetcode.slidingwindowmaximum;

//https://leetcode.com/problems/sliding-window-maximum/description/
//239. Sliding Window Maximum

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0){
            return nums;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        int newLength = nums.length-k+1;
        int[] windowsArr = new int[newLength];
        for(int i = 0; i < k; i++){
            queue.offer(nums[i]);
        }

        for(int i = 0; i < newLength; i++){
            windowsArr[i] = queue.peek();
            queue.remove(nums[i]);
            if(i+k < nums.length){
                queue.offer(nums[i+k]);
            }
        }
        return windowsArr;
    }
}
