package googleCodeJam;

import practiceProblem.graph.Tree;

/*
 * Given binary tree and find the sum of the element between min and max value
 * 
 */

public class SumOfElementBetweenMinAndMaxLimit {
	public static void main(String[] args) throws java.lang.Exception {
		Node four = new Node(4);
		Node seven = new Node(7);
		Node six = new Node(6, four, seven);
		Node one = new Node(1);
		Node three = new Node(3, one, six);
		Node thirteen = new Node(13);
		Node fourteen = new Node(14);
		fourteen.left = thirteen;
		Node ten = new Node(10);
		ten.right = fourteen;
		Node eight = new Node(8, three, ten);
		// System.out.println(inOrder(eight, ""));
		System.out.println(findSum(eight, 3, 10, 0));
	}

	public static int findSum(Node node, int minLimit, int maxLimit, int sum) {
		if (node == null)
			return sum;
		if (node.val < minLimit)
			return findSum(node.right, minLimit, maxLimit, sum);
		else if (node.val > maxLimit)
			return findSum(node.left, minLimit, maxLimit, sum);
		else {
			int rightSum = node.right != null ? findSum(node.right, minLimit, maxLimit, sum) : 0;
			int leftSum = node.left != null ? findSum(node.left, minLimit, maxLimit, sum) : 0;
			if (node.val >= minLimit && node.val <= maxLimit) {
				sum += node.val;
			}
			return rightSum + leftSum + sum;
		}
	}

	private static String inOrder(Node node, String s) {
		if (node == null) {
		} else {
			s = inOrder(node.left, s);
			s += String.valueOf(node.val);
			s = inOrder(node.right, s);
		}
		return s;
	}
}

class Node {
	Node left;
	Node right;
	int val;

	Node(int val) {
		this.val = val;
	}

	Node(int val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
