/**
 * This class provides methods for traversing a binary tree using preorder, postorder, and inorder traversals.
 */

public class BinaryTree {
	/**
	 * Finds the next node through preorder traversal.
	 * @param node is the current node
	 * @return the next node through preorder traversal.
	 */
    public static TreeNode preorderNext(TreeNode node) {
    	// Since preorder traversal works down the root -> left child -> right child we first check the left node.
        if (node.left != null) {
            return node.left;
        } else if (node.right != null) {
            return node.right;
        } else {
        	// If there are no left or right children we have to go to the parent node.
            TreeNode current = node;
            while (current.parent != null) {
            	// This checks if the current's parent left child is the same as current. If it is, and the parent's right
            	// child is not null then the next node will be the parent's right child.
                if (current == current.parent.left && current.parent.right != null) {
                    return current.parent.right;
                }
                // This is to traverse up the binary tree if there is no right child to the current parent node.
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
    	// Since in postorder traversal we start at the bottom left -> right -> root, if we start at the root, traversal ends.
        if (node.parent == null) {
            return null; 
        }

        TreeNode parent = node.parent;
        // This checks if the parent node has a right node, if it doesn't then the next node will be the parent.
        if (parent.right == null || parent.right == node) {
            return parent;
        } else {
        	// If there is a right child node, we traverse down to see if it has any left or right children, if it does
        	// we keep going down until we reach a leaf node. The leaf node will be the next node.
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
    	// Inorder traversal goes left -> root -> right
    	// We first start by checking if the node has a right child.
        if (node.right != null) {
        	// If there is a right child, we check if there is a left child to the right child, if there is we 
        	// keep traversing down until we find a left leaf node child. This left child will be the next node. 
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            // If there is no left child to the node's right child, the right child will be the next node.
            return current;
        } else {
            TreeNode current = node;
            // Because the traversal goes left -> root -> right we keep traversing up the binary tree until the node is
            // a left child. Once the parent is a left child, the next parent will be the next node. 
            while (current.parent != null && current == current.parent.right) {
                current = current.parent;
            }
            return current.parent;
        }
    }
    
    /**
     * Checks if the binary tree satisfies the search tree order property.
     *
     * @param root is the root node of the binary tree.
     * @return true or false depending if the tree satisfies the the search tree order at every node.
     */
    public static boolean propertyChecker(TreeNode root) {
        return propertycheckHelp(root, null, null);
    }

    /**
     * Helper method to check if the tree satisfies the search tree order property.
     *
     * @param node is the current node
     * @param min is the value that the right current node must be greater than.
     * @param max is the value that the left current node must be less than.
     * @return true or false depending if the subtree rooted at node satisfies the search tree order property.
     */
    private static boolean propertycheckHelp(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        
        // Depending if the child is in the left or right side we check if the node value is above or below the min or max.
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }
        
        // We recursively travel through the left and right subtree
        return propertycheckHelp(node.left, min, node.value) && propertycheckHelp(node.right, node.value, max);
    }
    
}
