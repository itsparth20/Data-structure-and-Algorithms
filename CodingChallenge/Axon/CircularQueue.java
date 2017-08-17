package Axon;

import java.util.Arrays;

public class CircularQueue {
	private int[] queue;
	private int size, begin = -1, end = -1;

	public synchronized void initialize(int size) {
		queue = new int[size];
		this.size = size;
	}

	public synchronized void enqueue(int item) {
		if (begin == -1) {
			begin += 1;
			end += 1;
			queue[end] = item;
		}
		else if((begin == 0 && end == size - 1) || (end == begin - 1))
			System.out.println("Queue is full");
		 else if (end == size - 1 && begin != 0) {
			end = 0;
			queue[end] = item;
		} else {
			end++;
			queue[end] = item;
		}
	}

	public synchronized int dequeue() {
		if (begin == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		int value = queue[begin];
		queue[begin] = Integer.MIN_VALUE;
		if (begin == end)
	    {
	        begin = -1;
	        end = -1;
	    }
		else if (begin+1 == size)
	        begin = 0;
	    else
	        begin++;		
		return value;
	}
	
	public static void main(String[] args){
		CircularQueue obj = new CircularQueue();
		obj.initialize(2);
		obj.dequeue();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		obj.dequeue();
		obj.enqueue(3);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		System.out.println(Arrays.toString(obj.queue));
	}

}
