import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

	private int count;
	private BinaryTreeNode<T> root; 

	public LinkedBinaryTree() {

		count = 0;
		root = null;
	}

	public LinkedBinaryTree (T element) {
		count = 1;
		root = new BinaryTreeNode<T> (element);
	}
	
	public BinaryTreeNode<T> getRoot() {
		
		return(root);
	}
	
	public void setRoot(BinaryTreeNode<T> root) {
		
		this.root = root;
	}

	public boolean isEmpty() {

		return count == 0; 
	}

	public int size() {

		return count;
	}

	public boolean contains (T targetElement) {

		return findAgain(targetElement,root) != null ;
	}

	public T find(T targetElement) throws ElementNotFoundException {

		BinaryTreeNode<T> current = findAgain(targetElement,root);

		if( current == null )
			throw new ElementNotFoundException("binary tree");

		return (current.getElement());
	}

	/**
	 * Returns a reference to the specified target element if it is
	 * found in this binary tree.
	 *
	 * @param targetElement  the element being sought in this tree
	 * @param next           the element to begin searching from
	 */
	private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {
		
		if (next == null)
			return null;

		if (next.getElement().equals(targetElement))
			return next;

		BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

		if (temp == null)
			temp = findAgain(targetElement, next.getRight());

		return temp;
	}

	/**
	 * Returns a string representation of this binary tree.
	 *
	 * @return  a string representation of this binary tree
	 */
	public String toString() {
		String s = "";
		
		Iterator<T> list ;
		
		list = iteratorInOrder();
		while (list.hasNext()) {
			s += list.next().toString();
		}
		return s;
	}

	/**
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with
	 * the root.
	 *
	 * @return  an in order iterator over this binary tree
	 */
	public Iterator<T> iteratorInOrder() {
		
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		inorder (root, tempList);

		return tempList.iterator();
	}

	/**
	 * Performs a recursive inorder traversal.
	 *
	 * @param node      the node to be used as the root for this traversal
	 * @param tempList  the temporary list for use in this traversal
	 */
	protected void inorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {

		if (node != null) {
			inorder (node.getLeft(),tempList);
			tempList.addToRear(node.getElement());
			inorder (node.getRight(),tempList);
		}
	}

	/**
	 * Performs an preorder traversal on this binary tree by calling 
	 * an overloaded, recursive preorder method that starts with
	 * the root.
	 *
	 * @return  an pre order iterator over this tree
	 */
	public Iterator<T> iteratorPreOrder() {
		
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		preorder(root, tempList);

		return tempList.iterator(); 
	}

	/**
	 * Performs a recursive preorder traversal.
	 *
	 * @param node  the node to be used as the root for this traversal
	 * @param tempList  the temporary list for use in this traversal
	 */
	protected void preorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		
		if (node != null) {
			tempList.addToRear(node.getElement());
			preorder(node.getLeft(),tempList);
			preorder(node.getRight(),tempList);
		}
	}

	/**
	 * Performs an postorder traversal on this binary tree by calling
	 * an overloaded, recursive postorder method that starts
	 * with the root.
	 *
	 * @return  a post order iterator over this tree
	 */
	public Iterator<T> iteratorPostOrder() {
		
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		postorder(root, tempList);

		return tempList.iterator();
	}

	/**
	 * Performs a recursive postorder traversal.
	 *
	 * @param node      the node to be used as the root for this traversal
	 * @param tempList  the temporary list for use in this traversal
	 */
	protected void postorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		
		if (node != null) {
			postorder(node.getLeft(),tempList);
			postorder(node.getRight(),tempList);
			tempList.addToRear(node.getElement());
		}
	}
}

