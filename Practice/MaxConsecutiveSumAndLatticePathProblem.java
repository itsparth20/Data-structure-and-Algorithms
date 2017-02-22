/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeWork;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Parth
 * 
 *  Problem 1: Max Consecutive Sum                                    
 *                                                                    
 *  Prompt:    Given an array of integers find the sum of consecutive    
 *             values in the array that produces the maximum value.      
 *                                                                    
 *  Input:     Unsorted array of positive and negative integers          
 *  Output:    Integer (max consecutive sum)                             
 *                                                                    
 *  Example:   input = [6, -1, 3, 5, -10]                               
 *             output = 13 (6 + -1 + 3 + 5 = 13)                        
 *                                                                    
 *  Time Complexity: O(n)                                             
 *  Auxiliary Space Complexity: O(1)                                  
 *
 *
 * 
 *  Problem 2: Lattice Paths (Dynamic Programming Approach)              
 *                                                                       
 *  Prompt:    Count the number of unique paths to travel from the top left 
 *             to the bottom right of a lattice of squares.                 
 *                                                                       
 *  Input:     An interger N (which is the size of the lattice)             
 *  Output:    An interger (which represents the number of unique paths)    
 *                                                                       
 *  Example:   input: 2 
 *            
 *             (2 x 2 lattice of squares) 
 *              __ __
 *             |__|__|
 *             |__|__|
 *
 *             output: 6 (number of unique paths from top left corner to bottom 
 *                     right)
 *                                                                       
 *  Notes:     What is the time and auxilliary space complexity of your solution?   
 *                                                                       
 *             When moving through the lattice, you can only move either down or 
 *             to the left.                                                
 *                                                                       
 *             You did this problem before with recursion. Try implementing it 
 *             now with dynamic programming!                               
 *                                                                       
 *  Resources:                                                
 *    1: https://projecteuler.net/problem=15                             
 *    2: https://en.wikipedia.org/wiki/Lattice_path 
 *                                                                    
 */
public class MaxConsecutiveSumAndLatticePathProblem {
    private static Map<String,Integer> matrix;
    public static void main(String[] args){
        int arr[] = {6, -7, 3, 5, -10};
        System.out.println("Max Consecutive Sum: "+maxConsecutiveSum(arr));
        System.out.println("Lattice Path: "+latticePath(3));
    }
    
// Time Complexity: O(n)
// Auxiliary Space Complexity: O(1)
    private static int maxConsecutiveSum(int[] arr) {
        int max =0;
        int sum =0;
        for(int i = 0; i< arr.length; i++){
            sum += arr[i];
            if( sum < 0 ){
                sum = 0;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

// Time Complexity: O(n)
// Auxiliary Space Complexity: O(n)
// Dynamic Programming Solution
    private static int latticePath(int n) {
        matrix = new HashMap<String,Integer>();
        latticeTotalPath(n,0,0);
        return matrix.get("00");
    }

    private static int latticeTotalPath(int n, int i, int j) {
        if(i>n || j>n){
            return 0;
        }
        if(i == n && j ==n){
            return 1;
        }
        String ij = String.valueOf(i)+String.valueOf(j);
        if(matrix.containsKey(ij)){
            return matrix.get(ij);
        }
        
        matrix.put(ij, latticeTotalPath(n, i+1, j) + latticeTotalPath(n, i, j+1));
        return matrix.get(ij);
    }
    
    
}
