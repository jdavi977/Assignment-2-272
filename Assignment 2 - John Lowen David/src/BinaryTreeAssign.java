/**
 * Subclass of the BinaryTree that assigns traversal numbers to nodes of a binary tree
 * using PreOrder, InOrder, and PostOrder traversal.
 */
public class BinaryTreeAssign extends BinaryTree {

    /**
     * A class that extends TreeNode to add fields for storing pre-order, in-order, and post-order numbers.
     */
    static class TreeNodeAssign extends TreeNode {
        /**
         * Assigned number during PreOrder traversal.
         */
        int preOrderNumber;
        
        /**
         * Assigned number during InOrder traversal.
         */
        int inOrderNumber;
        
        /**
         * Assigned number during PostOrder traversal.
         */
        int postOrderNumber;
        
        /**
         * Constructor to initialize the node's value.
         * 
         * @param value Is the assigned value of the node.
         */
        public TreeNodeAssign(int value) {
            super(value);
        }
    }
    
    /**
     * The root node of the BinaryTreeAssign.
     */
    private TreeNodeAssign root;
    

    /**
     * Constructor to initialize the binary tree with a root value.
     * 
     * @param rootValue Is the value assigned to the root node.
     */
    public BinaryTreeAssign(int rootValue) {
        this.root = new TreeNodeAssign(rootValue);
    }

    /**
     * This method assigns PreOrder traversal numbers to each node.
     */
    public void preOrderNumber() {
    	// Counter is the traversal number that increases with traversal.
        int counter = 0;
        TreeNodeAssign currentNode = root;

        while (currentNode != null) {
            // Recursively traverse through the tree with PreOrder traversal.
        	// Assigning traversal number and incrementing as we continue.
            currentNode.preOrderNumber = counter++;
            currentNode = (TreeNodeAssign) preorderNext(currentNode);
        }
    }
    
    /**
     * This method assigns PostOrder traversal numbers to each node.
     */
    public void postOrderNumbers() {
        int counter = 0;
        TreeNodeAssign currentNode = root;

        // Recursively traverse to the leftmost leaf node first because PostOrder is left -> right -> root
        while (currentNode.left != null || currentNode.right != null) {
            if (currentNode.left != null) {
                currentNode = (TreeNodeAssign) currentNode.left;
            } else {
                currentNode = (TreeNodeAssign) currentNode.right;
            }
        }

        // Use postorderNext to assign numbers to nodes in post-order traversal
        while (currentNode != null) {
            currentNode.postOrderNumber = counter++;
            currentNode = (TreeNodeAssign) postorderNext(currentNode);
        }
    }

    /**
     * This method assigns InOrder traversal numbers to each node.
     */
    public void inOrderNumber() {
        int counter = 0;
        TreeNodeAssign currentNode = root;
        
        // Because InOrder goes left -> root -> right we traverse to the leftmost node first
        while (currentNode.left != null) {
            currentNode = (TreeNodeAssign) currentNode.left;
        }

        // Now that we are at the leftmost node, we recursively traverse the binary tree using inorderNext 
        // and assign numbers to nodes in in-order traversal
        while (currentNode != null) {
            currentNode.inOrderNumber = counter++;
            currentNode = (TreeNodeAssign) inorderNext(currentNode);
        }
    }
    
    /**
     * Getter method to retrieve the root node of the binary tree.
     * 
     * @return The root node of the binary tree.
     */
    public TreeNodeAssign getRoot() {
        return root;
    }
}