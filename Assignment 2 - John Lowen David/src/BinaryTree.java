/**
 * This class contains methods that allows the user to traverse through a binary tree.
 */
public class BinaryTree {
	/**
	 * Finds the next node through preorder traversal.
	 * @param node is the current node
	 * @return the next node through preorder traversal.
	 */
    public static TreeNode preorderNext(TreeNode node) {
        if (node.left != null) {
            return node.left;
        } else if (node.right != null) {
            return node.right;
        } else {
            TreeNode current = node;
            while (current.parent != null) {
                if (current == current.parent.left && current.parent.right != null) {
                    return current.parent.right;
                }
                current = current.parent;
            }
        }
        return null; 
    }

    /**
     * Finds the next node through postorder traversal.
     * @param node is the current node
     * @return the next node through postorder traversal.
     */
    public static TreeNode postorderNext(TreeNode node) {
        if (node.parent == null) {
            return null; 
        }

        TreeNode parent = node.parent;
        if (parent.right == null || parent.right == node) {
            return parent;
        } else {
            TreeNode current = parent.right;
            while (current.left != null || current.right != null) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return current;
        }
    }
    
    /**
     * Finds the next node through inorder traversal.
     * @param node is the current node
     * @return the next node through inorder traversal.
     */
    public static TreeNode inorderNext(TreeNode node) {
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeNode current = node;
            while (current.parent != null && current == current.parent.right) {
                current = current.parent;
            }
            return current.parent;
        }
    }
}