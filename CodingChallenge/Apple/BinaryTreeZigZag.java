// 103. Binary Tree Zigzag Level Order Traversal
package tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

public class BinaryTreeZigZag {

	public static void main(String[] args) {
		//create binary search tree
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(50);
		bst.insert(100);
		bst.insert(1);
//		bst.validateBST();
		List<List<Integer>> list = zigzagLevelOrder(bst.root);
		list.forEach(System.out::println);
	}

	
	public static List<List<Integer>> zigzagLevelOrder(Node root) {
        //creat list for passing 
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //root is not null        
        if(root != null){
            //create two stack one for current level and another for secondary level
            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();
            //add node to currentLevel at starting point
            currentLevel.push(root);
            //create helper method for recursion call and pass currentLevel, nextLevel and list for traversal, pass boolean for left right
            helper(currentLevel, nextLevel, list, true);
            
                
        }
        //root is null return something
        return list;
    }

	private static void helper(Stack<Node> currentLevel, Stack<Node> nextLevel, List<List<Integer>> list, boolean leftToRight) {

		//create list to add value to list
		List<Integer> l = new ArrayList<>();
		
		//run loop till currentLevel stack is not empty 
		while(!currentLevel.isEmpty()){
			Node currentNode = currentLevel.pop();
			l.add(currentNode.value);
			//True means Left to Right
			if(leftToRight){
				//if left is not null then add that to nextLevel Stack
				if(currentNode.leftChild != null) nextLevel.push(currentNode.leftChild);
				//if right is not null then add that to nextLevel Stack
				if(currentNode.rightChild != null) nextLevel.push(currentNode.rightChild);
			}
			//false means right to left
			else{
				//if right is not null then add that to nextLevel Stack				
				if(currentNode.rightChild != null) nextLevel.push(currentNode.rightChild);
				//if left is not null then add that to nextLevel Stack
				if(currentNode.leftChild != null) nextLevel.push(currentNode.leftChild);
			}
			//if currentLevel is empty then swap the current level to nextLevel
			if(currentLevel.isEmpty()){
			
				leftToRight = !leftToRight;
			
				//swap the list
//				swap(currentLevel, nextLevel);
				Stack<Node> temp= currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
				//Add list to outter list
				list.add(l);
				//make inner list empty
				l = new ArrayList<>();
				
			}

			
		}
		
	}

	//swap the element
	private static void swap(Stack<Node> currentLevel, Stack<Node> nextLevel) {
		Stack<Node> temp= currentLevel;
		currentLevel = nextLevel;
		nextLevel = temp;
	}

}
