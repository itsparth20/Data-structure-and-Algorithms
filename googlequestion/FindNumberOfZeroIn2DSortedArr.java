/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhiteBoardPracticeTree;

/**
 *
 * @author itspa
 */

/*
Given a matrix with N rows and N columns where elements in the matrix can be either 1 or 0 and each row and column are sorted in ascending order, find the number of 0’s.

Input: Matrix of elements with values either 0 or 1
Output: An integer which is the count of all 0’s in the matrix
Example
Input:    [[0, 0, 0, 1],
		[0, 0, 1, 1],
		[0, 1, 1, 1],
		[0, 1, 1, 1]]
=>	Output: 7
Constraints
Time Complexity: O(N)
Auxiliary Space Complexity: O(1)

*/
public class FindNumberOfZeroIn2DSortedArr {
    public static void main(String[] args){
        int[][] arr = {
                    {0,0,0,1},
                    {0,0,1,1},
                    {0,1,1,1},
                    {0,1,1,1}
                    };
        
        System.out.println(findNumberOfZeros(arr));
    }

    private static int findNumberOfZeros(int[][] arr) {
        int count = 0, i=0, j = arr[0].length-1;
        while(j>0){
            while(arr[i][j] == 1){
                j--;
            }
            i++;
            count += j+1;            
        }
        
        while(i < arr.length && arr[i][j] == 0){
            i++;
            count++;
        }
        
        return count;
    }
}
