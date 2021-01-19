'''
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) < 2:
            return len(s)
        
        i = 0
        l = 1
        
        size = len(s)
        window = set()
        window.add(s[i])
        count = 1
        
        for j in range(1, size):
            count += 1
            if s[j] in window:
                while i < j:
                    if s[i] in window:
                        window.remove(s[i]) 
                    i += 1
                    count -= 1                    
                    if s[i-1] == s[j]:
                        break                
            
            window.add(s[j])
            
            l = max(count, l)
            
        return l
            
