'''
Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        
        if head is None:
            return head
        
        temp = ListNode()
        before = temp
        before.next = head
        current = head
        after = current.next
        
        while after is not None:
            if current.val == after.val:
                while current.val == after.val:
                    after = after.next
                    current = current.next
                    if after is None:
                        break
                current = after
                if after:
                    after = after.next
                before.next = current
            else:
                if after:
                    after = after.next
                before = before.next
                current = current.next
        return temp.next
                
        
