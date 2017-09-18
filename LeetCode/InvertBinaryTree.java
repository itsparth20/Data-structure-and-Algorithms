package leetcode.outco;

//https://leetcode.com/problems/invert-binary-tree/description/
//226. Invert Binary Tree

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class InvertBinaryTree {

	
	public TreeNode invertTree(TreeNode root) {
        inOrder(root);
        return root;
    }
    public void inOrder(TreeNode root){
        if(root!= null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            inOrder(root.left);
            inOrder(root.right);
            
        }
    }
}
