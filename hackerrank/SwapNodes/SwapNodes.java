import java.io.*;
import java.util.*;

public Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int take = sc.nextInt();
        Node root = getRoot(sc, take);        
        SwapNode(sc, root);   
    }
    
    public static void SwapNode(Scanner sc, Node root){
        int take = sc.nextInt();
        for(int i = 0; i < take; i++){
            int depth = sc.nextInt();
            performSwap(depth, root, 1, 1);
            //inOrder(root);
            System.out.println();
       }
    }
    
    public static void performSwap(int depth, Node node, int current, int number){
        if (node == null){
            return;
        }
        if(current%depth == 0){
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;            
            
        }
        performSwap(depth, node.left, current+1, number);
        System.out.print(node.val + " ");
        performSwap(depth, node.right, current+1, number);           
    }
    
    public static Node getRoot(Scanner sc, int take){
        int left = sc.nextInt();
        int right = sc.nextInt();
        Queue<Node> fifo = new LinkedList<>();
        Node leftNode = null;
        Node rightNode = null;
        if (left != -1){
            leftNode = new Node(left );
            fifo.add(leftNode);
        }
        if (right != -1){
            rightNode = new Node(right);      
            fifo.add(rightNode);
        }
        Node root = new Node(1, leftNode, rightNode); 
        for(int i = 1; i < take; i++){
            leftNode = null;
            rightNode = null;
            left = sc.nextInt();
            right = sc.nextInt();
            if (left != -1){
                leftNode = new Node(left);
                fifo.add(leftNode);
            }
            if (right != -1){
                rightNode = new Node(right);      
                fifo.add(rightNode);
            }
            Node current = fifo.remove();
            if (leftNode != null || rightNode != null){
                current.left = leftNode;
                current.right = rightNode;
            }
        }
        return root;
    }    
    
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public Node(int val){
            this.val = val;
        }

    }
}