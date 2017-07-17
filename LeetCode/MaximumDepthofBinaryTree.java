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
Description: https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description
	
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root != null){
            if(root == null)
                return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int max = Math.max(left,right);
            return max+1;
        }
        return 0;
    }
    
}