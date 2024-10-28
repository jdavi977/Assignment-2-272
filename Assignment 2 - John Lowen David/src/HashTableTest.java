import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the HashTable class.
 * It tests assigning values and handling collisions using linear probing.
 */
public class HashTableTest {

    /**
     * Tests the assign method of the HashTable class checking if the values are assigned properly.
     * Also checks how if collisions are properly avoided using linear probing.
     */
    @Test
    public void testAssignandCollision() {
    	// Create a hash table and assign values to it.
        HashTable hashTable = new HashTable();
        // Testing collision using linear probing.
        hashTable.assign(1); // 1 % 13 = 1
        hashTable.assign(14); // 14 % 13 = 1
        hashTable.assign(27); // 27 % 13 = 1
        
        // Creating another hash table to see if the values line up with the original table.
        Integer[] expectedTable = new Integer[13];
        expectedTable[1] = 1;
        expectedTable[2] = 14; // Linear probing puts values in the next available slot.
        expectedTable[3] = 27;

        assertArrayEquals(expectedTable, hashTable.getHashTable());
    }



}
