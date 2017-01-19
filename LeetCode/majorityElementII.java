/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author itspa
 */
public class majorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<Integer ,Integer>();
        int maxOcc = nums.length/3;
        List<Integer> ll = new ArrayList<Integer>();
        for(int num : nums)
        {
            if(!map.containsKey(num))
            {
                map.put(num ,1);
                if(map.get(num)>maxOcc){
                   ll.add(num);
                }
            }
            else{
                map.put(num , map.get(num)+1);
                if(!ll.contains(num)){
                    if(map.get(num)>maxOcc){
                        ll.add(num);
                    }
                }
            }
            
        }
        
        return ll;
    }
    
    public static void main(String[] args){
        int a[] = {2,2};
        
        System.out.print(majorityElement(a));
    }
}
