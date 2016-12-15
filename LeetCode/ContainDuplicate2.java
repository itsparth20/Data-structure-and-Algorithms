/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author itspa
 */
public class ContainDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
    public static void main(String[] args){
        int[] a = {1,0,1,1};
        int b = 1;
        ContainDuplicate2 obj = new ContainDuplicate2();
        System.out.println(obj.containsNearbyDuplicate(a, b));
    }
}
