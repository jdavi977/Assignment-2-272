/**
 * This class represents a node in the binary tree.
 */
public class TreeNode {
	/**
	 * The value of the node.
	 */
    int value;
    /**
     * References to the left, right, and parent nodes in the binary tree.
     */
    TreeNode left, right, parent;

    /**
     * This is the constructor to create a TreeNode with a value.
     * @param value is the value of the node.
     */
    TreeNode(int value) {
        this.value = value;
        left = right = parent = null;
    }
}
