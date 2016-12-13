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
public class SearchForRange {
    public int[] searchRange(int[] nums, int target)
    { 
        // int i=0;
        boolean found = false;
        int[] position = {-1, -1};
        if(nums.length < 0){
            return position;
        }
        for(int i=0; i<nums.length; i++){
            if(target == nums[i]){
                if(!found){
                    found=true;
                    position[0] = i;
                    position[1] = i;
                }
                else{
                    position[1] = i;
                }
            }
        }
        return position;
    }
    public static void main(String[] args){
        SearchForRange obj = new SearchForRange();
        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(obj.searchRange(a, target)));
    }
}
