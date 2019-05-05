/*
Maximum Depth of Binary Tree

https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2375/

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root, 1);
    }
    
    private int helper(TreeNode node, int depth) {
        if (node == null){
            return depth -1;
        }
        else if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));
    }
}