import java.util.NoSuchElementException;
/**
 * DoublyLinkedList provides an implementation of a doubly linked list. The 
 * implementation currently supports basic insertion and removal operations
 * 
 * @author Bill Keller
 * @version Jauary 2011
 */
public class DoublyLinkedList
{
    private ListNode header; 
    private ListNode trailer; 
    private int size;
 
    public DoublyLinkedList(){ 
      header = new ListNode(null, null, null);
      trailer = new ListNode(null, null, null);
      header.setNext(trailer);
      trailer.setPrev(header);
      size = 0;
    } 
    
    public void addAfter(ListNode b, ListNode n) {
        ListNode a;
        a = b.getNext(); // node after m
        n.setPrev(b);
        n.setNext(a);
        a.setPrev(n);
        b.setNext(n);
        size++;
    }
    
    public void remove(ListNode n) {
        ListNode b, a;
        b = n.getPrev(); //node before n  
        a = n.getNext(); // node after n
        a.setPrev(b);
        b.setNext(a);
        n.setPrev(null);
        n.setNext(null);
        size--;
    } 
    
    public void addFirst(ListNode n) {
        addAfter(header, n);
    }
    
    public void addLast(ListNode n) {
        addAfter(trailer.getPrev(), n);
    }
    
    public ListNode removeFirst() throws NoSuchElementException {
        ListNode first = null;
        if (header.getNext() == trailer) { //empty list
            throw new NoSuchElementException();
        } else {
            first = header.getNext();
            remove(first);
        }
        return first;
    }
    
    public ListNode removeLast() throws NoSuchElementException {
        ListNode last = null;
        if (header.getNext() == trailer) { //empty list
            throw new NoSuchElementException();
        } else {
            last = trailer.getPrev();
            remove(last);
        }
        return last;
    }

}