/*
160. Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
*/

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int headALength = getLength(headA);
        int headBLength = getLength(headB);

        if (headALength == headBLength) {
            return getIntersectionforSameLengthLinkedList(headA, headB, headALength);
        } else {
            if (headALength < headBLength) {
                ListNode temp = headA;
                headA = headB;
                headB = temp;
            }
            int different = Math.abs(headALength - headBLength);
            return getIntersectionForOddLengthLinkedList(headA, headB, different, Math.min(headALength, headBLength));
        }

        return null;
    }

    private ListNode getIntersectionForOddLengthLinkedList(ListNode headA, ListNode headB, int different, int length) {
        for (int i = 0; i < different; i++) {
            headA = headA.next;
        }
        return getIntersectionforSameLengthLinkedList(headA, headB, length);
    }

    private ListNode getIntersectionforSameLengthLinkedList(ListNode headA, ListNode headB, int length) {

        int i = 0;
        while (i < length) {
            if (headA== headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
            i++;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int i = 0;
        while(head != null){
            i++;
            head = head.next;
        }
        return i;
    }
}

