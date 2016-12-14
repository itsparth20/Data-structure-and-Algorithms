/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
package LeetCode;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i+=3){
            if(i+1 != nums.length){
                if(nums[i] != nums[i+1]){
                    return nums[i];
                }
            }else{
                return nums[i];
            }
        }
        return 0;
    }
    public static void main(String[] args){
        SingleNumber2 obj = new SingleNumber2();
        int[] a = {2,3,2,2};
        System.out.println(obj.singleNumber(a));
    }
}
