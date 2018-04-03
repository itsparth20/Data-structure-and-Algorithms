package com.freelance.jin.main;

import com.freelance.jin.dao.PriorityQueueADT;
import com.freelance.jin.helper.EmptyPriorityQueueException;
import com.freelance.jin.helper.InvalidDataItemException;


public class DLPriorityQueue<T> implements PriorityQueueADT<T> {
    private PriorityNode<T> front;
    private PriorityNode<T> rear;
    private int count;
    public DLPriorityQueue() {
        this.count = 0;
        front = null;
        rear = null;
    }

    // enqueue the element in to queue
    @Override
    public void enqueue(T element, double priority) {
        PriorityNode<T> node = new PriorityNode<>(element, priority);
        if (rear == null && front == null) {
            rear = front = node;
        } else {
            rear.setNext(node);
            node.setPrevious(rear);
            rear = node;
        }
        count++;
    }

    // dequeue element from the queue
    @Override
    public T dequeue() throws EmptyPriorityQueueException {
        if (count == 0) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty");
        }
        PriorityNode<T> deletedNode = front;
        front = front.getNext();
        front.setPrevious(null);
        count--;
        if (count == 0) {
            front = rear = null;
        }
        deletedNode.setNext(null);
        return deletedNode.getDataItem();
    }

    // return the priority of the dataItem
    public double getPriority(T dataItem) throws InvalidDataItemException {
        PriorityNode<T> node = front;
        for (int i = 0; i < count; i++) {
            if (node.getDataItem().equals(dataItem)) {
                return node.getPriority();
            }
            node = node.getNext();
        }
        throw new InvalidDataItemException("DataItem is not available in PriorityQueue");
    }

    // return smallest element from the priority queue
    @Override
    public T getSmallest() throws EmptyPriorityQueueException {
        if (count == 0) {
            throw new EmptyPriorityQueueException("PriorityQueue is empty");
        }
        PriorityNode<T> node = front;
        PriorityNode<T> smallestNode = front;
        for (int i = 0; i < count; i++) {
            if (smallestNode.getPriority() > node.getPriority()) {
                smallestNode = node;
            }
            node = node.getNext();
        }
        count--;
        return removeNode(smallestNode);
    }

    // removed node from the PriorityQueue
    private T removeNode(PriorityNode<T> smallestNode) {
        if (smallestNode.getPrevious() != null) {
            smallestNode.getPrevious().setNext(smallestNode.getNext());
        }
        if (smallestNode.getNext() != null) {
            smallestNode.getNext().setPrevious(smallestNode.getPrevious());
        }
        if (smallestNode.equals(front)) {
            front = smallestNode.getNext();
        }
        if (smallestNode.equals(rear)) {
            rear = smallestNode.getPrevious();
        }
        smallestNode.setPrevious(null);
        smallestNode.setNext(null);
        return smallestNode.getDataItem();
    }

    // change priority of the element in PriorityQueue
    @Override
    public void changePriority(T element, double newPriority) throws InvalidDataItemException {
        PriorityNode<T> node = front;
        for (int i = 0; i < count; i++) {
            if (node.getDataItem().equals(element)) {
                node.setPriority(newPriority);
                return;
            }
            node = node.getNext();
        }
        throw new InvalidDataItemException("Element is not available in PriorityQueue");
    }

    // check that does PriorityQueue is empty or not
    @Override
    public boolean isEmpty() {
        return count == 0 ? true : false;
    }

    // return number of item in queue
    @Override
    public int numItems() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        PriorityNode<T> node = front;
        for (int i = 0; i < count; i++) {
            sb.append(node.getDataItem().toString());
            sb.append(" ");
            node = node.getNext();
        }
        return sb.toString();
    }
}
