package practiceProblem.leetcode;

/*
 * 572. Subtree of Another Tree
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


public class SubtreeofAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(3);
		TreeNode sLeft = new TreeNode(4);
		TreeNode sRight = new TreeNode(5);
		TreeNode sLeftLeft = new TreeNode(1);
		TreeNode sLeftRight = new TreeNode(2);
		
		s.left = sLeft;
		s.right = sRight;
		sLeft.left = sLeftLeft;
		sLeft.right = sLeftRight;
		
		TreeNode t = new TreeNode(4);
		TreeNode tLeft = new TreeNode(1);
		TreeNode tRight = new TreeNode(2);
		
		t.left = tLeft;
		t.right = tRight;
		
		System.out.println(isSubtree(s,t));
	}

	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) return false;
		if( helper(s,t) )return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
	
	private static boolean helper(TreeNode s, TreeNode t){
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		if(s.val != t.val) return false;
		return helper(s.left,t.left) && helper(s.right,t.right);
	}
}
