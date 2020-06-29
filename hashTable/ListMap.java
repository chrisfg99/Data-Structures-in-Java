import java.util.Iterator;
/**
 *  ListMap implements a simple Map data structure. The implementation is 
 *  based on a doubly-linked list and consequently suitable only for small
 *  maps as run-time of basic operation is linear in number of entries.
 * 
 * @author Bill Keller 
 * @version March 15th 2013
 */
public class ListMap
{

    private DoublyLinkedList entries;
    private int size;

    /**
     * Constructor for objects of class ListMap
     */
    public ListMap()
    {
        entries = new DoublyLinkedList();
        size = 0;
    }

    /**
     * Put a key-value pair entry into the map. Keys and values may be arbitrary objects.
     * If there exist and entry with the specified key, over-write it, but return the
     * old value. Otherwise, return null.
     * 
     * @param k key
     * @param v value
     * @return old value or null
     */
    public Object put(Object k, Object v)
    {
        Iterator<ListNode> nodeSet = entries.iterator();
        ListNode node;
        while(nodeSet.hasNext()) {
            node = nodeSet.next();
            MapEntry entry = (MapEntry) node.getData();
            if (entry.getKey().equals(k)) {
                Object val = entry.getVal(); // get old value
                node.setData(new MapEntry(k,v)); // replace entry
                return val; // return old value
            }
        }
        entries.addLast(new ListNode(new MapEntry(k,v), null, null));
        size++;
        return null;
    }
    
    /**
     * Returns the value associated with the key k in the map, if an entry exists. 
     * Returns null if that map contains no entry with key k.
     * 
     * @param k key
     * @return value associated with k, or null
     */
    public Object get(Object k)
    {
        Iterator<ListNode> nodeSet = entries.iterator();
        ListNode node;
        while(nodeSet.hasNext()) {
            node = nodeSet.next();      // get next node
            MapEntry entry = (MapEntry) node.getData();
            if (entry.getKey().equals(k)) { // found key so..
                return entry.getVal();    //... return val 
            }
        }
        return null; // no entry with key k
    }
    /**
     * Not implemented!
     */
    public Object remove(Object k)
    {
        System.out.println("The remove(k) operation is not implemented!");
        return null;        // no entry with key k
    }
    
    
}
