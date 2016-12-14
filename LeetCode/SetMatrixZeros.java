/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
       int m = matrix.length, n = matrix[0].length, k = 0;
        // First row has zero?
        while (k < n && matrix[0][k] != 0) 
            ++k;
        // Use first row/column as marker, scan the matrix
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; ++j)
                if (matrix[i][j] == 0)
                    matrix[0][j] = matrix[i][0] = 0;
        
        // Set the zeros
        for (int i = 1; i < m; i++)
            for (int j = n - 1; j >= 0; --j)
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
        // Set the zeros for the first row
        if (k < n) 
            Arrays.fill(matrix[0], 0); 

//Print Array
//        for(int i = 0; i < m; i++)
//        {
//           for(int j = 0; j < n; j++)
//           {
//              System.out.printf("%5d ", matrix[i][j]);
//           }
//           System.out.println();
//        }
    }
    
    public static void main(String[] args){
        SetMatrixZeros obj = new SetMatrixZeros();
        int[][] a = new int[][]{
            {1,1,2},
            {0,4,5},
            {6,7,1}
        };
        obj.setZeroes(a);
    }
}
