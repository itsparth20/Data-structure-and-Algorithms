/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author itspa
 */
public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        int counter = 0;
        Stack lifo = new Stack();
        
        StringBuilder s1= new StringBuilder();
        int len = S.length()-1;
        for(int i =0; i<=len; i++){
            if('-' != S.charAt(i)){
                lifo.push(new Character(S.charAt(i)));
            }
        }
        while(!lifo.empty()){
            s1.append(lifo.pop());
            counter++;
                if(counter == K && !lifo.empty()){
                s1.append('-');
                counter = 0;
                }
        }
        return s1.reverse().toString().toUpperCase();
    }
    
    public static void main(String[] args){
        String s = "--A-A--A-A";
        int k = 2;
        System.out.println(licenseKeyFormatting(s, k));
    }
}
