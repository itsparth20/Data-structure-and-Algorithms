class Solution(object):
    def longestSubsequence(self, arr, difference):
        """
        :type arr: List[int]
        :type difference: int
        :rtype: int
        """
        # value = 0
        # for i in range(0, len(arr)):
        #     max_value = 1
        #     diff = arr[i] + difference
        #     for j in range(i+1, len(arr)):
        #         if arr[j] == diff:
        #             max_value += 1
        #             diff = arr[j] + difference
        #     value = max(value, max_value)
        # return value
        from collections import defaultdict
        dic = defaultdict(int)
        max_value = 0
        for i in arr:
            dic[i] = dic[i-difference] + 1
            max_value = max(max_value, dic[i])
        return max_value