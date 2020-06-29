

/**
 * Array-based implementation of the stack.
 ********************PUBLIC OPERATIONS*********************
 * void push( x )         --> Insert x
 * void pop( )            --> Remove most recently inserted item
 * ******************ERRORS********************************
 * pop on empty stack

 * @author Mark Allen Weiss. Adapted Bill Keller Jan 2011
 */

public class Stack {
    private static final int DEFAULT_CAPACITY = 500;
    private Object[] theArray;
    private int topOfStack;

    /**
     * Construct the stack.
     */
    public Stack() {
        theArray = new Object[ DEFAULT_CAPACITY ];
        topOfStack = -1;
    }

    /**
     * Remove the most recently inserted item in the stack.
     * @return the most recently inserted item in the stack.
     * @throws UnderflowException if the stack is empty.
     */
    public Object pop( ) {
        if( topOfStack < 0 ) {
            throw new UnderflowException( "Array Stack pop" );
        }
        else {
            Object topElement = theArray[ topOfStack ];
            topOfStack--;
            return topElement;
        }
    }

    /**
     * Insert a new item into the stack.
     * @param newElement the item to insert.
     */
    public void push( Object newElement ) {
        if( topOfStack+1 == theArray.length ) {
            throw new OverflowException("Array Stack push");
        } else {
            theArray[ ++topOfStack ] = newElement;
        }
    }


    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     * @author Mark Allen Weiss
     */
    private class UnderflowException extends RuntimeException {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public UnderflowException( String message ) {
            super( message );
        }
    }
    
    /**
     * Exception class for access in empty containers
     * such as stacks, queues, and priority queues.
     */
    private class OverflowException extends RuntimeException {
        /**
         * Construct this exception object.
         * @param message the error message.
         */
        public OverflowException( String message ) {
            super( message );
        }
    }
}

