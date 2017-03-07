package KineticGrowth;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author itspa
 */
class SplitArrayToEvenly {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(37,28, 16, 44, 36, 37, 43, 50, 22, 13, 28, 41, 10, 14, 27, 41, 27, 23, 37, 12, 19, 18, 30, 33, 31, 13, 24, 18, 36, 30, 3, 23, 9, 20);
        System.out.println(splitEvenly(list));
    }
    
    
    //Time Complexity: O(N^2)
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
        //create empty list 1
        List<Integer> first = new ArrayList<>();
        //create empty list 2
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
        
        //if defference is greater then 1 then we can reduce that deffrence. so check the defference.
        if(Math.abs(list1Sum-list2Sum)>1){
            
            //take the half of the defference because we want to remove some value from
            //list 1 and add that value to list 2
            int deff = Math.abs(list1Sum-list2Sum)/2;
            
            //Use boolean variable to check that did we get minimum difference.
            boolean match = false;
            
            //if Sum of the first list is greater then, we have to take greater value from first list
            //and replace one value with second list so we can get minimum difference. 
            if(list1Sum>list2Sum){
                
                //run while loop till we did not get minimum difference and deff is greater then 1.
                //Time Complexity: O(n^2)
                while(!match && deff>1){                    
                    for(int i : first){
                        
                        //if second list contain some value that make difference between two set equal to zero or
                        //closer to zero then exchange that value with value of first list.
                        if(second.contains(i-deff)){
                            //we found match so we make match equal to true.
                            match = true;                            
                            
                            //second list contain value that help us to achive minimum difference 
                            //so exchange value of first and second
                            second.remove(Integer.valueOf(i-deff));                            
                            first.remove(Integer.valueOf(i));
                            second.add(i);
                            first.add(i-deff);
                            
                            //Change sum of two list
                            list1Sum-= deff;
                            list2Sum+= deff;
                            
                            //break loop because we found minimum difference
                            break;
                        }
                    }
                    //if deff is not posible to achive in another list then decrement deff by one.
                    deff--;
                }
                
                //if we did not found the perfect match in list then we need to increment deff by 1 every time
                //so we are taking temp variable
                int temp = 1;
                //set deff value otherwise deff will be 1.
                deff = Math.abs(list1Sum-list2Sum)/2;
                
                //run while loop till we did not get minimum difference and
                //temp is less then or equal to deff
                //Time Complexity: O(N^2)
                while(!match && temp <= deff){
                    for(int i:first){
                        //if second list contain some value that make difference between two set equal to zero or
                        //closer to zero then exchange that value with value of first list.
                        if(second.contains(i-temp-deff)){
                            //we found match so we make match equal to true.
                            match = true;
                            
                            //second list contain value that help us to achive minimum difference 
                            //so exchange a value of first and second
                            second.remove(Integer.valueOf(i-temp-deff));
                            first.remove(Integer.valueOf(i));
                            second.add(i);
                            first.add(i-temp-deff);
                            
                            //Change sum of two list
                            list1Sum-= deff+temp;
                            list2Sum+= deff+temp;
                            
                            //break loop because we found minimum difference
                            break;
                        }
                    }
                    //if deff+temp is not posible to achive in another list then increment temp by 1.
                    temp++;
                }
            }
            
            //if Sum of the second-list is greater then we have to take greater value from second list
            //and replace one value with first list so we can get minimum difference. 
            else if(list1Sum<list2Sum){  
                //run while loop till we did not get minimum difference and deff is greater then 1.
                //Time Complexity: O(N^2)
                while(!match && deff>1){
                    
                    for(int i : second){
                        
                        //if first list contain a value that make difference between two set equal to zero or
                        //closer to zero then exchange that value with value of second list.
                        if(first.contains(i-deff)){
                            //we found match so we make match equal to true.
                            match = true;
                            
                            //first list contain a value that help us to achieve minimum difference 
                            //so exchange a value of first and second
                            first.remove(Integer.valueOf(i-deff));
                            second.remove(Integer.valueOf(i));
                            first.add(i);
                            second.add(i-deff);
                            
                            //Change sum of two list
                            list1Sum+= deff;
                            list2Sum-= deff;
                            
                            //break loop because we found minimum difference
                            break;
                        }
                    }
                    //if deff is not posible to achive in another list then decrement deff by one.
                    deff--;
                }
                
                //if we did not found the perfect match in list then we need to increment deff by 1 every time
                //so we are taking temp variable
                int temp = 1;
                
                //set deff value otherwise deff will be 1.
                deff = Math.abs(list1Sum-list2Sum)/2;
                
                //run while loop till we did not get minimum difference and
                //temp is less then or equal to deff.
                //Time Complexity: O(N^2)
                while(!match && temp <= deff){                    
                    for(int i:second){
                        
                        //if first list contain a value that make difference between two set equal to zero or
                        //closer to zero then exchange that value with value of second list.
                        if(first.contains(i-temp-deff)){
                            
                            //we found match so we make match equal to true.
                            match = true;
                            
                            //first list contain a value that help us to achieve minimum difference 
                            //so exchange a value of first and second
                            first.remove(Integer.valueOf(i-temp-deff));
                            second.remove(Integer.valueOf(i));
                            first.add(i);
                            second.add(i-temp-deff);
                            
                            //Change sum of two list
                            list1Sum+= deff+temp;
                            list2Sum-= deff+temp;
                            //break loop because we found minimum difference
                            break;
                        }
                    }
                    //if temp+deff is not posible to achive in another list then increment temp by one.
                    temp++;
                }
            }            
        }
        //print difference of two set.
//        System.out.println(Math.abs(list1Sum-list2Sum));
        
        return list;
    }   
}