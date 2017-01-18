/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Input Format

First line of the input has an integer .  cases follow. 
Each test case begins with an integer . In the next line,  integers follow representing the elements of array .

Constraints

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 *
 * @author itspa
 */
public class theMaximumSubarray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 0; i< testCase; i++){
            int arraySize = sc.nextInt();
            int[] arr = new int[arraySize];
            for(int j = 0; j<arraySize; j++){
                arr[j] = sc.nextInt();
            }
            int continuesMax = 0;
            int nonContinueMaxTemp = Integer.MIN_VALUE;
            int nonContinueMax = 0;
            
            for(int x : arr){
                nonContinueMax = Math.max(x, x+nonContinueMax);
                nonContinueMaxTemp = Math.max(nonContinueMax, nonContinueMaxTemp);
                int temp = continuesMax+x;
                if(temp > continuesMax){
                    continuesMax = temp;
                }  
            }
            Arrays.sort(arr);
            if(arr[arr.length-1] <= 0){
                continuesMax = arr[arraySize-1];
            }
            System.out.println(nonContinueMaxTemp + " " + continuesMax);
            
        }
    }
}
