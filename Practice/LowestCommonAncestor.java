/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;

/**
 *
 * @author itspa
 * 
 * Given the root node of a binary tree and two distinct values, find the lowest common ancestor.

Input:     Root Node, Two Integer Values 
Output:  Integer Value of Lowest Common Ancestor

Input: root, 4, 9      	=>	Output: 7

Constraints
Time Complexity: O(N)
Auxiliary Space Complexity: O(N)

Integer values of nodes are all distinct.


 */
public class LowestCommonAncestor {
    public static ArrayList n1;
    public static ArrayList n2;
    public static int number1;
    public static int number2;
    public static void main(String[] args){
        Node rightRightRight = new Node(9);
        Node rightRightChild = new Node(null, rightRightRight,8); 
        Node rightLeftChild = new Node(4);
        Node rightChild = new Node(rightLeftChild, rightRightChild, 7);
        Node leftChild = new Node(2);
        Node root = new Node(leftChild, rightChild, 5);
        number1=5;
        number2=10;
        n1 = new ArrayList<Integer>();
        n2 = new ArrayList<Integer>();
        
        if(!findPath(root, number1, n1)){
            System.out.println("-1");
        }else if(!findPath(root, number2, n2)){
            System.out.println("-1");
        }else{
            int i;
            for(i = 0; i<n1.size() && i<n2.size(); i++){
                if(n1.get(i) != n2.get(i)){
                    break;
                }                
            }
            if(i-1 >= 0)
                System.out.println(n1.get(i-1));
            else
                System.out.println(root.value);
        }
        
    }

    private static boolean findPath(Node root, int value, ArrayList<Integer> l) {
        if(root==null){
            return false;
        }
        if(root.value == value){
            return true;
        }
        l.add(root.value);
        if(findPath(root.leftChild, value, l) || findPath(root.rightChild, value, l) )
            return true;
                
        l.remove(l.size()-1);        
        return false;
    }

   
    
}
