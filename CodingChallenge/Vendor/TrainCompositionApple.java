package tries;

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {
	Deque<Integer> deque = new LinkedList<>();
	
	public void attachWagonFromLeft(int wagonId) {
		deque.addLast(wagonId);
	}

	public void attachWagonFromRight(int wagonId) {
		deque.addFirst(wagonId);
	}

	public int detachWagonFromLeft() {
		if(deque.size() > 0){
			return deque.removeLast();
		}
		return 0;
	}

	public int detachWagonFromRight() {
		if(deque.size() > 0){
			return deque.removeFirst();
		}
		return 0;
	}

	public static void main(String[] args) {
		TrainComposition tree = new TrainComposition();
		tree.attachWagonFromLeft(7);
		tree.attachWagonFromLeft(13);
		System.out.println(tree.detachWagonFromRight()); // 7
		System.out.println(tree.detachWagonFromLeft()); // 13
	}

}
