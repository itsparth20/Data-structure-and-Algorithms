/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class FindFirstPositiveInt {
    public static int firstMissingPositive(int[] nums) {
        if(nums.length != 0){
        Arrays.sort(nums);
        int temp = 1;
        
        for(int i = 0; i<nums.length; i++){
            if(temp == nums[i]){
                temp++;
            }
        }
        return temp;
    }
    return 1;
    }
    public static void main(String[] args){
        int[] nums = {2,3};
    System.out.println(firstMissingPositive(nums));
    }
}
