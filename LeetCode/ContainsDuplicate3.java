/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.TreeSet;

/**
 *
 * @author itspa
 */
public class ContainsDuplicate3 {
//    Optimal Solution
//    public boolean containsNearbyAlmostDuplicate(final int[] nums, int kk, long t) {
//        if (nums.length < 2) return false;
//        if (kk == 0) return false;
//        TreeSet<Long> window = new TreeSet<Long>();
//        
//        for(int i=0;i<nums.length;i++) {
//
//            // check dup, window size <= kk right now
//            System.out.println(window.floor(nums[i]+t));
//        	if ( window.floor(nums[i] + t) !=null && 
//                        window.floor(nums[i]+t) >= nums[i]-t ) 
//                    return true;
//        	
//            window.add(new Long(nums[i]));
//            
//            
//            if (i >= kk) {
//                //remove one, the size has to be kk on the next fresh step
//            	window.remove(new Long(nums[i-kk]));
//            }
//        }
//        
//        return false;
//    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || nums.length ==1){
          return false;
        }
      
        for(int i = 0 ; i <nums.length -1; i++)
        {
            for(int j = i+1 ; j < nums.length; j++){
                int temp = nums[j] - nums[i];
                if(Math.abs((long)temp) <= t && Math.abs(j- i) <=k){
                    return true;
                }
            }
        }
    
        return false; 
    }
    public static void main(String[] args){
        ContainsDuplicate3 obj = new ContainsDuplicate3();
        int[] a = {2147483647,-1};
        int b = 1, c = 2147483647;
        System.out.println(obj.containsNearbyAlmostDuplicate(a, b, c));
    }
}
