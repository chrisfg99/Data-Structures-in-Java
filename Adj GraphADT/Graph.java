
/**
 * A class used to construct an adjacenecy graph ADT
 *
 * @184521
 */
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.Collection;
public class Graph implements GraphADT
{    
    // instance variables
    /**
     * Arraylist containing all vertices
     */
    public ArrayList<Vertex> vertices;
    /**
     * Arraylist containing all edges
     */
    public ArrayList<Edge> edges;
    /**
     * Constructor for objects of class Graph
     */
    public Graph(ArrayList<Vertex> inVertices, ArrayList<Edge> inEdges)
    {
        // initialise instance variables
        edges= new ArrayList<Edge>(10);
        vertices=new ArrayList<Vertex>(10);
        for(int i=0; i<=(inVertices.size()); i++){
            Vertex ver=inVertices.get(i);
            vertices.add(ver);
        }
        for(int i=0; i<=(inEdges.size()); i++){
            Edge edge=inEdges.get(i);
            edges.add(edge);
        }
    }

    /**
     * Constructor to create an empty graph
     */
    public Graph(){
        edges= new ArrayList<Edge>(10);
        vertices=new ArrayList<Vertex>(10);

    }

    /**
     * Checks if two vertices are adjacent
     */
    @Override
    public boolean areAdjacent(Vertex verName1,Vertex verName2){
        boolean b=false;
        if(vertices==null){
            System.out.println("no vertices");
            return false;
        }
        if(edges==null){
            System.out.println("no edges");
            return false;
        }
        else{
            for(int i=0;i<=edges.size()-1;i++){
                Edge e=edges.get(i);
                if(opposite(e,verName1)==verName2){
                    return true; 
                }
                else if(opposite(e,verName2)==verName1){
                    return true;
                }
            }
        }   
        return b;
    }

    /**
     * Get adjacent vertices
     */
    @Override
    public Vertex opposite(Edge edgeName,Vertex verName){
        if (edgeName.getVertexOne()== verName){
            return edgeName.getVertexTwo();
        }
        else if(edgeName.getVertexTwo()==verName){
            return edgeName.getVertexOne();
        }
        else{
            System.out.println("Vertex is not included in given edge");
            return null;
        }
    }

    /**
     * Add vertex to ArrayList
     */
    @Override
    public Vertex insertVertex(String verName){
        //will add the a new vertex
        Vertex v =new Vertex(verName);
        if(vertices.contains(v)){
            System.out.println("Vertex already exists");
        }
        else{
            vertices.add(v);
        }
        return v;
    }

    /**
     * Remove vertex from ArrayList
     */
    @Override
    public String removeVertex(Vertex v){
        String name=v.getName();
        if(vertices==null){
            System.out.println("no vertices");
        }
        else{
            for(int i=0; i<=edges.size()-1;i++){
                Edge e=edges.get(i);
                if(e.getVertexOne()==v){
                    e.setVertexOne(null);
                }
                if(e.getVertexTwo()==v){
                    e.setVertexTwo(null);
                }
            }
        }
        vertices.remove(v);
        return name;
    }

    /**
     * Add an edge
     */
    @Override
    public Edge insertEdge(Vertex v, Vertex w, String n){
        //add edge to edges
        Edge e=new Edge(v,w,n);
        if(edges.contains(e)){
            System.out.println("Edge already exists");
        }
        else{
            edges.add(e);
            //try adding vertices to vertices ArrayList
            insertVertex(e.getVertexOne().getName());
            insertVertex(e.getVertexTwo().getName());
        }
        return e;
    }

    /**
     * Remove an edge
     */
    @Override
    public String removeEdge(Edge edgeLabel){
        String e=edgeLabel.getEdgeName();
        if(edges==null){
            System.out.println("no edges");
        }
        else{
            //removes the edge object
            edges.remove(edges.indexOf(edgeLabel));
        }
        return e;
    }

