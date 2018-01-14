/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
94. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/description/
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inOrder(root, lst);
        return lst;
    }
    
    public void inOrder(TreeNode root, List<Integer> lst){
        if(root == null) return;
        inOrder(root.left, lst);
        lst.add(root.val);
        inOrder(root.right, lst);
    }
}