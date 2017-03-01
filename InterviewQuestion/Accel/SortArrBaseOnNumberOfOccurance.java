/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 */
public class SortArrBaseOnNumberOfOccurance {
    public static void main(String[] args){
        int[] arr = {5,3,1,2,2,4};
        customSort(arr);
    }
    static void customSort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        Map<Integer, Integer> occurance = new HashMap<Integer,Integer>();
        for(int i =0; i<arr.length; i++){
            list.add(arr[i]);
            if(occurance.containsKey(arr[i])){
                occurance.put(arr[i], occurance.get(arr[i])+1);
            }
            else{
                occurance.put(arr[i], 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : occurance.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            ArrayList<Integer> listTemp = new ArrayList<>();
            if(map.containsKey(entry.getValue())){
                
                listTemp = map.get(entry.getValue());
                listTemp.add(entry.getKey());
            }else{
                listTemp.add(entry.getKey());
                
            }
            map.put(entry.getValue(), listTemp);
        }
        
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
//            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            ArrayList<Integer> listTemp = map.get(entry.getKey());
            Collections.sort(listTemp);
            for(int value : listTemp){
                for(int i = 0; i<entry.getKey(); i++){
                    System.out.println(value);
                }
            }
        }
  
    }    
}
