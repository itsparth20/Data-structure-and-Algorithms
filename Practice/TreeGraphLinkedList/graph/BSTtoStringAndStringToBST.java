package practiceProblem.graph;

import practiceProblem.graph.Tree;
import practiceProblem.graph.BST;

public class BSTtoStringAndStringToBST {
	/**
	 * @param args
	 */
	public static void main(String[] args){
		Tree root = new Tree(5);
		BST bst = new BST();
		bst.add(root);
		bst.add(new Tree(2));
		bst.add(new Tree(1));
		bst.add(new Tree(3));
		bst.add(new Tree(7));
		bst.add(new Tree(6));

		Tree root2 = new Tree(5);
		BST bst2 = new BST();
		bst2.add(root2);
		bst2.add(new Tree(6));
		bst2.add(new Tree(7));
		bst2.add(new Tree(8));
		bst2.add(new Tree(9));
		
		String s = "1234";
		
		BST bst3 = new BST();
		Tree root3 = bst3.createBST(s);
		
		System.out.println(bst3.print(root3));
	}
}
