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
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i+=2){
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
        SingleNumber obj = new SingleNumber();
        int[] a = {2,3,2};
        System.out.println(obj.singleNumber(a));
    }
}
