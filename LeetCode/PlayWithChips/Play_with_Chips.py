class Solution(object):
    def minCostToMoveChips(self, chips):
        """
        :type chips: List[int]
        :rtype: int
        """
        odd = 0
        even = 0
        for i in chips:
            if i % 2 == 0:
                even += 1
            else:
                odd += 1
        
        return odd if odd < even else even            