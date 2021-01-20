'''
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000

consist of only digits and English letters (lower-case and/or upper-case),

'''

class Solution:
    def longestPalindrome(self, s: str) -> str:
        _max = ''
        l = len(s)
        
        def loop_over_str(left, right):
            while left >= 0 and right < l:
                if s[left] == s[right]:
                    left -= 1
                    right += 1
                else:
                    break
            return s[left+1:right]
            
        def odd_palindrom(position):
            left = position
            right = left + 1
            return loop_over_str(left, right)
        
        def even_palindrom(position):
            left = position - 1
            right = position + 1
            return loop_over_str(left, right)
                
        
        for i, w in enumerate(s):
            odd = odd_palindrom(i)
            even = even_palindrom(i)
            bigger = odd if len(odd) > len(even) else even
            _max = bigger if len(bigger) > len(_max) else _max
        
        return _max
