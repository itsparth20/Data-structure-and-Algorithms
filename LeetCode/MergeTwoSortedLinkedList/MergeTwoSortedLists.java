/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l3 = null;
        ListNode root = null;
        while(l1 != null && l2!=null){
            if(l1.val < l2.val){
                if(l3 == null){
                    l3 = new ListNode(l1.val);
                    root = l3;
                }
                else{
                    ListNode next = new ListNode(l1.val);
                    l3.next = next;
                    l3 = next;
                }
                l1 = l1.next;
                
            }else{
                if(l3 == null){
                    l3 = new ListNode(l2.val);
                    root = l3;
                }
                else{
                    ListNode next = new ListNode(l2.val);
                    l3.next = next;
                    l3 = next;
                }
                l2 = l2.next;
            }
        }
        while(l1 != null){
            ListNode next = new ListNode(l1.val);
            l3.next = next;
            l3 = next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode next = new ListNode(l2.val);
            l3.next = next;
            l3 = next;
            l2 = l2.next;
        }
        return root;
    }
    
}