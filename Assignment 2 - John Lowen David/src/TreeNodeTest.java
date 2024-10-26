import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains junit tests for the TreeNode class. 
 * It tests the assigned node, left child, right child and parent values.
 */
public class TreeNodeTest {
	
	/**
	 * Tests the values of the node along with it's children and parent.
	 */
    @Test
    public void testTreeNodeConstructor() {
        // Create a TreeNode with a value of 3
        TreeNode node = new TreeNode(3);

        // Checks if the value is correctly assigned.
        assertEquals(3, node.value);

        // Checks if the left child, right child, and parent are null.
        assertNull(node.left);
        assertNull(node.right);
        assertNull(node.parent);
    }
}