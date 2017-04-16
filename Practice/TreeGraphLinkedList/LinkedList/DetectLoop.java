package practiceProblem.LinkedList;

public class DetectLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		Node rootNext = new Node(2);
		root.next = rootNext;
		rootNext.next = root;
		DetectLoop obj = new DetectLoop();
		System.out.println(obj.detectLoop(root));

	}

	public boolean detectLoop(Node head) {
		// Add code here
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}
}
