/*
25. Reverse Nodes in k-Group

https://leetcode.com/problems/reverse-nodes-in-k-group/

Given a linked list, reverse the nodes of a linked list k at a time and 
return its modified list.

k is a positive integer and is less than or equal to the length of the 
linked list. If the number of nodes is not a multiple of k then left-out 
nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
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
//     public ListNode reverseKGroup(ListNode head, int k) {
//         ListNode pivot = new ListNode(0);
//         pivot.next = head;
//         ListNode l = head;
//         ListNode r = head.next;
//         ListNode t = null;
//         ListNode prev = pivot;
//         while (true){
//             t = l;
            
//             for (int i = 0; i < k; i++){
//                 if (t == null){
//                     return pivot.next;
//                 }
//                 t = t.next;
//             }
//             ListNode temp = null;
//             for (int i = 0; i < k-1; i++){
//                 temp = r.next;
//                 r.next = l;                
//                 l = r;
//                 r = temp;
//             }
//             temp = prev.next;
//             prev.next.next = r;
//             prev.next = l;
//             prev = temp;
            
//             l = r;
//             if (l.next != null){
//                 r = r.next;
//             }
//         }
//     }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || head == null)
            return head;
        ListNode c = head;
        int temp = k;
        while(temp > 0){
            c = c.next;
            --temp;
            if(c==null && temp !=0)
                return head;
        }
        temp = k;
        ListNode cur = head, prev = null, nex = null;

        while(temp > 0 && cur !=null){
            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
            --temp;
        }
        head.next = reverseKGroup(nex, k);
        return prev;
    }
}