/*
125. Valid Palindrome
https://leetcode.com/problems/valid-palindrome/description/
*/
class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.length() < 2) return true;
        
        char[] replace = s.toLowerCase().replaceAll("[^A-Za-z0-9]","").toCharArray();
        System.out.println(s.replaceAll("[^A-Za-z0-9]",""));
        int len = replace.length;
        for(int i =0; i < len/2; i++){
            if(replace[i] != replace[len-1-i]){
                return false;
            }
        }
        return true;
    }
}