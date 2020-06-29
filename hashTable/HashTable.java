
/**
 * HashTable implements a simple hash table scheme.
 * 
 * @author Bill Keller 
 * @version March 2015
 */
public class HashTable
{
 
    private ListMap[] bucketArray;
    private int size;
    private int capacity;

    /**
     * Constructor for objects of class HashTable
     * 
     * @param capacity integer size of the bucket array
     */
    public HashTable(int capacity)
    {
        
        this.capacity = capacity;
        bucketArray = new ListMap[capacity];
        size = 0;
    }

    /**
     * Put a key value pair into the table.
     * 
     * @param key   a String
     * @param value an Object associated with the key
     * @return the value previously associated with key 
     * (or null if the hash table did not contain the key)
     */
    public Object put(String key, Object value)
    {
        int hash = hashFunction(key);
        if (bucketArray[hash] == null) {
            bucketArray[hash] = new ListMap();
        }
        Object val = bucketArray[hash].put(key,value); // delegate to list-based map
        if ( val == null ) { // only increment if new key
            size++;
        }
        return val;
    }
    
    /**
     * Get the value associated with a key. 
     * 
     * @param key a String
     * @return the value associated with the key 
     * (or null if the hash table doesn't contain the key)
     */
    public Object get(String key)
    {
        int hash = hashFunction(key);
        if (bucketArray[hash] == null) {
            bucketArray[hash] = new ListMap();
        }
        return bucketArray[hash].get(key); // delegate to list-based map
    }
    
    /**
     * hashFunction maps a String to an integer within the range 0 to capacity-1, 
     * where capacity is the size of the underlying bucket array.
     * 
     * @param key a String
     * @return an integer hash
     */
    protected int hashFunction(String key) 
    {
        return compress(hashCode(key));
    }
    
    /**
     * Method hashcode maps a String key to an integer code. The current 
     * implementation uses the polynomial accumulation method to generate 
     * a code. This method works well for String objects.
     * 
     * @param key the String key
     * @return the integer code
     */
    protected int hashCode(String key)
    {
        int a = 37;
        char[] chars = key.toCharArray();
        int p = 0;
        for (int i=chars.length-1; i >= 0; i--) {   // polynomial accumulation
            p = a * p + (int) chars[i];             // Horner's rule
        }
        return (p < 0) ? -p : p;
    }
    
    /**
     * Method compress takes the hash code and transforms it to an integer 
     * in the range 0 .. to capacity-1, where capacity is the size of the 
     * bucket array.
     * 
     * @param code the uncompressed hash code
     * @return an integer in the range 0 to capacity-1, inclusive.
     */
    protected int compress(int code) 
    {
        return code % capacity; // simple divide technique
    }
            
}
