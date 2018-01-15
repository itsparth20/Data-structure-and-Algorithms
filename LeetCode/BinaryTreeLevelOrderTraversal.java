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
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
102. Binary Tree Level Order Traversal
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        
        inOrder(root, lst, 0);
        return lst;
    }
    public void inOrder(TreeNode root, List<List<Integer>> lst, int level){
        if(root == null) return;
        
        inOrder(root.left, lst, level+1);
        while(lst.size() <= level){
            lst.add(new ArrayList<Integer>());
        }
        lst.get(level).add(root.val);
        inOrder(root.right, lst, level+1);
    }
}