    /**
     * Get a list of all the vertices
     */
    @Override
    public ArrayList<Vertex> vertices(){
        ArrayList<Vertex> lVer= new ArrayList<Vertex>();
        if(vertices==null){
            System.out.println("no vertices");
            System.exit(1);
        }
        lVer=vertices;
        return lVer;
    }

    /**
     * Get a list of all the edges
     */
    @Override
    public ArrayList<Edge> edges(){
        if(edges==null){
            System.out.println("no edges");
            System.exit(1);
        }
        ArrayList<Edge> lEdge= new ArrayList<Edge>();
        lEdge=edges;
        return lEdge;
    }

    /**
     * Rename a particular vertex
     */
    @Override
    public String rename(Vertex verName, String newName){
        String old=verName.getName();
        if(vertices==null){
            System.out.println("no vertices");
            return null;
        }
        else{
            //vertex is found and renamed
            verName.setName(newName);
            //if an edge contains this vertex it should automatically get updated
            return old;
        }
    }
    
    /**
     * Rename a particular edge
     */
    @Override
    public String rename(Edge edgeLabel, String newName){
        String old=edgeLabel.getEdgeName();
        if(edges==null){
            System.out.println("no edges");
            return null;
        }
        else{
            //vertex is found and renamed
            edgeLabel.setEdgeLabel(newName);
            //if an edge contains this vertex it should automatically get updated
            return old;
        }
    } 

    /**
     * Gives any incident edges of a given vertex
     */
    @Override
    public ArrayList<Edge> incidentEdges(Vertex verName){
        if(edges==null){
            System.out.println("no vertices");
            System.exit(1);
        }
        ArrayList<Edge> lEdge=new ArrayList<Edge>();
        for(int i=0; i<=edges.size()-1;i++){
            Edge e=edges.get(i);
            if(e.getVertexOne()==verName&&lEdge.contains(e)==false){
                lEdge.add(e);
            }
            if(e.getVertexTwo()==verName&&lEdge.contains(e)==false){
                lEdge.add(e);
            }
        }
        return lEdge;
    }

    
    //Specialist Rail Network Methods
    /**
     * Perform a breadth-first traversal of the rail network, starting from a given station.
     */
    public void bftraverse(Vertex v){
        Queue<Vertex> queue= new LinkedList<Vertex>();
        Queue<Edge> visited= new LinkedList<Edge>();
        queue.add(v);
        while(queue.isEmpty()==true){
            Vertex ver=queue.remove();
            System.out.println(ver.getName()+" ");
            for(int i=0; i<=edges.size();i++){
                Edge e=edges.get(i);    
                if(e.getVertexOne()==ver&&visited.contains(e)==false){
                    visited.add(e);
                    queue.add(e.getVertexTwo());
                }
                if(e.getVertexTwo()==ver&&visited.contains(e)==false){
                    visited.add(e);
                    queue.add(e.getVertexOne());
                }
            }
        }
    }

    /**
     * Perform a breadth-first traversal of the whole rail network
     */
    public void bftraverse(){
        Queue<Vertex> queue= new LinkedList<Vertex>();
        Queue<Edge> visited= new LinkedList<Edge>();
        if(vertices==null){
            System.out.println("no vertices");
            System.exit(1);
        }
        queue.add(vertices.get(0));
        while(queue.isEmpty()==true){
            Vertex ver=queue.remove();
            System.out.println(ver.getName()+" ");
            for(int i=0; i<=edges.size();i++){
                Edge e=edges.get(i);
                if(e.getVertexOne()==ver&&visited.contains(e)==false){
                    visited.add(e);
                    queue.add(e.getVertexTwo());
                }
            }
        }
    }

    /**
     * Return a list of all of the stations (vertices) that can be reached by rail when starting from v
     */
    public ArrayList<Vertex> allReachable(Vertex v){
        ArrayList<Vertex> lVer=null;
        ArrayList<Vertex> visitedVer= new ArrayList<Vertex>();
        ArrayList<Edge> visitedEdges= new ArrayList<Edge>();
        for(int i=0; i<=edges.size()-1;i++){
            Edge e=edges.get(i);
            if(e.getVertexOne()==v&&visitedEdges.contains(e)==false){
                visitedEdges.add(e);
                visitedVer.add(e.getVertexTwo());
            }
            else if(e.getVertexTwo()==v&&visitedEdges.contains(e)==false){
                visitedEdges.add(e);
                visitedVer.add(e.getVertexOne());
            }
        }
        return lVer=visitedVer;
    }

