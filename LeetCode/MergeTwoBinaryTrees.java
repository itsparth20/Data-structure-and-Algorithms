package com.example.examplemod;

//617. Merge Two Binary Trees
//Description: https://leetcode.com/contest/leetcode-weekly-contest-36/problems/merge-two-binary-trees/

/*
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 */

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree1 = new TreeNode(1);
		TreeNode tree1L = new TreeNode(3);
		TreeNode tree1R = new TreeNode(2);
		TreeNode tree1LL = new TreeNode(5);
		tree1.left = tree1L;
		tree1.right = tree1R;
		tree1L.left = tree1LL;
		
		
		TreeNode tree2 = new TreeNode(2);
		TreeNode tree2L = new TreeNode(1);
		TreeNode tree2R = new TreeNode(3);
		TreeNode tree2LR = new TreeNode(4);
		TreeNode tree2RR = new TreeNode(7);
		tree2.left = tree2L;
		tree2.right = tree2R;
		tree2L.right = tree2LR;
		tree2R.right = tree2RR;
		TreeNode root = mergeTrees(tree1, tree2);
		System.out.println("Bye");
	}

	

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t2 == null) return t1;
        if(t1 == null) return t2;
        TreeNode root = null;
        return helper(t1, t2, root);

    }
    
    public static TreeNode helper(TreeNode t1, TreeNode t2, TreeNode root){    	
        if(t1 == null && t2 == null){
            return null;
        }
        if(t1 != null && t2 != null){        	
            root = new TreeNode(t1.val + t2.val);
            
            root.left = helper(t1.left, t2.left, root.left);
            root.right = helper(t1.right, t2.right, root.right);
        }
        
        if(t1 == null && t2 != null){
            root = new TreeNode(t2.val);           
            root.left = helper(t1, t2.left, root.left);
            root.right = helper(t1, t2.right, root.right);
        }
        
        if(t2 == null && t1 != null){
            root = new TreeNode(t1.val);            
            root.left = helper(t1.left, t2, root.left);
            root.right = helper(t1.right, t2, root.right);
        }        
        return root;
        
    }   
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
