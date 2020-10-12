# Reverse a linked list from position m to n. Do it in one-pass.
# https://leetcode.com/problems/reverse-linked-list-ii/
# Note: 1 ≤ m ≤ n ≤ length of list.

# Example:

# Input: 1->2->3->4->5->NULL, m = 2, n = 4
# Output: 1->4->3->2->5->NULL

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if m == n:
            return head
        
        prev_of_m = None
        after_of_n = None
        
        temp_node = head
        
        i = 0
        prev_node = None
        m_node = None
        n_node = None
        
        while(temp_node):
            if i < m-1:
                prev_node = temp_node
                temp_node = temp_node.next
                i += 1
                continue
            elif i == m-1:
                prev_of_m = prev_node
                prev_node = temp_node                
                m_node = temp_node
                temp_node = temp_node.next
                
                i += 1
                continue
            elif i == n:
                after_of_n = temp_node
                break
            
            next_node = temp_node.next
            temp_node.next = prev_node
            prev_node = temp_node
            n_node = prev_node
            temp_node = next_node
            i += 1
            
        m_node.next = after_of_n
        if prev_of_m:
            prev_of_m.next = prev_node
        else:
            head = n_node 
        return head
        
            
