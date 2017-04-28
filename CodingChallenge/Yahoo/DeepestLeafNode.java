package practiceProblem.graph;

public class DeepestLeafNode {
	Tree leafNode;
	private int maxDepth = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree root = new Tree(50);
		Tree rootLeft = new Tree(10);
		Tree rootRight = new Tree(75);
		Tree rootRightLeft = new Tree(60);
		Tree rootRightRight = new Tree(90);
		Tree rootRightLeftLeft = new Tree(55);
		Tree rootRightLeftRight = new Tree(70);
		Tree rootRightRightRight = new Tree(80);
		Tree rootRightRightRightRight = new Tree(100);
		BST bst = new BST();
		bst.add(root);
		bst.add(rootLeft);
		bst.add(rootRight);
		bst.add(rootRightLeft);
		bst.add(rootRightRight);
		bst.add(rootRightLeftLeft);
		bst.add(rootRightLeftRight);
		bst.add(rootRightRightRight);
		bst.add(rootRightRightRightRight);
		bst.add(new Tree(500));
		
		
		DeepestLeatNode obj = new DeepestLeatNode();
		obj.def(bst.getRoot());
		
	}

	void def(Tree root){
		helper(root, 0);
		System.out.println(leafNode.value);
	}

	private void helper(Tree root, int i) {
		// TODO Auto-generated method stub
		if(root == null){
			return;			
		}
		if(maxDepth < i && root.leftNode == null && root.rightNode == null){
			maxDepth = i;
			leafNode = root;
		}
		
		helper(root.leftNode, i+1);
		helper(root.rightNode, i+1);
	}
}
