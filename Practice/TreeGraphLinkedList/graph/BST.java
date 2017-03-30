package practiceProblem.graph;

public class BST {
	Tree root = null;

	/**
	 * @param root
	 */

	public void add(Tree node) {
		Tree current = root;
		Tree parent = null;
		if (current == null) {
			root = node;
			return;
		}
		while (current != null) {
			parent = current;
			if (current.value < node.value) {				
				current = current.rightNode;
			} else {
				current = current.leftNode;
			}			
		}
		
		if(parent.value < node.value)
			parent.rightNode = node;
		else
			parent.leftNode = node;

	}
	
	public String print(Tree node){
		String s = preOrder(node, new String(""));
		return s;
	}

	private String preOrder(Tree node, String s) {
		if(node == null){
			 
		}else{
			s += String.valueOf(node.value);
			s = preOrder(node.leftNode, s);
			s = preOrder(node.rightNode, s);
		}
		return s;
	}
	
	public Tree createBST(String s){
		if(s.length() == 0){
			return null;
		}
		System.out.println(s.charAt(0));
		String n = String.valueOf(s.charAt(0));
		Tree root = new Tree(Integer.valueOf(n));
		BST bst = new BST();
		bst.add(root);
		for(int i = 1; i < s.length(); i++){
			String n2 = String.valueOf(s.charAt(i));
			bst.add(new Tree(Integer.valueOf(n2)));
		}
		
		return root;
	}
}