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
public class MoveZeroes {
    
    public int[] moveZeroes(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        
        for(int i = 0; i < nums.length-1; i++){
            int q = i+1;
            if(nums[i] == 0 && q!=nums.length){
                int j;
                for(j = i+1; j < nums.length; j++){
                    if(nums[j]==0){
                        
                    }
                    else{
                        int temp = nums[j];
                        nums[j] = 0;
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }
    public static void main(String[] args){
        MoveZeroes obj = new MoveZeroes();
        int[] a = {0,1,0,4,0,3,5};
        System.out.println(Arrays.toString(obj.moveZeroes(a)));
    }

//Optimal Solution
//public void moveZeroes(int[] nums) {
//        int j = 0;
//        for(int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//                j++;
//            }
//        }
//    }
}


