import java.util.NoSuchElementException;
import java.util.ArrayList;


/**
 * Class BinaryTree provides a linked structure representation of the binary tree ADT. A binary tree 
 * consists of a (possibly empty) collection of TreeNode objects related by parent, left-child and 
 * right-child. Each TreeNode also has a data element. The implementation provides basic operations
 * for woring with binary trees as well as a sample method for preorder traversal.
 * 
 * @author Bill Keller 
 * @version February 2011
 */
public class BinaryTree
{
    // a tree has a root and size nodes
    private TreeNode root;
    private int size;

    /**
     * Basic onstructor for objects of class BinaryTree
     */  
    public BinaryTree() {
        root = null;
        size = 0;
    }
    
    /**
     * Return the root node (or throw exception for empty tree).
     */
    public TreeNode root() throws NoSuchElementException {
        if (root == null ) {
            throw new NoSuchElementException("empty tree");
        } 
        return root;
    }            
    
    /**
     * Check whether a node is a leaf of not.
     * @param n the node to check
     * @return true if the node is a leaf; false otherwise
     */
    public boolean isLeaf(TreeNode n) {
        return (n.getLeft() == null && n.getRight() == null);
    }

    /**
     * Check whether a node is the root of the tree
     * @param n the node to check
     * @return true if the node is the root; false otherwise
     */
    public boolean isRoot(TreeNode n) {
        return n == root();
    }
    
    /**
     * Check whether the tree is empty
     * @return true if the tree is empty (has no nodes); false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check that a node has a left child
     * @param n the node to be checked
     * @return true if the left child exists; false otherwise
     */
    public boolean hasLeft(TreeNode n) {
        return n.getLeft() != null;
    }
    
    /**
     * Check that a node has a right child
     * @param n the node to be checked
     * @return true if the right child exists; false otherwise
     */
    public boolean hasRight(TreeNode n) {
        return n.getRight() != null;
    }
    
    /**
     * Get the left child of a given node (or throw an exception if it doesn't exist)
     * @param n the given node
     * @return a tree node 
     */
    public TreeNode getLeft(TreeNode n) throws NoSuchElementException {
        if (!hasLeft(n)) {
            throw new NoSuchElementException("No left child");
        }
        return n.getLeft();
    }
    
    /**
     * Get the right child of a given node (or throw an exception if it doesn't exist)
     * @param n the given node
     * @return a tree node 
     */
    public TreeNode getRight(TreeNode n) throws NoSuchElementException {
        if (!hasRight(n)) {
            throw new NoSuchElementException("No right child");
        }
        return n.getRight();
    }
    
    /**
     * Get the parent of a given node (or throw an exception if the given node is the root)
     * @param n the given node
     * @return a tree node 
     */
    public TreeNode getParent(TreeNode n) throws NoSuchElementException {
        if (isRoot(n)) {
            throw new NoSuchElementException("root of tree");
        }
        return n.getParent();
    }
    
    /**
     * Construct a new node with the given data and make this the root of the tree. An error occurs
     * if the tree alreadyt has a node. 
     * @param data the data element of the new node
     * @return the new node created
     */
    public TreeNode addRoot(Object data) throws Exception {
        if (!isEmpty()) {
            throw new Exception("tree already has a root");
        }
        root = new TreeNode(data);
        size = 1;
        return root;
    }
    
    /**
     * Construct a new node with the given data and add it as the left child of the specified node. 
     * An error condition occurs if the specified node already has a left child.
     * @param n the node specified
     * @param data the data element of the new left child node
     * @return the new left child node
     */
    public TreeNode insertLeft(TreeNode n, Object data) throws Exception {
        if (n.getLeft()!=null) {
            throw new Exception("node already has left");
        }
        TreeNode newLeft = new TreeNode(data);
        n.setLeft(newLeft);
        size++;
        return newLeft;
    }
    
    
    /**
     * Construct a new node with the given data and add it as the right child of the specified node. 
     * An error condition occurs if the specified node already has a right child.
     * @param n the node specified
     * @param data the data element of the new right child node
     * @return the new right child node
     */
    public TreeNode insertRight(TreeNode n, Object data) throws Exception {
        if (n.getRight()!=null) {
            throw new Exception("node already has right");
        }
        TreeNode newRight = new TreeNode(data);
        n.setRight(newRight);
        size++;
        return newRight;
    }
    
    /**
     * Perform a preorder traversal of the tree rooted at node n. Return a String representing 
     * the data elements of each node in the order they are visited.
     * @param n the node from which the traversal starts. 
     * @return a String representation of the data elements of the nodes visited in preorder
     */
    public String preorder(TreeNode n) {
        String nodes = "";
        if (n != null) { // if actually have a tree node
            nodes += " " + n.getData();         // visit the node (root of subtree)
            nodes += preorder(n.getLeft());    // preorder traverse left subtree
            nodes += preorder(n.getRight());   // preorder traverse right subtree
        }
        return nodes;   
    }
    
}
    
        

    

    
