
/**
 * Basic implementation of a ListNode for constructing doubly linked lists
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class ListNode
{
    private Object data; 
    private ListNode prev; 
    private ListNode next; 

    public ListNode(Object data, ListNode prev,
                                 ListNode next){ 
        this.data = data; 
        this.prev = prev; 
        this.next = next; 
    } 
	
    public void setData(Object data) {
        this.data = data;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setNext(ListNode next) {
        this.next = next;
    }
    
    public ListNode getNext() {
        return next;
    }
    
    public void setPrev(ListNode prev) {
        this.prev = prev;
    }
    
    public ListNode getPrev() {
        return prev;
    }
    
}
