/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author itspa
 */
class Node {
    public Node leftChild;
    public Node rightChild;
    public int value;
    
    public Node(Node leftChild, Node rightChild, int value){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }
    
    public Node(int value){
        this.value = value;
        leftChild = null;
        rightChild = null; 
    }

    Node() {
        leftChild = null;
        rightChild = null;
        value = 0;
    }
}
