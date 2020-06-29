/**
 * TestLinkedList simple example of use of the DoublyLinkedList implementation.
 * 
 * @author Bill Keller 
 * @version January 2011
 */
public class DLLTest {

    private DoublyLinkedList myList;
      
    public DLLTest() {   
        myList = new DoublyLinkedList();
        // Now add some items to the List
        String s1 = "bill";
        String s2 = "sam";
        String s3 = "jane";
        String s4 = "sue";
        myList.addFirst(new ListNode(s1, null, null));
        myList.addFirst(new ListNode(s2, null, null));
        myList.addLast(new ListNode(s3, null, null));
        myList.addLast(new ListNode(s4, null, null));
    }
}
