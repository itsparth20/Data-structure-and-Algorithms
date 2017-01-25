/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Arrays;

/**
 *
 * @author itspa
 */
public class ReverseWordsString {
    public static void main(String[] args){
        String s = "";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {        
        String[] arr = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = arr.length-1; i>0; i--){
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
