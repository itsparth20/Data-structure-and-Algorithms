//https://www.hackerrank.com/challenges/is-binary-search-tree/problem

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/
 
    boolean checkBST(Node root) {
        //inOrder(root);
        return check(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }
    void inOrder(Node root){
        if (root == null) return;
        System.out.println(root.data + " " + (root.left != null ? root.left.data : -1) + " " +  (root.right != null ? root.right.data : -1) );
        inOrder(root.left);
        inOrder(root.right);    
    }

    boolean check(int min, Node root, int max){
        if(root == null) return true;
        
        if(root.data <= min) return false;
        if(root.data >= max) return false;
        if(check(min, root.left, root.data) && check(root.data, root.right, max)){
            return true;
        }
        return false;
    }
