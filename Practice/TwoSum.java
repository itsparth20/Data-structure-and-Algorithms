/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Given  an array of integers and a target, return a pair of indices where the corresponding values in the array add up to the target.

Input: Array of Integers, Target Integer
Output: Two element Array of Integers
Example
Input: [1, 6, -5, 7, 3], -2      =>	Output: [2,4]
Input: [1, 9, 10], 8			=>	Output: [-1,-1]
Constraints
Time Complexity: O(N)
Auxiliary Space Complexity: O(N)

If the target integer is not found return [-1, -1].

Values of the array can be positive or negative integers.
 */


import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author itspa
 */
public class TwoSum {
    public static void main(String[] args){
        int arr[] = {1,6,-5,7,3};
        int target = -2;
        
        int b[] =twoElementofArr(arr, target).clone();
    }

    private static int[] twoElementofArr(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            }
            int complement = target - nums[i];
            map.put(complement, i);
        }
        return new int[] {-1,-1};
    }
}
