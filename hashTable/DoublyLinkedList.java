import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * DoublyLinkedList provides an implementation of a doubly linked list. The 
 * implementation currently supports basic insertion and removal operations
 * 
 * @author Bill Keller
 * @version January 2011
 */
public class DoublyLinkedList implements Iterable<ListNode>
{
    private ListNode header; 
    private ListNode trailer; 
    private int size;
 
    public DoublyLinkedList() { 
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
    
    public void removeFirst() throws NoSuchElementException {
        if (header.getNext() == trailer) { //empty list
            throw new NoSuchElementException();
        } else {
            remove(header.getNext());
        }
    }
    
    public void removeLast() throws NoSuchElementException {
        if (header.getNext() == trailer) { //empty list
            throw new NoSuchElementException();
        } else {
            remove(trailer.getPrev());
        }
    }
    
    public int size()
    {
        return size;
    }
    
    /**
     * Constructs an iterator over list nodes in the doubly linked list. 
     * Supports methods for iterating through the nodes.
     * 
     * @return iterator over ListNode objects
     */
    public Iterator<ListNode> iterator()
    {
        // declare an anonymous inner class of type Iterator<ListNode> 
        // construct a single instance of the class
        Iterator<ListNode> it = new Iterator<ListNode>() {
            private ListNode currentNode = header;
            
            public boolean hasNext() {
                return currentNode.getNext() != trailer;
            }
            
            public ListNode next() {
                currentNode = currentNode.getNext();
                return currentNode;
            }
            
            public void remove() {
                // this method not implemented         
            }
        };
        return it;
    }
        

}