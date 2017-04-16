package practiceProblem.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveLoopInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		Node rootNext = new Node(2);
		root.next = rootNext;
		Node rootNextNext = new Node(3);
		rootNext.next = rootNextNext;
		Node rootNextNextNext = new Node(4);
		rootNextNext.next = rootNextNextNext;
		rootNextNextNext.next = rootNext;
		
		RemoveLoopInLinkedList removeLoopObj = new RemoveLoopInLinkedList();
		removeLoopObj.removeLoop(root);
		print(root);
	}

	private static void print(Node root) {
		// TODO Auto-generated method stub
		while(root!=null){
			System.out.println(root.data);
			root = root.next;
		}
	}

	private void removeLoop(Node head) {
		// TODO Auto-generated method stub
		Node slow = head;
		Set<Node> set = new HashSet<Node>();
		set.add(slow);
		while(slow!=null){
			if(set.add(slow.next)){
				
			}
			else{
				slow.next = null;
			}
			slow = slow.next;
		}
	}

}
