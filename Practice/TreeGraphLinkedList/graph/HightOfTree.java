package practiceProblem.graph;

import java.util.HashMap;
import java.util.Map;

public class HightOfTree {
	Map<Tree, Integer> heightDict = new HashMap<Tree, Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree node = new Tree(100);
		Tree nodeLeft = new Tree(50);
		Tree nodeRight = new Tree(150);
		Tree nodeLeftLeft = new Tree(25);
		BST bst = new BST();
		bst.add(node);
		bst.add(nodeLeft);
		bst.add(nodeLeftLeft);
		bst.add(nodeRight);
		bst.add(new Tree(70));
		bst.add(new Tree(160));
		bst.add(new Tree(60));
		bst.add(new Tree(75));
		bst.add(new Tree(190));
		bst.add(new Tree(180));
		bst.add(new Tree(195));
		bst.add(new Tree(170));
		bst.add(new Tree(185));
		HightOfTree obj = new HightOfTree();
		System.out.println(obj.height(bst.getRoot()));
		System.out.println(obj.height(bst.getRoot()));

	}

	int height(Tree node) {
		// Your code here
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right
		 * heights
		 */
		return helper(node, 0);
	}

	int helper(Tree node, int total) {

		if (node != null) {

			if (heightDict.containsKey(node)) {
				return heightDict.get(node);
			}
			int maxHeight = Math.max(helper(node.leftNode, total + 1), helper(node.rightNode, total + 1)) + 1;
			heightDict.put(node, maxHeight);
			return maxHeight;
		}
		return 0;
	}

}
