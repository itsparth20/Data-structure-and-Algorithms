/*
62. Unique Paths
https://leetcode.com/problems/unique-paths/description/
*/
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 1;
        int[][] arr = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(i == 0 || j == 0){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }                
            }
        }
        return arr[m-1][n-1];
    }
}