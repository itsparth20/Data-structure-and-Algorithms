/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

/**
 *
 * @author itspa
 */
public class GenerateMatrixWithNoSameTypeofElement {
    public static void main(String[] args){
        int a[][] = {
            {1,2,1,1},
            {1,1,4,2},
            {1,2,4,2},
            {3,1,2,3}
        };
        
        System.out.println(validMatrix(a));
    }

    private static boolean validMatrix(int[][] a) {
        int row = a.length;
        int col = row;
        int i=0,j = row-1;
        while(i<row){
            j = row-1;
            while(j>=0){
                if(j >= 2){
                    if(a[i][j] == 1 && a[i][j-1] == 1 && a[i][j-2] == 1){
                        return false;
                    }
                    if(a[i][j] == 2 && a[i][j-1] == 2 && a[i][j-2] == 2){
                        return false;
                    }
                    if(a[i][j] == 3 && a[i][j-1] == 3 && a[i][j-2] == 3){
                        return false;
                    }
                    if(a[i][j] == 4 && a[i][j-1] == 4 && a[i][j-2] == 4){
                        return false;
                    }
                    if(a[i][j] == 4 && a[i][j-1] == 4 && a[i][j-2] == 4){
                        return false;
                    }
                }
                if(i >= 2){
                    if(a[i][j] == 1 && a[i-1][j] == 1 && a[i-2][j] == 1){
                        return false;
                    }
                    if(a[i][j] == 2 && a[i-1][j] == 2 && a[i-2][j] == 2){
                        return false;
                    }
                    if(a[i][j] == 3 && a[i-1][j] == 3 && a[i-2][j] == 3){
                        return false;
                    }
                    if(a[i][j] == 4 && a[i-1][j] == 4 && a[i-2][j] == 4){
                        return false;
                    }
                    if(a[i][j] == 4 && a[i-1][j] == 4 && a[i-2][j] == 4){
                        return false;
                    }
                }
                j--;
            }
            i++;
        }
        
        return true;
    }
}
