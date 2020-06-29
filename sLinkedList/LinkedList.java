import java.util.NoSuchElementException;
/**
 * LinkedList: a basic implementation of a singly linked list data structure. 
 * A linked list is a chain of ListNode objects. The head of the list is the 
 * first node of the chain (or null in the case of an empty list).
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class LinkedList
{
  // a linked list has a head node and a size
  private ListNode head;
  private int size;

  /**
   * Construct a new empty list
   */
  public LinkedList() {
    head = null;
    size = 0;
  }

  /**
   * Add a new item as the first element
   * @param ListNode node
   */
  public void addFirst(ListNode node) {
    node.setNext(head);
    head = node;
    ++size;
  }

  /**
   * Remove the first list item
   */
  public ListNode removeFirst() {
    ListNode first = head;
    // report error if list empty
    if (head == null) {
      throw new NoSuchElementException();
    } 
    // otherwise remove the item
    else {
      ListNode temp = head;
      head = head.getNext();
      temp.setNext(null);
      size--;
    }
    return first;
  }

}
