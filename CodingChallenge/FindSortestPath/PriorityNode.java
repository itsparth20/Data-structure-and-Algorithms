package com.freelance.jin.main;

//POJO class to set the PriorityNode
public class PriorityNode<T> {
    private T dataItem;
    private PriorityNode<T> next;
    private PriorityNode<T> previous;
    private double priority;

    public PriorityNode(T data, double priority) {
        dataItem = data;
        this.priority = priority;
    }

    public PriorityNode() {

    }

    public void setDataItem(T dataItem) {
        this.dataItem = dataItem;
    }

    public void setNext(PriorityNode<T> next) {
        this.next = next;
    }

    public void setPrevious(PriorityNode<T> previous) {
        this.previous = previous;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public T getDataItem() {
        return dataItem;
    }

    public PriorityNode<T> getNext() {
        return next;
    }

    public PriorityNode<T> getPrevious() {
        return previous;
    }

    public double getPriority() {
        return priority;
    }
}
