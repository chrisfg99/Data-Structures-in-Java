
/**
 * Write a description of class TreeNode here.
 * 
 * @author Bill Keller 
 * @version February 2011
 */
public class TreeNode
{
    // instance variables 
    private Object data; 
    private TreeNode left; 
    private TreeNode right;
    private TreeNode parent;
    
    public TreeNode(Object item) { 
        data = item;
        left = null;
        right = null;
        parent = null;
    } 

    public Object getData() {
        return data;
    }

    public void setData(Object newData) {
        data = newData;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode newLeft) {
        left = newLeft;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode newRight) {
        right = newRight;
    }
    
    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode newParent) {
        parent = newParent;
    }
    
    
}
