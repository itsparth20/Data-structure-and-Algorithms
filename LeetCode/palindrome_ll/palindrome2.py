class Solution:
    def validPalindrome(self, s: str) -> bool:
        l = len(s)
        for i in range(0, int(l/2)):
            if s[i] != s[l-i-1]:
                if self._is_palindrome(s[i+1:l-i]):
                    return True
                else:
                    return self._is_palindrome(s[i:l-i-1])
        return True
    
    def _is_palindrome(self, s: str) -> bool:
        l = len(s)
        for i in range(0, int(l/2)):
            if s[i] != s[l-i-1]:
                return False
        return True