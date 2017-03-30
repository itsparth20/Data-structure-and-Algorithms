package practiceProblem.graph;

public class Tree {
	int value;
	Tree leftNode;
	Tree rightNode;
	/**
	 * @param value
	 */
	public Tree(int value) {
		super();
		this.value = value;
		leftNode = null;
		rightNode = null;
	}
	/**
	 * @param value
	 * @param leftNode
	 * @param rightNode
	 */
	public Tree(int value, Tree leftNode, Tree rightNode) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	/**
	 * @param leftNode
	 * @param rightNode
	 */
	public Tree(Tree leftNode, Tree rightNode) {
		super();
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Tree getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Tree leftNode) {
		this.leftNode = leftNode;
	}
	public Tree getRightNode() {
		return rightNode;
	}
	public void setRightNode(Tree rightNode) {
		this.rightNode = rightNode;
	}
		
}
