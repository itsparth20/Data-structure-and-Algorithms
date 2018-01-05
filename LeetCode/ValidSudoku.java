/*
https://leetcode.com/problems/valid-sudoku/description/
36. Valid Sudoku
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int p=0; p < board.length; p++){
            Set<Character> set = new HashSet<>();
            for(int i= 0; i < 9; i++){
                if(board[p][i] != '.' && set.contains(board[p][i]) ) return false;
                set.add(board[p][i]);
            }
            set = new HashSet<>();
            for(int i= 0; i < 9; i++){
                if(board[i][p] != '.' && set.contains(board[i][p]) ) return false;
                set.add(board[i][p]);
            }
        }
        for(int i =0; i < board.length; i += 3){
            for(int j = 0; j < board.length; j += 3){
                if (chechSubBoard(board, i, j)) return false;
            }
        }
        return true;
    }
    public boolean chechSubBoard(char[][] board, int a, int b){
        Set<Character> set = new HashSet<>();
        for(int i = a; i < a+3; i++){
            for(int j = b; j < b+3; j++){
                if(board[i][j] != '.' && set.contains(board[i][j]) ) return true;
                set.add(board[i][j]);
            }
        }
        return false;
    }
}