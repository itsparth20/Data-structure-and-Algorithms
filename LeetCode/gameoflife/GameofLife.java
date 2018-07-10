package com.leetcode.gameoflife;
/*
289. Game of Life
https://leetcode.com/problems/game-of-life/description/
 */
public class GameofLife {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length < 1) return;
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[board.length][board[0].length];

        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                newBoard[i][j] = getUpdatedCell(board, i, j);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0;j<n; j++){
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private int getUpdatedCell(int[][] board, int i, int j){
        if(board[i][j] == 0){
            return checkDeadRuleAndReturnCellvalue(board, i, j);
        }else{
            return checkLiveRuleAndReturnCellvalue(board, i, j);
        }
    }

    private int checkDeadRuleAndReturnCellvalue(int[][] board, int i, int j){
        int live = getNumberOfLiveNeighbors(board, i, j);
        return live == 3 ? 1 : board[i][j];
    }

    private int checkLiveRuleAndReturnCellvalue(int[][] board, int i, int j){
        int live = getNumberOfLiveNeighbors(board, i, j);
        return live < 2 ? 0 : live < 4 ? 1 : 0;
    }

    private boolean greatedZero(int i){
        return i-1>=0;
    }

    private boolean smallerThenSize(int i, int size){
        return i+1<size;
    }

    private int getNumberOfLiveNeighbors(int[][] board, int i, int j){
        int live = 0;
        if(greatedZero(i)  && greatedZero(j)){ if(board[i-1][j-1] == 1) live++; }
        if(greatedZero(i)) { if(board[i-1][j] == 1) live++; }
        if(greatedZero(i) && smallerThenSize(j, board[0].length)){ if(board[i-1][j+1] == 1) live++; }
        if(greatedZero(j)) { if(board[i][j-1] == 1) live++; }
        if(smallerThenSize(j, board[0].length)) { if(board[i][j+1] == 1) live++; }
        if(smallerThenSize(i, board.length) && greatedZero(j)) { if(board[i+1][j-1] == 1) live++; }
        if(smallerThenSize(i, board.length)) { if(board[i+1][j] == 1) live++; }
        if(smallerThenSize(i, board.length) && smallerThenSize(j, board[0].length)) { if(board[i+1][j+1] == 1) live++; }
        return live;
    }
}
