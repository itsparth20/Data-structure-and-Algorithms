package practiceProblem.leetcode;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l12 = new ListNode(4);
		ListNode l13 = new ListNode(3);
		l1.next = l12;
		l12.next = l13;
		
		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l23 = new ListNode(4);
		
		l2.next = l22;
		l22.next = l23;
		
		ListNode l3 = addTwoNumbers(l1,l2); 
		while(l3!=null){
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;
        int carry = 0;
        while(l1!=null && l2!= null){
            
            int sum = l2.val+l1.val+carry;
            ListNode newNode = new ListNode(sum%10);
            if(head==null){
                head = newNode;
                pre = newNode;
            }else{
                pre.next = newNode;
                pre = newNode;
            }
            carry = sum/10;
            l1 = l1.next;
			l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val+carry;
            ListNode newNode = new ListNode(sum%10);
            pre.next = newNode;
			pre = newNode;

			carry = sum/10;
            l1 = l1.next;
        }
        
        while(l2!=null){
            int sum = l2.val+carry;
            ListNode newNode = new ListNode(sum%10);
            pre.next = newNode;
			pre = newNode;
			carry = sum/10;
            l2 = l2.next;
        }
        if(carry >0){
            ListNode newNode = new ListNode(carry);
            pre.next = newNode;
            pre = newNode;
        }
        pre.next = null;
            
        return head;
    }
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}