/*
String Similarity
https://www.hackerrank.com/challenges/string-similarity/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int stringSimilarity(String s) {
        // Complete this function
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += helper(s.substring(i), s);
        }            
        return count;
    }
    
    static int helper(String suffix, String s){
        int count = 0;
        for(int i = 0, j = 0; i < suffix.length() && j < s.length(); i++, j++){
            if (suffix.charAt(i) == s.charAt(j)){
                count++;
            }else{
                return count;
            }
        }
        return count;
    }
    
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            int result = stringSimilarity(s);
            System.out.println(result);
        }
        in.close();
    }
}
