package com.leetcode.searchtwodmatrixtwo;

//240. Search a 2D Matrix II
//https://leetcode.com/problems/search-a-2d-matrix-ii/description/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix.length-1;
        while(y>=0 && x < matrix[0].length){
            int val = matrix[y][x];
            if(val < target){
                x++;
            }else if(val > target){
                y--;
            }else{
                return true;
            }
        }
        return false;
    }
}