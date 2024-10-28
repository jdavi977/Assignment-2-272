/**
 * Subclass of the BinaryTree that assigns numbers to nodes using PreOrder, InOrder, and PostOrder traversal.
 */
public class BinaryTreeAssign extends BinaryTree {

    // Define the TreeNodeAssign with fields to store PreOrder, InOrder, and PostOrder numbers
    static class TreeNodeAssign extends TreeNode {
        int preOrderNumber;
        int inOrderNumber;
        int postOrderNumber;
        
        // Initialize the node's value using the constructor in the TreeNode class
        public TreeNodeAssign(int value) {
            super(value);
        }
    }
    
    // Getter for root
    public TreeNodeAssign getRoot() {
        return root;
    }

    // Setter for root
    public void setRoot(TreeNodeAssign root) {
        this.root = root;
    }

    // Root node of the BinaryTreeAssign
    private TreeNodeAssign root;

    // Initialize the root node with a value
    public BinaryTreeAssign(int rootValue) {
        this.root = new TreeNodeAssign(rootValue);
    }

    /**
     * Assigns PreOrder numbers to each node.
     */
    public void preOrderNumber() {
    	// Counter is used to see the position of the number as the traversal continues.
        int[] counter = {0};
        preOrderNumber(root, counter);
    }

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
     * Assigns InOrder numbers to each node.
     */
    public void inOrderNumber() {
        int[] counter = {0};
        inOrderNumber(root, counter);
    }

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
     * Assigns PostOrder numbers to each node.
     */
    public void postOrderNumbers() {
        int[] counter = {0};
        postOrderNumbers(root, counter);
    }
    
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
}
