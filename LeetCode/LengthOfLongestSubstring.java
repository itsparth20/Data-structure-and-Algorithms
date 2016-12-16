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
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
    }
    public static void main(String[] args){
    String n = "abcbbz";
    LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
    System.out.println(obj.lengthOfLongestSubstring(n));
    }
}
