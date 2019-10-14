class Solution(object):
    def balancedStringSplit(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {'L': 1, 'R': -1}
        count = 0
        total = 0
        for i in s:
            total += dic[i]
            if total == 0:
                count += 1
        
        return count