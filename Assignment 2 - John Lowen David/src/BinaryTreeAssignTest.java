import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the BinaryTreeAssign class.
 * It tests assigning pre-order, in-order, and post-order numbers to nodes.
 */
public class BinaryTreeAssignTest {

    /**
     * Tests the preOrderNumber method to ensure pre-order numbers are assigned correctly.
     */
    @Test
    public void testPreOrderNumber() {
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);

        tree.preOrderNumber();

        assertEquals(0, tree.getRoot().preOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).preOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).preOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).preOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).preOrderNumber);
    }

    /**
     * Tests the inOrderNumber method to ensure in-order numbers are assigned correctly.
     */
    @Test
    public void testInOrderNumber() {
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);

        tree.inOrderNumber();

        assertEquals(0, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).inOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).inOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).inOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot()).inOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).inOrderNumber);
    }

    /**
     * Tests the postOrderNumbers method to ensure post-order numbers are assigned correctly.
     */
    @Test
    public void testPostOrderNumber() {
        BinaryTreeAssign tree = new BinaryTreeAssign(1);
        tree.getRoot().left = new BinaryTreeAssign.TreeNodeAssign(2);
        tree.getRoot().right = new BinaryTreeAssign.TreeNodeAssign(3);
        tree.getRoot().left.left = new BinaryTreeAssign.TreeNodeAssign(4);
        tree.getRoot().left.right = new BinaryTreeAssign.TreeNodeAssign(5);

        tree.postOrderNumbers();

        assertEquals(0, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.left).postOrderNumber);
        assertEquals(1, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left.right).postOrderNumber);
        assertEquals(2, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().left).postOrderNumber);
        assertEquals(3, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot().right).postOrderNumber);
        assertEquals(4, ((BinaryTreeAssign.TreeNodeAssign) tree.getRoot()).postOrderNumber);
    }
}