/*
58. Length of Last Word

https://leetcode.com/problems/length-of-last-word/

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

*/

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.equals("")) return 0;
        String[] arr = s.split(" ");
        return arr[arr.length-1].split("").length;
    }
}