/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprehand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

/**
 *
 * @author itspa
 */
public class SortHashMapBaseOnValue {
    
    
    public static void main(String[] args){
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        map.put("Apple", 2);
        map.put("Banana", 3);
        map.put("Orange", 4);
        map.put("Water", 1);
        
        List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
                        
        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
            
            @Override
            public int compare(Entry<String, Integer> t, Entry<String, Integer> t1) {
                return t1.getValue().compareTo(t.getValue());
                    
            }            
        });
        
        for(Entry<String, Integer> entry : list){
            System.out.println(entry);
        }
    }
}
