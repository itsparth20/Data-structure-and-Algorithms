/*
79. Word Search
https://leetcode.com/problems/word-search/description/
*/
class Solution {
    public boolean exist(char[][] board, String word) {        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && helper(word, board, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(String word, char[][] board, int i, int j, int k){
        
        if(k >= word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(k)) return false;
        char c = board[i][j];
        board[i][j] = '#';
        if(helper(word, board, i+1, j, k+1) || helper(word, board, i-1, j, k+1) || helper(word, board, i, j+1, k+1) || helper(word, board, i, j-1, k+1)){
            return true;
        }
        board[i][j] = c;
        return false;
    }
}