'''

Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

'''


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        number1 = self.get_number(l1)
        number2 = self.get_number(l2)
        
        ans = self.add_both_number_and_reverse_it(number1, number2)
        
        return self.create_linkedlist(ans)
    
    def get_number(self, li):
        num = ''
        while li:
            num += str(li.val)
            li = li.next
        
        reverse_num = num[::-1]
        return int(reverse_num)
        
    def add_both_number_and_reverse_it(self, number1, number2):
        ans = number1 + number2
        str_ans = str(ans)[::-1]
        return str_ans
    
    def create_linkedlist(self, str_ans):
        li = ListNode()
        x = li
        for a in str_ans:
            li.next = ListNode(a)
            li = li.next
        
        return x.next
