/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

/**
 *
 * @author itspa
 */
class Node {
    int data;
    Node next;
}


public class reverseLinkedList {
    public static void main(String[] args) {
        Node one = new Node();
        one.data = 1;
        
        Node two = new Node();
        two.data = 2;
        
        Node three = new Node();
        three.data = 3;
        
        Node four = new Node();
        four.data = 4;
        
        one.next=two;
        two.next = three;
        three.next = four;
        four.next = null;
        
        Node temp = new Node();
        temp = reverseList(one);
        for(int i =0; i<4; i++){
            System.out.println(temp.data);
            temp = temp.next;
        }
        
    }        

    private static Node reverseList(Node head) {
        if(head.next == null){
        return head;
    }

        Node temp = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return temp;
    }
}

