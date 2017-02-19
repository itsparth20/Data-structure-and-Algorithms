/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TargetPractice;

/**
 *
 * @author itspa
 */

/*
Rat Path
Given a matrix of bits (values 0 and 1), a rat must find a path from index [0][0] to [n-1][n-1]. The rat can only travel to the right or down, and can only travel on 0 values.

Input: 	Matrix of elements with values either 0 or 1
Output: Array of two-item arrays indicating the path.
Example  // this.followers = 47;


Input:    [[0, 0, 0, 1],
		[0, 1, 0, 1],
		[0, 1, 0, 0],
		[0, 0, 1, 0]]
=> 		[[0, 0], [0, 1], [0, 2], [1, 2], [2, 2], [2, 3], [3, 3]]

Constraints
Time Complexity: O()
Auxiliary Space Complexity: O()
If not path found, return the following path: [[-1,-1]]

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatPathFindPath {
    
    public static ArrayList<List<Integer>> result;
    public static void main(String args[]){
        int[][] input = {{0, 0, 0, 0},
                         {0, 1, 0, 1},
                         {0, 1, 0, 0},
                         {0, 0, 1, 0}
                        };
        result = new ArrayList<List<Integer>>();        
        result.add(Arrays.asList(-1, -1));
        ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
        findPath(input, 0, 0, temp);        
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    private static boolean findPath(int[][] input, int i, int j, ArrayList<List<Integer>> temp) {        
        temp.add(Arrays.asList(i, j));
        if(i>input.length-1 || j>input[0].length-1 || input[i][j] == 1){
            return false;
        }
        
        if(i == input.length-1 && j == input[0].length -1){
            result = temp;            
            return true;            
        }
        
        return findPath(input, i, j+1, (ArrayList<List<Integer>>) temp.clone()) || findPath(input, i+1, j, (ArrayList<List<Integer>>) temp.clone());
    }
}
