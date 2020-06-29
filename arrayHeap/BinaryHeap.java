
/**
 * Class BinaryHeap provides a simple array based representation of a 
 * binary heap data structure. The implementation is limited to integer
 * keys.
 * 
 * @author Bill Keller 
 * @version April 29th 2012
 */
public class BinaryHeap
{
    private int[] heap; // a heap is represented as an array of integer keys
    private static final int DEFAULT_CAPACITY = 8;
    private int currentSize;

    /**
     * Basic constructor for objects of class BinaryHeap
     */
    public BinaryHeap()
    {
        // initialise instance variables
        heap = new int[DEFAULT_CAPACITY];
        currentSize = 0;
    }

    /**
     * Insert a new integer key into the heap. The new key is initially added as 
     * the last node of the heap. The item is then 'bubbled up' the heap, as 
     * necessary, to restore the heap order property. 
     * 
     * The array storage is doubled if necessary.
     * 
     * @param key the integer to insert.
     */
    public void insert(int key)
    {
        if(currentSize == heap.length) {
            doubleHeap();
        }
        upHeapBubble(currentSize, key); // bubble data up heap as necessary
        currentSize++;
    }
    
    /**
     * Remove the minimum elelement from the heap. Restructure the heap to 
     * restore the heap order property. 
     * 
     * @return the minimum key
     */
    public int removeMin() 
    {
        if (currentSize <= 0) {
            throw new UnderflowException("BinaryHeap removeMin");
        }
        int min = heap[0]; // get minimum key from root
        heap[0] = heap[currentSize-1]; // assign key at last node to root
        downHeapBubble();   // push key at root down heap to restore heap order
        currentSize--;
        return min;
    }
    
    public void reset() {
        currentSize = 0;
    }
    
    /*
     * Internal method to bubble newly inserted key up heap to ensure that the heap order 
     * property is maintained.
     */
    private void upHeapBubble(int node, int key) {
        int parent = parent(node);
        heap[node] = key;
        while(key < heap[parent]) { //while key at parent is less than new key do
            heap[node] = heap[parent];
            heap[parent] = key;
            node = parent;
            parent = parent(node);
        }
    }
    
    /*
     * Internal method to calculate index of parent node from that of a child.
     * Will return 0 for the 'parent' of root.
     */
    private int parent(int node) {
        return (node == 0) ? 0 : (node-1)/2; 
    }
    
    /*
     * Internal method to bubble key down the heap to ensure the heap order is 
     * re-established after a removal operation.
     */
    private void downHeapBubble()
    {
        int key = heap[0];
        int index = 0;
        int newIndex = nextIndex(0,key);
        while (newIndex > index) {
            key = heap[index];
            heap[index] = heap[newIndex];
            heap[newIndex] = key;
            index = newIndex;
            newIndex = nextIndex(index,key);
        }              
    }
     
    /*
     * Internal method to identify where key should be placed to ensure local 
     * heap order is maintained. If a node has no children or no child with 
     * smaller key, then just return index. Otherwise, return index of child 
     * with smallest key.
     */
    private int nextIndex(int index, int key) {
        int left = 2 * index + 1;   // left child is at this position in array
        int right = left + 1;       // right child is at position left + 1
        if ( left >= currentSize ) {    // there are no children
            return index;            
        } else if ( right >= currentSize ) { // left child only
            return (key > heap[left]) ? left : index;
        } else if (key > heap[left] || key > heap[right]) { 
            return (heap[left] < heap[right]) ? left : right;
        } else { // key is not bigger than either left or right keys.
            return index;
        }
    }
        
    
    /*
     * Internal method to expand heap storage.
     */
    private void doubleHeap()
    {
        int[] newHeap = new int[heap.length * 2];

        // Copy elements from heap to newHeap
        for(int i = 0; i < currentSize; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }
    
    /*
     * Underflow exception class.
     */
    private class UnderflowException extends RuntimeException
    {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public UnderflowException(String message)
        {
            super(message);
        }
    }
}
