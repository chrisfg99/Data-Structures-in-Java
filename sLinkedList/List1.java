
/**
 * Write a description of class TestLinkedList here.
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class List1 {

    private LinkedList myList;
      
    public List1() {   
        myList = new LinkedList();
        // Now add some items to the List
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(-5);
        myList.addFirst(new ListNode(i1, null));
        myList.addFirst(new ListNode(i2, null));
    }
}
