package com.leetcode.kthsmallestelementinasortedmatrix;

import java.util.Arrays;

/*
378. Kth Smallest Element in a Sorted Matrix
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int[] arr = new int[matrix.length*matrix.length];
        int i = 0, j = 0, l = 0;
        for(i = 0; i < matrix.length; i++){
            for(j = 0; j < matrix[0].length; j++, l++){
                arr[l] = matrix[i][j];
            }
        }

        Arrays.sort(arr);
        return arr[k-1];
    }
}