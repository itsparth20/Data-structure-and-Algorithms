/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author itspa
 */

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a = new ArrayList<Integer>();
        if(matrix.length == 0){
            return a;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i<=colEnd; i++){
                a.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            for(int j = rowStart; j<=rowEnd; j++){
                a.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if(rowStart<=rowEnd){
                for(int i = colEnd; i>=colStart; i--){
                    a.add(matrix[rowEnd][i]);
                }
               
            }
            rowEnd--;
            if(colStart<=colEnd){
                for(int j = rowEnd; j>=rowStart; j--){
                    a.add(matrix[j][colStart]);
                }
            }
            colStart++;
        }
        
        return a;
    }
    public static void main(String[] args){
        SpiralMatrix obj = new SpiralMatrix();
        int[][] a = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        System.out.println((obj.spiralOrder(a)));
    }
}
