
/**
 * MapEntry represents a single key-value map entry
 * 
 * @author Bill Keller 
 * @version March 14th 2013
 */
public class MapEntry
{

    private Object key;
    private Object val;

    /**
     * Constructor for objects of class MapEntry
     */
    public MapEntry()
    {
        key = null;
        val = null;
    }

    /**
     * Constructor for objects of class MapEntry. Builds a map entry with 
     * the specified key and value.
     * 
     * @param k key
     * @param v value
     */
    public MapEntry(Object k, Object v)
    {
        key = k;
        val = v;
    }

    /**
     * Get the key of the entry.
     * 
     * @return the key
     */
    public Object getKey() 
    {
        return key;
    }

    /**
     * Get the value of the entry
     * 
     * @return the value
     */
    public Object getVal()
    {
        return val;
    }
}
