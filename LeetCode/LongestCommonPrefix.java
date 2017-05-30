package practiceProblem.leetcode;

import java.util.Arrays;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

// 14. Longest Common Prefix
// More Description: https://leetcode.com/problems/longest-common-prefix/#/description


public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        Arrays.sort(strs);                
        String first = strs[0];
        String last = strs[strs.length-1];
        int endIndex = 0;
        while(endIndex < first.length() && first.charAt(endIndex) == last.charAt(endIndex)){
        	endIndex++;
        }        
        return first.substring(0, endIndex);
    }
}
