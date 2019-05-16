'''
Merge Two Sorted Lists
https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/

Merge two sorted linked lists and return it as a new list. The new list 
should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

'''
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
    
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        else:            
            head = ListNode(0)
            l = head
            while l1 is not None and l2 is not None:
                if l1.val < l2.val:                                            
                    l.next = ListNode(l1.val)
                    l1 = l1.next
                    l = l.next
                else:
                    l.next = ListNode(l2.val)
                    l2 = l2.next
                    l = l.next
            if l1 is not None:
                l.next = l1
            else:
                l.next = l2
            return head.next