'''

Minimum Operations to Reduce X to Zero

You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109

'''

class Solution:
    def _minOperations(self, nums: List[int], x: int) -> int:
        actuallen = len(nums)
        final_answer = []        
        
        def call(lst, count):
            if count == x: 
                return 1
            if count > x:
                return 0
            if len(lst) == 0:
                return 0
            if call(lst[1:], count+lst[0]) or call(lst[:len(lst)-1], count+lst[len(lst)-1]):
                final_answer.append(actuallen - (len(lst) - 1))
            return 0
        
        call(nums, 0)
        
        return min(final_answer, default=-1)
    
    def minOperations(self, nums: List[int], x: int) -> int:
        l = len(nums)
        right_position = len(nums) - 1
        possibility = []
        def get_left_position():
            left, left_sum = 0, 0
            for p in nums:
                
                if left_sum + p > x:
                    return left, left_sum
                left_sum += p
                left += 1
            return left, left_sum
        
        def add_to_possibility(left, right):
            l_from = 0 if left < 0 else left + 1
            l_from += l - right
            possibility.append(l_from)
        
        left_position, sum_from_left = get_left_position()
        if sum_from_left == x:
            possibility.append(left_position)
        left_position -= 1
        total_sum = sum_from_left
        
        
        while left_position >= 0 or right_position >= left_position:
            if right_position >= 0 and right_position > left_position and total_sum + nums[right_position] <= x:
                total_sum += nums[right_position]
                if total_sum == x:
                    add_to_possibility(left_position, right_position)
                right_position -= 1
                
            elif left_position >= 0:
                total_sum -= nums[left_position]
                left_position -= 1
                if total_sum == x:
                    add_to_possibility(left_position, right_position)
            else:
                break
        
        return min(possibility, default=-1)
