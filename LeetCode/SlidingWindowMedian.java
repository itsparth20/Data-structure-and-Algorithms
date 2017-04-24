/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
 
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */

package practiceProblem.leetcode;

import java.util.Arrays;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k1 = 4;
		int[] arr2 = {2147483647,2147483647};
		int k2 = 2;
//		System.out.printlnj(Arrays.toString(medianSlidingWindow(arr1, k1)));
		System.out.println(Arrays.toString(medianSlidingWindow(arr2, k2)));
	}

	public static double[] medianSlidingWindow(int[] nums, int k) {
		
		if(k<= 0){
			return new double[0];
		}
		int size = k-1;
		
		double[] median = new double[nums.length-size];
		for(int i = 0, j = 0; i<nums.length-size; i++, j++){
			int[] sortWindow = new int[k];
			System.arraycopy(nums, i, sortWindow, 0, k);
			Arrays.sort(sortWindow);
			if(k%2 != 0)				
				median[j] = sortWindow[k/2];				
			else{
				int oneIndex = (k/2)-1;
				int twoIndex = k/2;
				double x = sortWindow[oneIndex];
				double y = sortWindow[twoIndex];
				double sum = x+y;				
				median[j] = sum/2;
			}	
		}		
		return median;
	}

}
