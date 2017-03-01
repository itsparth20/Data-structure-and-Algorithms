/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accel;

import java.util.Arrays;

/**
 *
 * @author itspa
 */

/*
If Nums = [1,2,3] and Maxes = [2,4], then there is 2 element less and equal to 2 and 3 element are less and equal to 4. so out output should be [2,3]
Example: nums = [1,2,4,2] Maxes = [3,5]
    We are given nums and Maxes 
    for Maxes 3 we have two element in Nums 1 & 2
    for Maxes 5 we have four element in Nums 1, 2, 2, 4
        So function should return [2,4]
*/
public class CountTotalNumberOfLessValue {
    public static void main(String[] args){
        int[] arr = {2,10,5,4,8};
        int[] max = {3,1,7,8};
        int[] a = counts(arr, max);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }
    static int[] counts(int[] nums, int[] maxes) {
        int[] max = new int[maxes.length];
        Arrays.sort(nums);
        
        int i = 0, j =0, count = 0;
        while(j< max.length){
            for(i = 0; i<nums.length; i++){
                if(nums[i] <= maxes[j]){
                    max[j]++;
                }
                else{
                    j++;
                    break;
                }
            }
        }
        return max;
    }
}
