package Fortinet;

public class ReverseList {

	public ReverseList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseList rl = new ReverseList();
		Node head = new Node();
		head.value = 1;
		head.next = null;
		Node second = new Node();
		second.value = 2;
		head.next = second;
		Node third = new Node();
		third.value = 3;
		second.next = third;
		rl.print(rl.reverseList(head));
		Singleton o = Singleton.getInstance();
		
	}
	
	public Node reverseList(Node head){
		if (head == null) return null;
		Node prev = null;
		Node curr = head;
		Node next = head.next;
		while(curr != null){
			curr.next = prev;
			prev = curr;
			curr = next;
			if(next != null) next = next.next;			
		}
		return prev;
	}
	
	public void print(Node head){
		while(head!=null){
			System.out.println(head.value);
			head = head.next;
		}
	}

	
}
class Node {
	Node next;
	int value;		
}