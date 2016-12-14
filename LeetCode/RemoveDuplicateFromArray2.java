package LeetCode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspa
 */

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
*/
public class RemoveDuplicateFromArray2 {
    public int removeDuplicates(int[] nums) {
        int max = 2, total = 0;
        if(nums.length == 0){
            return total;
        }
        int b = nums[0];
        int[] a = new int[nums.length];
        int ct = 0;
        for(int i = 0; i<nums.length; i++){
            if(b == nums[i]){
                if(max != 0){
                    max--;
                    total++;
                    a[ct] = nums[i];
                    ct++;
                }
            }
            else{
                max=1;
                total++;
                b=nums[i];
                a[ct] = nums[i];
                ct++;
                
            }
        }
        
        return total;
    }
    
    public static void main(String[] args){
        RemoveDuplicateFromArray2 obj = new RemoveDuplicateFromArray2();
        int[] a = {1,1,1,2,2,3,3,3,4};
        System.out.println(obj.removeDuplicates(a));
    }
}

//Optimal Solution.
//public int removeDuplicates(int[] nums) {
//    int i = 0;
//    for (int n : nums)
//        if (i < 2 || n > nums[i-2])
//            nums[i++] = n;
//    return i;
//}

