

/**
 *
 * @author itspa
 */

/*
*  Homework III
*
*  Problem 1: Node class
*
*  Prompt:    Create a Node class
*
*             The Node class should contain the following public properties:
*
*                 value:   integer value
*                  next:   pointer to another node (initially null)
*
*               Example:   var sample1 = new Node(1)
*                          sample1.value     // 1
*                          sample1.next      // null
*
*
*  Problem 2: LinkedList class
*
*  Prompt:    Create a LinkedList class
*
*             The LinkedList class should contain the following public
*             properties:
*
*                length:   The number of nodes in the linked list
*                  head:   A pointer to the head node
*                  tail:   A pointer to the tail node
*
*              The LinkedList class should also contain the following public
*              methods:
*
*                append:   A method that appends a value to the end of the
*                          LinkedList.
*
*                          Input:     int
*                          Output:    void
*
*                insert:   A method that inserts an integer value at a set
*                          index in the LinkedList (assume head index is 0).
*
*                          Input:     int value, int index
*                          Output:    void
*
*                delete:   A method that removes a node at a specified index.
*
*                          Input:     int index
*                          Output:    void
*
*              contains:   A method that checks to see if a value is contained
*                          in the list.
*
*                          Input:     int value
*                          Output:    boolean
*
*    What are the time and auxiliary space complexity of the various
*    methods?
*
*/

import java.util.*;

class Node {
    public Node next = null;
    public int value;
    public Node(int value){
        this.value=value;
        this.next = null;
    }
}


class LinkedList {



    public int length = 0;
    public Node head = null;
    public Node tail = null;

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: 0(1)    
  public void append(int value){
      Node newNode = new Node(value);
      if(head==null){
        head = newNode;
        tail = newNode;
      }else{
        tail.next = newNode;
        tail = newNode;
      }
      length++;
  }


  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1) 
  public void insert(int value, int index){
      Node insertNode = new Node(value);
      Node next = head;
      Node prevNode = null;
      int itemIndex = 0;
      while(itemIndex < index && itemIndex < length){
          prevNode = next;
          next = next.next;
          
          itemIndex++;
      }
      if(itemIndex >= length){
          tail.next = insertNode;
          tail = insertNode;
          length++;
          return;
      }
      if(itemIndex == 0){
          insertNode.next = head;
          head = insertNode;
          length++;
          return;
      }
      prevNode.next = insertNode;
      insertNode.next = next;
      
      length++;
      
  }



  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public void delete(int index){
      int tempIndex = 0;
      Node removeNextNode = head;
      Node prevNode = null;
      while(tempIndex < index-1 && tempIndex < length-1){
          prevNode = removeNextNode;
          removeNextNode = removeNextNode.next;
          tempIndex++;
      }
      if(tempIndex >= length || index > length){
          prevNode.next = null;
          tail = prevNode;
          length--;
          return;
      }
      if(tempIndex == 0){
          removeNextNode = head.next;
          head = removeNextNode;
          if(head == null){
              tail = null;
          }
          length--;
          return;
      }
      removeNextNode.next = removeNextNode.next.next;
      length--;
  }


  // Time Complexity: O(n)
  // Auxiliary Space Complexity: O(1)
  public boolean contains(int value){
      Node temp = head;
      while(temp!=null){
          if(temp.value == value)
              return true;
      }
      return false;
  }
  
  //Time Complexity: O(n)
  //Auxiliary space complexity: O(1)
  public void printForward(){
      Node temp = head;
      while(temp != null){
          System.out.println(temp.value);
          temp = temp.next;
      }
  }
  
  //Time Complexity: O(n)
  //Auxiliary space complexity: O(1)
  public void printBackward(){      
      Node temp = head;
      printReverse(temp);
  }

    private void printReverse(Node temp) {
        if(temp == null)
            return;
                
        printReverse(temp.next);
        System.out.println(temp.value);
    }

    //Time Complexity: O(n)
    //Auxiliary space complexity: O(1)
    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = head.next;
        
        while(next!=null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        head = current;
        printForward();
    } 
    
    //Time Complexity: O(n)
    //Auxiliary space complexity: O(1)
    public void swap2Number(int no1,int no2){
        
        if(no1 == no2)
            return;
        
        Node prevNo1Node = null;
        Node no1Node = head;
        Node prevNo2Node = null;
        Node no2Node = head;
        Node temp = head;
        boolean no1Match = false;
        boolean no2Match = false;
        while(temp!=null){
            if(no1Match == false){
                if(no1Node.value == no1){
                    no1Match = true;
                    
                }
                else{
                    prevNo1Node = no1Node;
                    no1Node = no1Node.next;
                }
            }
            if(no2Match == false){
                if(no2Node.value == no2){
                    no2Match = true;
                }
                else{
                    prevNo2Node = no2Node;
                    no2Node = no2Node.next;
                }
            }
            temp = temp.next;
        }
        
        if(prevNo1Node != null){
            prevNo1Node.next = no2Node;
        }else{
            head = no2Node;
        }
        
        if(prevNo2Node != null){
            prevNo2Node.next = no1Node;
        }else{
            head = prevNo1Node;
        }
                        
        Node temporary  = no1Node.next;        
        no1Node.next = no2Node.next;
        no2Node.next = temporary;
        
        printForward();
    }
    
    public boolean cycle(){
        Node slow = head;
        Node fast = head;
        
        while(fast!=null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
                return true;
        }
        
        return false;
    }
}


public class LinkedListInsertDeleteAppendContan {
  public static void main(String[] args) {
    Node newNode;

    LinkedList newList = new LinkedList();
    newList.append(5);
    newList.delete(0);
    newList.append(10);
    newList.append(15);
    newList.insert(12, 2);
    newList.insert(1, 0);
    newList.insert(20, 5);
    newList.delete(2);
    newList.delete(6);
    Node current = newList.head;
    for(int i = 0; i < newList.length; i++){
      System.out.print(current.value + " ");
      current = current.next;
    }
    System.out.println(newList.contains(1));
  }
}
