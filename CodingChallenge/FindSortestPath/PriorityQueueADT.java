/**
 * @author CS1027
 *
 *         Defines the interface of a priority queue
 */

public interface PriorityQueueADT<T> {
	/**
	 * Adds one element to the rear of the priority queue
	 * 
	 * @param element
	 *            to be added onto the priority queue
	 */
	public void enqueue(T element, double priority);

	/**
	 * Rmoves the element from the front of the priority queue
	 * 
	 * @return element removed from the front of the queue
	 */
	public T dequeue() throws EmptyPriorityQueueException;

	/**
	 * Removes and returns the element from the priority queue with smallest
	 * priority
	 * 
	 * @return T smallest priority element removed from the priority queue
	 */
	public T getSmallest() throws EmptyPriorityQueueException;

	/**
	 * Updates the priority of the given element to the new value
	 * 
	 * @param element
	 *            whose priority is to be changed
	 * @param newPriority
	 *            value of the new priority for this element
	 */
	public void changePriority(T element, double newPriority) throws InvalidDataItemException;

	/**
	 * Returns true if this priority queue contains no elements.
	 * 
	 * @return boolean whether or not this priority queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this priority queue.
	 * 
	 * @return int number of elements in this priority queue
	 */
	public int numItems();

	/**
	 * Returns a string representation of this priority queue.
	 * 
	 * @return String representation of this priority queue
	 */
	public String toString();
}
