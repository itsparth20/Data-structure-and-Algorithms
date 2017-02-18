/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author itspa
 */

/*
*  Homework V
*
*  Problem 1: Node class
*
*  Prompt:    Create a Node class
*             The Node class should contain the following public properties:
*
*                   value:   integer value
*               leftChild:   pointer to another node (initially null)
*              rightChild:   pointer to another node (initially null)
*
*                 Example:   var sample = new Node(1)
*                            sample.value        // 1
*                            sample.leftChild    // null
*                            sample.rightChild   // null
*
*
*  Problem 2: BinarySearchTree class.
*
*  Prompt:    Create a BinarySearchTree class
*
*             The BinarySearchTree class should contain the following public
*             properties:
*
*                    root:   A pointer to the root node (initially null)
*                    size:   The number of nodes in the BinarySearchTree
*
*             The BinarySearchTree class should also contain the following
*             public methods:
*
*                  insert:   A method that takes takes an integer value, and
*                            creates a node with the given input.  The method
*                            will then find the correct place to add the new
*                            node. Values larger than the current node node go
*                            to the right, and smaller values go to the left.
*
*                            Input:     int
*                            Output:    void
*
*                  search:   A method that will search to see if a node with a
*                            specified value exists and returns true or false
*                            if found.
*
*                            Input:     int
*                            Output:    boolean
*
*
*             What are the time and auxilliary space complexities of the
*             various methods?
*
*
*  Extra:     Remove method for BinarySearchTree class
*
*  Prompt:    Add the following public method to the BinarySearchTree class:
*
*                  remove:   A method that removes a value matching the input
*                            the tree is then retied so that the binary search
*                            tree order is not violated.
*/


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
    public BinarySearchTree(){
      root = null;
      size = 0;
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


  // Time Complexity: O(logn)
  // Auxiliary Space Complexity: O(1) 
  public boolean search(int value){
    Node temp = root;
    while(temp!=null){
        if(temp.value == value)
            return true;
        if(temp.value > value)
            temp=temp.leftChild;
        else
            temp=temp.rightChild;
    }
    return false;
  }
  
  public boolean validateBST(){
      st = new Stack();
      Node temp = root;
      validBST = true;
      inOrderTraversal(temp);
      return validBST;
  }

    private void inOrderTraversal(Node temp) {
        if(temp==null || validBST == false){
            return;
        }
        if(validBST){
            inOrderTraversal(temp.leftChild);
        }
        if(st.size() == 0)
            st.push(temp.value);
        else if((Integer)st.peek() < temp.value)
            st.push(temp.value);
        else
            validBST = false;
        
        if(validBST){
            inOrderTraversal(temp.rightChild);
        }
    }

}


////////////////////////////////////////////////////////////
///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
////////////////////////////////////////////////////////////


public class BinarySearchTreeImpl {
  public static void main(String[] args) {
    Node testNode;
    Node leftNode;
    Node rightNode;
    BinarySearchTree testTree;

    System.out.println("-----node class-----\n");
    System.out.println("creation of a node");
    testNode = new Node(5);
    System.out.println("1.0: " + (testNode != null));
    System.out.println("1.1: " + (testNode.value == 5));
    System.out.println("1.2: " + (testNode.leftChild == null));
    System.out.println("1.3: " + (testNode.rightChild == null));

    System.out.println("\nassigning values and children");
    testNode.value = 3;
    System.out.println("2.0: " + (testNode.value == 3));
    leftNode = new Node(1);
    rightNode = new Node(5);
    System.out.println("2.1: " + (testNode.leftChild  == null));
    System.out.println("2.2: " + (testNode.rightChild  == null));
    testNode.leftChild = leftNode;
    testNode.rightChild = rightNode;
    System.out.println("2.3: " + (testNode.leftChild.value  == 1));
    System.out.println("2.4: " + (testNode.rightChild.value  == 5));

    System.out.println("\n\n-----binary search tree class-----\n");
    System.out.println("creation of a binary search tree");
    testTree = new BinarySearchTree();
    System.out.println("3.0: " + (testTree != null));
    System.out.println("3.1: " + (testTree.root == null));
    System.out.println("3.2: " + (testTree.size == 0));

    System.out.println("\ninsert first node");
    testTree.insert(5);
    System.out.println("4.0: " + (testTree.size == 1));
    System.out.println("4.1: " + (testTree.root.value == 5));
    System.out.println("4.2: " + (testTree.root.leftChild == null));
    System.out.println("4.3: " + (testTree.root.rightChild == null));

    System.out.println("\ninsert a second node");
    testTree.insert(10);
    System.out.println("5.0: " + (testTree.size == 2));
    System.out.println("5.1: " + (testTree.root.value == 5));
    System.out.println("5.2: " + (testTree.root.leftChild == null));
    System.out.println("5.3: " + (testTree.root.rightChild != null));
    System.out.println("5.4: " + (testTree.root.rightChild.value == 10));

    System.out.println();
    testTree.insert(3);
    testTree.insert(1);
    testTree.insert(4);
    testTree.insert(7);
    testTree.insert(11);
    System.out.println("\nsearch method");
    System.out.println("6.0: " + (testTree.search(3) == true));
    System.out.println("6.1: " + (testTree.search(1) == true));
    System.out.println("6.2: " + (testTree.search(4) == true));
    System.out.println("6.3: " + (testTree.search(7) == true));
    System.out.println("6.4: " + (testTree.search(11) == true));
    System.out.println("6.5: " + (testTree.search(14) == false));
    System.out.println("6.6: " + (testTree.search(6) == false));

    System.out.println(testTree.validateBST());
  }
}
