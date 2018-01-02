/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 19. Remove Nth Node From End of List
 https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
class Solution {
    public static int i = 0;
    public static int j = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            if(n > j){
                i = n - j + 1;}
            else {i++;}
            return head;
        }
        j++;
        head.next = removeNthFromEnd(head.next, n);
        i++;
        if(n == i-1 ){
            return head.next;
        }
        return head;
    }
    
}