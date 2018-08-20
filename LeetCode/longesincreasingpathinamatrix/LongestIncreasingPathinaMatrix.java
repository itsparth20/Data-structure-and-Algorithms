package com.leetcode.longesincreasingpathinamatrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
329. Longest Increasing Path in a Matrix

https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or
down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class LongestIncreasingPathinaMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) return 0;

        Position p;
        Set<Position> set;
        Map<Position, Integer> map = new HashMap<>();
        HasMax.max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                p = new Position(i, j);
                if(map.containsKey(p)){
                    continue;
                }
                set = new HashSet<Position>();
                helper(matrix, p, 1, Integer.MIN_VALUE, set, map);
            }
        }

        return HasMax.max;
    }

    private int helper(int[][] matrix, Position p, int i, int comeFrom, Set<Position> set, Map<Position, Integer> map){

        if(p.i < 0 || p.j < 0) return 0;
        if(matrix.length == p.i || matrix[p.i].length == p.j) return 0;
        if(matrix[p.i][p.j] <= comeFrom || set.contains(p)) return 0;
        if(map.containsKey(p)){
            return map.get(p);
        }
        int from = matrix[p.i][p.j];
        set.add(p);
        int n = 1;
        n = Math.max(helper(matrix, new Position(p.i, p.j+1), i+1, from, set, map)+1, n);
        n = Math.max(helper(matrix, new Position(p.i, p.j-1), i+1, from, set, map)+1, n);
        n = Math.max(helper(matrix, new Position(p.i-1, p.j), i+1, from, set, map)+1, n);
        n = Math.max(helper(matrix, new Position(p.i+1, p.j), i+1, from, set, map)+1, n);
        set.remove(p);
        HasMax.setMax(n);
        map.put(p, n);
        return n;
    }

    private static class Position{
        int i, j;
        public Position(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Position that = (Position) o;
            return i == that.i && j == that.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
        @Override
        public String toString(){
            return String.format("i:%d, j:%d", i, j);
        }
    }

    private static class HasMax{
        static int max=1;

        public static void setMax(int newMax){
            max = Math.max(max, newMax);
        }
    }
}


/*
More effective way

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length == 1 && matrix[0].length == 0) return 0;

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] visited = new int[row][column];

        int maxLen = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(visited[i][j]==0){
                    maxLen = Math.max(helper(i, j, Integer.MIN_VALUE, matrix, visited), maxLen);
                }
            }
        }
        return maxLen;
    }

    private int helper(int i, int j, int prev, int[][] matrix, int[][] visited){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= prev) return 0;

        if(visited[i][j] != 0){
            return visited[i][j];
        }
        int current = matrix[i][j];
        int maxLen = 0;

        maxLen = Math.max(helper(i, j+1, current, matrix, visited), maxLen);
        maxLen = Math.max(helper(i, j-1, current, matrix, visited), maxLen);
        maxLen = Math.max(helper(i+1, j, current, matrix, visited), maxLen);
        maxLen = Math.max(helper(i-1, j, current, matrix, visited), maxLen);

        visited[i][j] = maxLen + 1;

        return maxLen+1;
    }

}
 */