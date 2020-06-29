
/**
 * Class to create an edge that will join two vertex's
 *
 * 184521
 */
public class Edge
{
    // instance variables - replace the example below with your own
    private String label;
    private Vertex v1;
    private Vertex v2;

    /**
     * Constructor for objects of class Edge
     */
    public Edge(Vertex v1,Vertex v2,String label)
    {
        // initialise instance variables
        this.label=label;
        this.v1=v1;
        this.v2=v2;
    }

    /**
     * Changes the name of the edge
     */
    public void setEdgeLabel(String name)
    {
        // put your code here
        this.label=label;
    }
    
    /**
     * Gives the name of the edge
     */
    public String getEdgeName()
    {
        return label;
    }
    
    /**
     * Gives the first vertex of the edge
     */
    public Vertex getVertexOne()
    {
        return v1;
    }
    
    /**
     * Gives the second vertex of the edge
     */
    public Vertex getVertexTwo()
    {
        return v2;
    }
    
    /**
     * Changes the first vertex to another one 
     */
    public void setVertexOne(Vertex verName)
    {
        v1=verName;
    }
    
    /**
     * Changes the second vertex to another one
     */
    public void setVertexTwo(Vertex verName)
    {
        v2=verName;
    }
}
