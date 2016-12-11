/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

/**
 *
 * @author itspa
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++){
//        System.out.print(strs[i]);
//        System.out.println(" "+prefix);
//        System.out.println(strs[i].indexOf(prefix));
        
        while (strs[i].indexOf(prefix) != 0) {
            System.out.println("1. "+prefix);
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
    }
    
}
