import java.util.ArrayList;
/**
 * Test class for the BinaryTree class
 * 
 * @author Bill Keller 
 * @version February 2011
 */
public class BTTest
{
    // instance variables - replace the example below with your own
    private BinaryTree expressionTree;

    /**
     * Constructor for objects of class BTTest
     */
    public BTTest()
    {

        expressionTree = new BinaryTree(); // a new empty tree

    }

    public void buildExpressionTree() throws Exception
    {
        // construct a binary tree for the expression (6 + (25/5)) + 3    

        TreeNode root = expressionTree.addRoot("*"); // add "*" node as root of tree
        TreeNode plus = expressionTree.insertLeft(root, "+"); // add "+" node as left child of root 
        expressionTree.insertLeft(plus, 6); // add 6 as left operand of +
        TreeNode divide = expressionTree.insertRight(plus, "/"); // add "/" node as right child of + node
        expressionTree.insertLeft(divide, 25); // add 25 as left operand of "/"
        expressionTree.insertRight(divide, 5); // add 5 as right operand of "/"
        expressionTree.insertRight(root, 3); // add 3 as right operand of root.

    }
    
    public BinaryTree getExpressionTree() {
        return expressionTree;
    }
    
    public void preorderPrintTree() {
        String nodes = expressionTree.preorder(expressionTree.root());
        System.out.println(nodes);
    }
    

}
