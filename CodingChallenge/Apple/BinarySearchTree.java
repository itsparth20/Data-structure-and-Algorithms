package tries;

import java.util.Stack;

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

    public void inOrderTraversal(Node temp) {
        if(temp==null || validBST == false){
            return;
        }
        if(validBST){
            inOrderTraversal(temp.leftChild);            
        }
        System.out.println(temp.value);
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