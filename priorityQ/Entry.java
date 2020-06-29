
/**
 * Write a description of class Entry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entry
{
    // instance variables - replace the example below with your own
    private int key;
    private Object value;

    /**
     * Constructor for objects of class Entry
     */
    public Entry(int k, Object v)
    {
       key = k;
       value = v;
    }

    public int getKey() {
        return key;
    }
    
    public Object getValue() {
        return value;
    }
        
}
