
/**
 * ListNode implements a node for a singly-linked list
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class ListNode
{
    // A node stores some data and a pointer to the next node 
    private Object data;
    private ListNode next;

    /**
     * Construct a new node with the given data and pointer
     * @param Object data
     * @param ListNode next
     */
    ListNode(Object data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Set the next node to be the given node
     * @param ListNode node
     */
    public void setNext(ListNode node) {
        next = node;
    }

    /**
     * Get the next node
     * @return the next ListNode
     */
    public ListNode getNext() {
        return next;
    }

}
