package yelp;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static List<String> topColor(List<List<String>> image) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(List<String> list : image){
            for(String s : list){
                if(map.containsKey(s)){
                    map.put(s, map.get(s)+1);
                }else
                    map.put(s,1);
            }
        }
        
        List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
            
            @Override
            public int compare(Entry<String, Integer> t, Entry<String, Integer> t1) {
                return t1.getValue().compareTo(t.getValue());
                    
            }            
        });
        
        int s = 0;
        for(Entry<String, Integer> entry : list){
            s = entry.getValue();
            break;
        }
        
        int p =0;
        List<String> data = new ArrayList<String>();
        for(Entry<String, Integer> entry : list){
            p = entry.getValue();
            if(p==s)
                data.add(entry.getKey());
        }
        
        Collections.sort(data);
        
        
        return data;
    }

    public static void main(String[] args) throws Exception{
    	
    	List<List<String>> image = new ArrayList<List<String>>();
    	
    	image.add(Arrays.asList("red","blue","black"));
    	image.add(Arrays.asList("red","blue","black"));
    	image.add(Arrays.asList("red","blue","black"));
    	System.out.println(topColor(image));
    }
}