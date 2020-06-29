
/**
 * Represents a binary search tree structure. This implementation makes the simpliying assumption
 * that all keys are integers. The code as given here only implements the put(k,v) method of the binary
 * search tree ADT. Other operations are left as exercises.
 * 
 * @author Bill Keller 
 * @version March 2013
 */
public class BinarySearchTree
{
    private BinaryTree tree;

    /**
     * Construct an empty binary search tree.
     */
    public BinarySearchTree()
    {
        tree = new BinaryTree();
        try {
            tree.addRoot(null);
        } catch (Exception e) {}       
    }
    
    /**
     * Construct a binary search tree storing a set of integer 'keys'. Each integer i is stored as 
     * an entry of the form (i,true). 
     * 
     * @param keys an array of integers to be stored in the tree.
     */
    public BinarySearchTree(int[] keys)
    {
        tree = new BinaryTree();
        try {
            tree.addRoot(null);
        } catch (Exception e) {}   
        for(int i=0; i<keys.length; i++) {
            put(keys[i],true);
        } 
    }

    
    /**
     * Insert a key-value entry into the tree. The method searches for an existing entry with 
     * key k and if found this is replaced by the new key-value entry. If the key is not found, the
     * the new key-value entry is inserted into the tree.
     * 
     * @param key the integer key
     * @param value the value
     * @return the old value or else null
     */
    public Object put(int key, Object value) 
    {
        Object u = null;
        TreeNode n = treeSearch(key, tree.root()); // search for key
        if (tree.isLeaf(n)) {   // if returned node is a leaf, then no key exists
            try {               // insert left and right 'placeholder' leaf nodes
                tree.insertLeft(n, null);
                tree.insertRight(n, null);
            } catch (Exception e) {
                System.out.println("Attempt to add child node where one already exists!");
            }
        } else {    // node is not a leaf, so key exists: store old value to return
            u = getVal(n);
        }
        n.setData(new MapEntry(key, value));  // store new key-value entry at the node.
        return u;
    }
    
    /*
     * Search for a given key in the binary search tree, starting from the given node. This 
     * private method is very useful for implementing the core operations of the binary search tree
     * and ordered map ADTs. The method returns the last node reached in the search, whether or not
     * the key was found.
     */
    private TreeNode treeSearch(int k, TreeNode node) 
    {
        if (tree.isLeaf(node)) {
            return node;
        } 
        if (k < getKey(node)) {
            return treeSearch(k, node.getLeft());
        } else if (k == getKey(node)) {
            return node;
        } else { // k > getKey(node)
            return treeSearch(k, node.getRight());
        }      
    }
    
    /*
     * Recover key from entry stored at node. This method is convenient to wrap up the casting
     * needed because of the lack of generics. Note: should do this with generics!
     */
    private Integer getKey(TreeNode node) 
    {
        // should probably handle n == null
        MapEntry e = (MapEntry) node.getData();
        return (Integer) e.getKey();
    }
    
    /*
     * Recover value from entry stored at node. This method is convenient to wrap up the casting
     * needed because of the lack of generics. Note: should do this with generics!
     */
    private Object getVal(TreeNode node)
    {
        MapEntry e = (MapEntry) node.getData();
        return e.getVal();
    }
    
    
}
