
/**
 * Class that implements an array-based queue.
 * 
 * @author Mark Allen Weiss. Modified by Pablo Romero 2010. Modified by Bill Keller 2011/2012
 * @version Jan 30th 2012
 */
public class Queue 
{
    private Object[ ] theArray;
    private int        currentSize;
    private int        front;
    private int        rear;

    private static final int DEFAULT_CAPACITY = 3;

    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
        theArray = new Object[DEFAULT_CAPACITY];
        currentSize = 0;
        front = 0;
        rear = 0;
    }

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return currentSize == 0;
    }


    /**
     * Insert a new item into the queue.
     * @param item the item to insert.
     */
    public void enqueue(Object item)
    {
        if(currentSize == theArray.length) {
            doubleQueue();
        }
        theArray[rear] = item;
        rear = increment(rear);
        currentSize++;
    }

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public Object dequeue() throws UnderflowException
    {
        if( isEmpty() ) {
            throw new UnderflowException("ArrayQueue remove");
        }
        currentSize--;
        Object frontItem = theArray[front];
        front = increment(front);
        return frontItem;
    }
    
    
    
    /**
     * Internal method to increment with wraparound.
     * @param x any index in theArray's range.
     * @return x+1, or 0 if x is at the end of theArray.
     */
    private int increment(int x)
    {
        /*
        if(++x == theArray.length)
            x = 0;
        return x;
        */
       return ++x % theArray.length;
    }
    

    /**
     * Internal method to expand theArray.
     */
    private void doubleQueue()
    {
        Object[] newArray = new Object[theArray.length * 2];

        // Copy elements that are logically in the queue
        for(int i = 0; i < currentSize; i++, front = increment(front))
            newArray[i] = theArray[front];

        theArray = newArray;
        front = 0;
        rear = currentSize;
    }

    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     * @author Mark Allen Weiss
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