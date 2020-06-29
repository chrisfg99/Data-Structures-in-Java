
/**
 * Write a description of class ListNode here.
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class ListNode
{
    private Object data;
    private ListNode next;

  ListNode(Object data, ListNode next) {
    this.data = data;
    this.next = next;
  }
  
  public void setNext(ListNode node) {
      next = node;
  }
  
  public ListNode getNext() {
      return next;
  }
  
  public Object getData() {
      return data;
  }

}
