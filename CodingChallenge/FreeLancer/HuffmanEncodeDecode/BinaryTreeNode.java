public class BinaryTreeNode<T> {
	
   private T element;
   private BinaryTreeNode<T> left, right;

   BinaryTreeNode (T element) {
	   
      this.element = element;
      left = null;
      right = null;
   }
   
   public T getElement() {
	   
	   return element ;
   }
   
   public void setElement(T element) {
	   
	   this.element = element ;
   }
   
   public BinaryTreeNode<T> getRight() {
	   
	   return right ;
   }
   
   public BinaryTreeNode<T> getLeft() {
	   
	   return left ;
   }
   
   public void setRight(BinaryTreeNode<T> right) {
	   
	   this.right = right ;
   }
   
   public void setLeft(BinaryTreeNode<T> left) {
	   
	   this.left = left ;
   }
   
   public boolean isLeaf() {
	   
	   return left == null && right == null ;
   }

   public int numChildren() {
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;
   }
}