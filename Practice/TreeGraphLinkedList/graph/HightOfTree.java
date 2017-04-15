package practiceProblem.graph;

public class HightOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree node = new Tree(10);
		HightOfTree obj = new HightOfTree();
		System.out.println(obj.height(node));
		
	}

	int height(Tree node) {
		// Your code here
		return helper(node, 0);
	}

	int helper(Tree node, int total) {

		if (node == null) {
			return 0;
		}

		return Math.max(helper(node.leftNode, total + 1), helper(node.rightNode, total + 1)) + 1;
	}

}
