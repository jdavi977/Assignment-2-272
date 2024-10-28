/**
 * Subclass of the BinaryTree that assigns numbers to nodes using PreOrder, InOrder, and PostOrder traversal.
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
     * @param rootValue Is the value to assign to the root node.
     */
    public BinaryTreeAssign(int rootValue) {
        this.root = new TreeNodeAssign(rootValue);
    }

    /**
     * Assigns PreOrder traversal numbers.
     */
    public void preOrderNumber() {
        // Counter is used to see the position of the number as the traversal continues.
        int[] counter = {0};
        preOrderNumber(root, counter);
    }

    /**
     * Helper method to assign PreOrder numbers to each node in the tree.
     * 
     * @param node The current node being visited.
     * @param counter The counter used to assign the traversal numbers to the nodes.
     */
    private void preOrderNumber(TreeNodeAssign node, int[] counter) {
        if (node == null) {
            return;
        }
        // Since PreOrder starts at the root we assign it with 0 and increment by 1. 
        node.preOrderNumber = counter[0]++;
        // Recursively call the function going down from root -> left -> right and assigning with the correct counter.
        preOrderNumber((TreeNodeAssign) node.left, counter);
        preOrderNumber((TreeNodeAssign) node.right, counter);
    }

    /**
     * Assigns InOrder traversal numbers.
     */
    public void inOrderNumber() {
        int[] counter = {0};
        inOrderNumber(root, counter);
    }

    /**
     * Helper method to assign InOrder numbers.
     * 
     * @param node The current node being visited.
     * @param counter The counter used to assign the traversal numbers to the nodes.
     */
    private void inOrderNumber(TreeNodeAssign node, int[] counter) {
        if (node == null) {
            return;
        }
        // Because InOrder traversal goes left -> root -> right
        // We first traverse all the way to the bottom left child giving it a counter afterwards we work up visiting all
        // left children and afterwards the right children.
        inOrderNumber((TreeNodeAssign) node.left, counter);
        node.inOrderNumber = counter[0]++;
        inOrderNumber((TreeNodeAssign) node.right, counter);
    }

    /**
     * Assigns PostOrder traversal numbers.
     */
    public void postOrderNumbers() {
        int[] counter = {0};
        postOrderNumbers(root, counter);
    }
    
    /**
     * Helper method to assign PostOrder traversal numbers.
     * 
     * @param node The current node being visited.
     * @param counter The counter used to assign the traversal numbers to the nodes.
     */
    private void postOrderNumbers(TreeNodeAssign node, int[] counter) {
        if (node == null) {
            return;
        }
        // PostOrder traversal goes left -> right -> root
        // Because of this we make our way to the bottom left child and check if it has any children
        // If it does not we assign the counter and move upwards.
        postOrderNumbers((TreeNodeAssign) node.left, counter);
        postOrderNumbers((TreeNodeAssign) node.right, counter);
        node.postOrderNumber = counter[0]++;
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