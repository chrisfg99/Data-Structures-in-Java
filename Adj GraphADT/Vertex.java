
/**
 * A class to create a vertex that will hold a value for a graph
 *
 * 184521
 */
public class Vertex
{
    private String vertexName;

    /**
     * Constructor for the vertex class that takes a single value
     */
    public Vertex(String vertexName)
    {
        // initialise instance variables
        this.vertexName=vertexName;
    }

    /**
     * Returns the value/name of the vertex
     */
    public String getName(){
        // put your code here
        return vertexName;
    }
    
    /**
     * Sets the value/name of the vertex to a new one
     */
    public void setName(String vertex)
    {
        vertexName=vertex;
    }
}
