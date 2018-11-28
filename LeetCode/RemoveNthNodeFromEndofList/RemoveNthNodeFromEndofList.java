//19. Remove Nth Node From End of List

/*

Given a linked list, remove the n-th node from the end of list 
and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    public ListNode removeNthFromEnd(ListNode node, int n) {
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode first = head;
        ListNode second = head;
        
        for (int i = 0; i <= n; i++){
            first = first.next;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return head.next;
    }
    
    
}