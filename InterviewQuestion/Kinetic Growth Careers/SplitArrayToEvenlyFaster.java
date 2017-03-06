/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KineticGrowth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author itspa
 */

class SplitArrayToEvenlyFaster {
    public static void main(String[] args){
       List<Integer> list = Arrays.asList(1,1,1,2,2,3);
        System.out.println(splitEvenly(list));
    }
    
    
    //Time Complexity: O(NlogN)
    public static List<List<Integer>> splitEvenly(List<Integer> integerList) {
        //create list to return two set
	List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        //sort the array in reverse order
        //Time Complexity: O(NlogN)
        Collections.sort(integerList, new Comparator<Integer>(){
            @Override
            public int compare(Integer t, Integer t1) {
                if(t<t1){
                    return 1;
                }
                return -1;
            }            
        });
        
        //use two variable calculate sum of two set.
        int list1Sum = 0, list2Sum = 0;
        //create empty set 1
        List<Integer> first = new ArrayList<>();
        //create empty set 2
        List<Integer> second = new ArrayList<>();
        //add this 2 empty set to list.
        list.add(first);
        list.add(second);
        
        //devide list to two set so that two set has minimum difference.
        //Time Complexity: O(N)
        for(int i : integerList){
            //if list two sum is larger then list one then add element to list one. 
            if(list1Sum < list2Sum){                
                List<Integer> l1 = list.get(0);
                l1.add(i);
                list.set(0, l1);
                list1Sum += i;
            }
            //else add element to list two.
            else{
                List<Integer> l2 = list.get(1);
                l2.add(i);
                list.set(1, l2);
                list2Sum += i;
            }
        }
//        System.out.println(Math.abs(list1Sum-list2Sum));
        return list;
    }
}
