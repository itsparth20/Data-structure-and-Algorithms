/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Number of Ones
Given a sorted bit array (values of 0, and 1) determine the number of 1’s in the array.

Input: Array of elements with values belong to the set S : { 0, 1 }
Output: Integer
Example
Input: [0, 0, 0, 1, 1, 1]	=>	Output: 3
Input: [0, 0, 0, 0]		=>	Output: 0
Constraints
Time Complexity: O(logN)
Auxiliary Space Complexity: O(1)

A linear search is not acceptable for runtime.

 */


/**
 *
 * @author itspa
 */
public class NumberofOnes {
    public static void main(String[] args) {
        int a[] = {0};
        
        System.out.println(countOnes(a));
  }

    private static int countOnes(int[] a) {
        int len = a.length-1;
        int count = 0;
        if(len >= 0 && a[len] == 0){
            return count;
        }
        int index = search(a);
        count = len-index+1;
        return count;
    }

    private static int search(int[] a) {
        int high = a.length-1;
        int low = 0;
        while(high>=low){
            int mid = (low+high)/2;
            if(mid != a.length-1 && 0 == a[mid] && 1 == a[mid+1]){
                return mid+1;
            }
            if(a[mid] == 0){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    
}
