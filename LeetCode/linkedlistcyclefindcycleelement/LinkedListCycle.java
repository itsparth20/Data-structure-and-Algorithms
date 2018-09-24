package com.leetcode.linkedlistcycle;

import com.helper.linkedlist.ListNode;

/*
142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class LinkedListCycle {

//     public ListNode detectCycle(ListNode head) {
//
//         Set<ListNode> set = new HashSet<>();
//
//         while(head!=null){
//             if(!set.add(head)){
//                 return head;
//             }
//             head=head.next;
//         }
//         return head;
//     }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow1 = head;
                while (slow1 != slow) {
                    slow1 = slow1.next;
                    slow = slow.next;
                }
                return slow1;
            }
        }
        return null;
    }
}