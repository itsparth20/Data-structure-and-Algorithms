package practiceProblem.graph;

public class DiameterOfBinaryTree {
	public static void main(String[] args){
		Tree node = new Tree(10);
		Tree nodeLeft = new Tree(5);
		Tree nodeRight = new Tree(20);
		Tree nodeLeftLeft = new Tree(3);
		BST bst = new BST();
		bst.add(node);
		bst.add(nodeLeft);
		bst.add(nodeLeftLeft);
		bst.add(nodeRight);
	
		System.out.println(diameterOfTree(bst.getRoot()));
	}

	private static int diameterOfTree(Tree node) {
		int leftHeight=0, rightHeight = 0;
		
		if(node.leftNode != null){
			HightOfTree HOF = new HightOfTree();
			leftHeight = HOF.height(node.leftNode);			
		}
		if(node.rightNode != null){
			HightOfTree HOF = new HightOfTree();
			rightHeight = HOF.height(node.rightNode);
		}
		
		return leftHeight+rightHeight+1;
	}
}
