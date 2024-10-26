import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains junit tests for the BinaryTree class.
 * It tests the pre-order, post-order, and in-order traversal methods,
 * as well as the property checker method.
 */
public class BinaryTreeTest {

    /**
     * Tests the pre-order traversal of the next node in the BinaryTree class.
     */
    @Test
    public void testPreorderNext() {
    	// Creates the nodes with its values.
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        
        // Assigns the nodes to its placement in the BinaryTree.
        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node4.parent = node2;
        
        // Verifies the next nodes according to pre-order traversal.
        assertEquals(node2, BinaryTree.preorderNext(root));
        assertEquals(node4, BinaryTree.preorderNext(node2));
        // Verifies that there is no node after node3 in pre-order traversal.
        assertNull(BinaryTree.preorderNext(root.right));
    }

    /**
     * Tests the post-order traversal of the next node in the BinaryTree class.
     */
    @Test
    public void testPostorderNext() {
    	// Creates the nodes with its values.
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        
        // Assigns the nodes to its placement in the BinaryTree.
        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node4.parent = node2;
        
        // Verifies the next nodes according to post-order traversal.
        assertEquals(node2, BinaryTree.postorderNext(node4));
        assertEquals(root, BinaryTree.postorderNext(node3));
        // Verifies that there is no node after the root in post-order traversal.
        assertNull(BinaryTree.postorderNext(root));
    }

    /**
     * Tests the in-order traversal of the next node in the BinaryTree class.
     */
    @Test
    public void testInorderNext() {
    	// Creates the nodes with its values.
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        
        // Assigns the nodes to its placement in the BinaryTree.
        root.left = node2;
        root.right = node3;
        node2.parent = root;
        node3.parent = root;
        node2.left = node4;
        node4.parent = node2;
        
        // Verifies the next nodes according to in-order traversal.
        assertEquals(node2, BinaryTree.inorderNext(node4));
        assertEquals(node3, BinaryTree.inorderNext(root));
        // Verifies that there is no node after node3 in in-order traversal.
        assertNull(BinaryTree.inorderNext(node3));
    }

    /**
     * Tests the propertyChecker method of the BinaryTree class checking if the search tree order property is satisfied.
     */
    @Test
    public void testPropertyChecker() {
    	// Creates the nodes with its values.
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        
        // Assigns the nodes to its placement in the BinaryTree.
        root.left = node1;
        root.right = node3;
        node1.parent = root;
        node3.parent = root;
        
        // Checks if the search tree order property is satisfied.
        assertTrue(BinaryTree.propertyChecker(root));
        
        // Create a binary tree that violates the search tree order property.
        TreeNode node4 = new TreeNode(4);
        root.left = node4;
        node4.parent = root;
        
        assertFalse(BinaryTree.propertyChecker(root));
    }
} 
