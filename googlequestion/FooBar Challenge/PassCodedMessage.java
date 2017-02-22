/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author itspa
 * 
 * You have L, a list containing some digits (0 to 9). Write a function answer(L) which finds the largest number that can be made from some or 
 * all of these digits and is divisible by 3. If it is not possible to make such a number, return 0 as the answer. 
 * L will contain anywhere from 1 to 9 digits.  The same digit may appear multiple times in the list, but each element in the list may only be used once.
 * 
 * Inputs:
    (int list) l = [3, 1, 4, 1]
Output:
    (int) 4311

Inputs:
    (int list) l = [3, 1, 4, 1, 5, 9]
Output:
    (int) 94311
 */
 
public class PassCodedMessage {
    public static void main(String[] args){
//        int[] arr = {3,1,4,1,5,9};
//        System.out.println(answer(arr));
        
        int[] arr1 = {2,2,1};
        System.out.println(answer(arr1));        
    }
    public static int answer(int[] l) {         
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int sum =0;
        Arrays.sort(l);
        for(int i = 0; i<l.length; i++){
            if(l[i] % 3 == 0){
                list0.add(l[i]);
            }else if(l[i] % 3 == 1){
                list1.add(l[i]);
            }else{
                list2.add(l[i]);
            }
            sum += l[i];
        }
        
        if(sum%3==0){
            StringBuilder strNum = new StringBuilder();
            for(int i = l.length-1; i >= 0; i--)
            {
                strNum.append(l[i]);
            }
            return Integer.parseInt(strNum.toString());            
        }else if(sum%3 == 1){            
            if(list1.size()>0){
                list1.remove(0);
            }else if(list2.size() >= 2){
                list2.remove(1);
                list2.remove(0);                
            }else{
                return -1;
            }
        }else if(sum%3 == 2){            
            if(list2.size()>0){
                list2.remove(0);
            }else if(list1.size() >= 2){
                list1.remove(1);
                list1.remove(0);
                
            }else{
                return -1;
            }
        }
        list0.addAll(list1);
        list0.addAll(list2);
        StringBuilder strNum = new StringBuilder();
        Collections.sort(list0);
        for(int i = list0.size()-1; i >= 0; i--)
        {
            strNum.append(list0.get(i));
        }
        return strNum.length() > 0 ? Integer.parseInt(strNum.toString()) : 0;
    }
}