    /**
     * Return true if all the stations in the entire rail network can be reached from one another, and otherwise, return false
     */
    public boolean allConnected(){
        boolean b= false;
        Queue<Vertex> queue= new LinkedList<Vertex>();
        Queue<Vertex> visitedVer= new LinkedList<Vertex>();
        Queue<Edge> visitedEdges= new LinkedList<Edge>();
        if(vertices==null){
            System.out.println("no vertices");
            return true;
        }
        //start at root
        queue.add(vertices.get(0));
        Collection<Vertex> lVer= vertices();
        System.out.println(lVer);
        //create loop that can only be broken when queue is empty
        while(queue.isEmpty()==false){
            Vertex ver=queue.remove();
            System.out.println("Vertex"+ver.getName()+" ");

            for(int i=0; i<=edges.size()-1;i++){
                Edge e=edges.get(i);
                System.out.println("Edge"+e.getEdgeName()+" ");
                if(e.getVertexOne()==ver&&visitedVer.contains(e.getVertexOne())==false){
                    visitedEdges.add(e);
                    visitedVer.add(e.getVertexOne());
                    queue.add(e.getVertexTwo());
                }
                else if(e.getVertexTwo()==ver&&visitedVer.contains(e.getVertexTwo())==false){
                    visitedEdges.add(e);
                    queue.add(e.getVertexOne());
                }
            }
        }
        if(visitedVer.containsAll(lVer)){
            b=true;
        }
        System.out.println(lVer);
        System.out.println(visitedVer);
        return b;
    }

    /**
     * Given two stations u and v, return a shortest route (path) between them else return null
     */
    public ArrayList<Edge> mostDirectRoute(Vertex u, Vertex v){
        ArrayList<Edge> lEdge= new ArrayList<Edge>();
        Queue<Vertex> queue= new LinkedList<Vertex>();
        Queue<Edge> visited= new LinkedList<Edge>();
        ArrayList<Edge> path= new ArrayList();
        queue.add(u);
        Vertex ver;
        lEdge=null;
        while(queue.isEmpty()==false){
            System.out.println("loop 1 "+queue.isEmpty());
            ver=queue.remove();
            //loop moves through all edges
            for(int i=0; i<=edges.size()-1;i++){
                System.out.println("loop 2 "+i);
                Edge e=edges.get(i);
                //loops if edge has the vertex from q and has not already been visited
                if(e.getVertexOne()==ver&&visited.contains(e)==false){
                    System.out.println("loop 3 "+ver);
                    visited.add(e);
                    path.add(e);
                    ver=null;
                    if(e.getVertexTwo()==u){
                        //don't add to queue ending loop
                    }
                    else{
                        //add other vertex to queue
                        queue.add(e.getVertexTwo());
                    }
                }
                else if(e.getVertexTwo()==ver&&visited.contains(e)==false){
                    System.out.println("loop 3 "+ver);
                    visited.add(e);
                    path.add(e);
                    ver=null;
                    if(e.getVertexOne()==u){
                        //don't add to queue ending loop
                    }
                    else{
                        //add other vertex to queue
                        queue.add(e.getVertexOne());
                    }
                }                
                else{
                    //do nothing
                }
            }
            //if its the first run through than this will assign path to lEdge
            if(lEdge==null){
                System.out.println("new is longer");
                lEdge=path;
                path.removeAll(vertices());
            }    
            //if the path is not empty and is shorter than the previous path
            else if(path!=null&&(path.size())<=(lEdge.size())){
                System.out.println("new is shorter");
                lEdge=path;
            }
        }

        return lEdge;
    }

                    
                    
                    
                    
                    
}
