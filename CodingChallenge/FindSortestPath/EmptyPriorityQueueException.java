/**
 * @author CS1027
 *
 *  Exception thrown when the priority queue is empty
 */

public class EmptyPriorityQueueException extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message.
   * @param message String representing the error encountered
   */
  public EmptyPriorityQueueException (String message) {
    super (message);
  }
}
