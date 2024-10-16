public class BinaryTree {
    // Preorder Next
    public static TreeNode preorderNext(TreeNode x) {
        if (x.left != null) {
            return x.left;
        } else if (x.right != null) {
            return x.right;
        } else {
            TreeNode current = x;
            while (current.parent != null) {
                if (current == current.parent.left && current.parent.right != null) {
                    return current.parent.right;
                }
                current = current.parent;
            }
        }
        return null; // No next node found
    }

    // Postorder Next
    public static TreeNode postorderNext(TreeNode x) {
        if (x.parent == null) {
            return null; // x is the root, and postorder traversal ends at the root
        }

        TreeNode parent = x.parent;
        if (parent.right == null || parent.right == x) {
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

    // Inorder Next
    public static TreeNode inorderNext(TreeNode x) {
        if (x.right != null) {
            TreeNode current = x.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeNode current = x;
            while (current.parent != null && current == current.parent.right) {
                current = current.parent;
            }
            return current.parent;
        }
    }
}