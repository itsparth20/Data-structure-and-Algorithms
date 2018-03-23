/**
 * @author CS1027
 *
 *  Exception thrown when a specified element is not in the priority queue
 */

public class InvalidElementException extends RuntimeException {
  /**
   * Sets up this exception with an appropriate message.
   * @param message String representing the error encountered
   */
  public InvalidElementException (String message) {
    super (message);
  }
}
