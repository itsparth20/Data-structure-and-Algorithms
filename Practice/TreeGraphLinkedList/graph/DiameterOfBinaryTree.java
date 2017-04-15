package practiceProblem.graph;

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
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
		
		
		
		
//		bst.add(new Tree(70));
//		bst.add(new Tree(175));
//		bst.add(new Tree(5));
//		bst.add(new Tree(40));
//		bst.add(new Tree(80));
//		bst.add(new Tree(30));
//		bst.add(new Tree(75));
//		bst.add(new Tree(85));
//		bst.add(new Tree(26));
//		bst.add(new Tree(35));
//		bst.add(new Tree(90));
//		HightOfTree HOF = new HightOfTree();
//		System.out.println(HOF.height(bst.getRoot()));
		System.out.println(diameterOfTree(bst.getRoot()));
	}

	private static int diameterOfTree(Tree node) {
		
		if(node == null){
			return 0;
		}
		int leftHeight = 0, rightHeight = 0;

		HightOfTree HOF = new HightOfTree();
		leftHeight = HOF.height(node.leftNode);
		rightHeight = HOF.height(node.rightNode);
		
		int leftDiameter = diameterOfTree(node.leftNode);
		int rightDiameter = diameterOfTree(node.rightNode);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		

	}


	
}
