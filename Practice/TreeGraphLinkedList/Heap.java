package practiceProblem.graph;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	public static void main(String[] args) {
		heapActivity heap = new heapActivity(1);
		
		heap.insert(4);
		heap.insert(1);
		heap.insert(6);
		heap.insert(5);
		heap.insert(2);
		heap.insert(3);
		heap.print();
	}
}

// [0,1,2,3,4,5]
// n = n2+1, n2+2;
// (n-1)2 (n-2)/2
class heapActivity {
	private int heapType;
	private List<Integer> list;

	/**
	 * @param heapType
	 */
	public heapActivity(int heapType) {
		super();
		this.heapType = heapType;
		list = new ArrayList<Integer>();

	}

	public void insert(int number) {
		list.add(number);
		if (list.size() > 1) {
			bubbleUp(list.size() - 1);
		}
	}
	
	public void removePeek(int number){
		swap(0,list.size()-1);
		bubbleDown(0);
	}

	private void bubbleDown(int i) {
		int childOne = i*2+1, childTwo = i*2+2;
//		while(
//				(
//						heapType == 0 &&
//				(
//						(childOne < list.size() && list.get(i)>list.get(childOne)) || 
//						(childTwo < list.size() && list.get(i)>list.get(childTwo))				
//				)
//				) 
//				|| 
//				(
//						heapType == 1 && 
//				(
//						(childOne < list.size() && list.get(i)<list.get(childOne)) || 
//						(childTwo < list.size() && list.get(i)<list.get(childTwo))
//				)
//				)
//				){
//				
//			
//		}
	}

	public void print() {
		System.out.println(list);
	}

	private void bubbleUp(int i) {

		int parentIndex = i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2;

		while (parentIndex >= 0 && ((heapType == 0 && list.get(i) < list.get(parentIndex))
				|| (heapType == 1 && list.get(i) > list.get(parentIndex)))) {
			swap(i, parentIndex);
			i = parentIndex;
			parentIndex = i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2;
		}
	}

	private void swap(int i, int parentIndex) {
		int temp = list.get(i);
		list.set(i, list.get(parentIndex));
		list.set(parentIndex, temp);
	}

}
