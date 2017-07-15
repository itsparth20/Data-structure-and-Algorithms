package practiceProblem.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 
 * 637. Average of Levels in Binary Tree My SubmissionsBack to Contest
User Accepted: 1338
User Tried: 1396
Total Accepted: 1366
Total Submissions: 2177
Difficulty: Easy
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */

public class AverageofLevelsinBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
		List<Double> list = new ArrayList<>();
		if (root != null) {
			que.add(root);

			while (!que.isEmpty()) {
				int n = que.size();
				double sum = 0.0;
				for (int i = 0; i < n; i++) {
					TreeNode node = que.poll();
					sum += node.val;
					if (node.left != null)
						que.add(node.left);
					if (node.right != null)
						que.add(node.right);
				}
				list.add(sum / n);
			}
		}
		return list;
	}
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}


