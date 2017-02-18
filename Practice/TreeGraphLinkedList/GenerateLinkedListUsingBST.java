/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capston;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Write a function that construct a singly linked list of the tree's entries in ascending order. 

Return a pointer to the first entry in the list.
*/
/**
 *
 * @author itspa
 */
public class GenerateLinkedListUsingBST {
    public static void main(String[] args){
        Node testNode;
        Node leftNode;
        Node rightNode;
        BinarySearchTree testTree = new BinarySearchTree();
        testTree.insert(5);
        testTree.insert(10);
        testTree.insert(3);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(7);
        testTree.insert(11);
        
        testTree.inOrderTraverseTree(testTree.root);
        LinkedList temp = testTree.getHead();
        while(temp != null){
            System.out.print(temp.value +" ");
            temp = temp.next;
        }
    }
}

class LinkedList{
    public LinkedList next;
    public int value;
    
    public LinkedList(int value){
        next = null;
        this.value = value;
    }
}

class Node {
    public Node leftChild;
    public Node rightChild;
    public int value;
    
    public Node(int value){
        leftChild = null;
        rightChild = null;
        this.value = value;
    }
}

class BinarySearchTree {
    public Node root;
    public int size;
    private static Stack st;
    private static boolean validBST;
    private static List<Integer> nodeValue = new ArrayList<Integer>();
    public BinarySearchTree(){
      root = null;
      size = 0;
  }

    public LinkedList getHead(){
        LinkedList head = new LinkedList(nodeValue.get(0));
        LinkedList h = head;
         
        for(int i =1; i<nodeValue.size(); i++){
            LinkedList next = new LinkedList(nodeValue.get(i));
            h.next = next;
            h= next;
        }
        return head;
    }        
    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.value);
            nodeValue.add(focusNode.value);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

  // Time Complexity: O(logn)
  // Auxiliary Space Complexity: O(1)
  public void insert(int value){
      Node newNode = new Node(value);      
      if(root == null){
          root = newNode;
          size++;
          return;          
      }
      Node temp = root;
      while(temp!=null){
          if(temp.value > value){
              if(temp.leftChild != null)
              { temp = temp.leftChild;}
              else{
                  temp.leftChild = newNode;
                  size++;
                  return;
              }
          }
          else{
              if(temp.rightChild != null){
                  temp = temp.rightChild;
              }
              else{   
                  temp.rightChild = newNode;
                  size++;
                  return;
              }
          }
      }
  }
}

