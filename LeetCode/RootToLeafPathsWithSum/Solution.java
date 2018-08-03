package com.help.murtip;


import java.util.ArrayList;
import java.util.List;

/*
Root to Leaf Paths With Sum
Given a binary tree and a sum, find all root-to-leaf paths where each
path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<Integer>(), A, B, 0);
        return list;
    }

    public void helper(List<ArrayList<Integer>> list, List<Integer> innerlist, TreeNode node, int total, int sum){
        if (node == null) {
            return;
        }
        innerlist.add(node.val);
        sum += node.val;
        if (leafNode(node)) {
            if (sum == total) {
                list.add(new ArrayList<>(innerlist));
            }
        }
        helper(list, innerlist, node.left, total, sum);
        helper(list, innerlist, node.right, total, sum);
        innerlist.remove(innerlist.size() - 1);
    }

    private boolean leafNode(TreeNode node){
        return node.left == null && node.right == null;
    }
}



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
