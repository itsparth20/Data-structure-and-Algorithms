/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author itspa
 */
public class UniqueWordAbbreviation {
    Map<String, String> map;
    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap();
        for (String s: dictionary) {
            String abb = abbreviate(s);
            if (map.containsKey(abb)) {
                if (!map.get(abb).equals(s)) {
                    map.put(abb, "");
                }
            } else {
                map.put(abb, s);
            }
        }
    }

    private String abbreviate(String s) {
        if (s.length() <= 2) {
            return s;
        }
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        int len = s.length() - 2;
        return ""+ first + len + last;
    }

    public boolean isUnique(String word) {
        String abb = abbreviate(word);
        if(!map.containsKey(abb)) {
            return true;
        } else {
            if (map.get(abb) == null) {
                return false;
            } else if (map.get(abb).equals(word)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public static void main(String[] args){
        String[] a = {"dea1", "doo1", "cake", "card"};
        UniqueWordAbbreviation obj = new UniqueWordAbbreviation(a);
        for(int i = 0; i<a.length; i++){
            System.out.println(obj.isUnique(a[i]));
                
        }
        
    }
}
