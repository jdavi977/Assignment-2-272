import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the BinaryTreeAssign class.
 * It tests assigning PreOrder, InOrder, and PostOrder traversal numbers to nodes.
 */
public class BinaryTreeAssignTest {

    /**
     * Tests the preOrderNumber method to ensure accurate assignment of PreOrder numbers.
     */
    @Test
    public void testPreOrderNumber() {
    	// Create a binary tree and assign values to it
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);
        
        // Set the parent relationships
        tree.getRoot().left.parent = tree.getRoot();
        tree.getRoot().right.parent = tree.getRoot();
        tree.getRoot().left.left.parent = tree.getRoot().left;
        tree.getRoot().left.right.parent = tree.getRoot().left;

        // Assign the traversal numbers
        tree.preOrderNumber();

        assertEquals(0, tree.getRoot().preOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).preOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).preOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).preOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).preOrderNumber);
    }

    /**
     * Tests the inOrderNumber method to ensure accurate assignment of InOrder numbers.
     */
    @Test
    public void testInOrderNumber() {
    	// Create a binary tree and assign values to it
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);
        
        // Set the parent relationships
        tree.getRoot().left.parent = tree.getRoot();
        tree.getRoot().right.parent = tree.getRoot();
        tree.getRoot().left.left.parent = tree.getRoot().left;
        tree.getRoot().left.right.parent = tree.getRoot().left;
        
        // Assign the traversal numbers
        tree.inOrderNumber();

        assertEquals(0, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).inOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).inOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).inOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot()).inOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).inOrderNumber);
    }

    /**
     * Tests the postOrderNumbers method to ensure accurate assignment of PostOrder numbers.
     */
    @Test
    public void testPostOrderNumber() {
    	// Create a binary tree and assign values to it
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);
        
        // Set the parent relationships
        tree.getRoot().left.parent = tree.getRoot();
        tree.getRoot().right.parent = tree.getRoot();
        tree.getRoot().left.left.parent = tree.getRoot().left;
        tree.getRoot().left.right.parent = tree.getRoot().left;
        
        // Assign the traversal numbers
        tree.postOrderNumbers();

        assertEquals(0, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).postOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).postOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).postOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).postOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot()).postOrderNumber);
    }
}