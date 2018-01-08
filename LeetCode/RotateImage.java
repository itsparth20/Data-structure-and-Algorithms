/*
48. Rotate Image
https://leetcode.com/problems/rotate-image/description/
*/
class Solution {
    public void rotate(int[][] matrix) {
        
        int level = 0;
        int totalLevel = matrix[0].length/2;
        int last = matrix[0].length - 1;
        
        while(level < totalLevel){
            for(int i = level; i < last; i++){
                swap(matrix, level, i, i, last);
                swap(matrix, level, i, last, last-i+level);
                swap(matrix, level, i, last-i+level, level);                     
            }
            level++;
            last--;
        }
    }
    public void swap(int[][] matrix, int i, int j, int k, int l){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = temp;
        // matrix[i][j] = matrix[i][j] ^ matrix[k][l];
        // matrix[k][l] = matrix[i][j] ^ matrix[k][l];
        // matrix[i][j] = matrix[i][j] ^ matrix[k][l];
    }
}