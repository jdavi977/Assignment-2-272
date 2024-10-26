import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the HashTable class.
 * It tests inserting values, handling collisions using linear probing,
 * and ensuring the proper functioning of the hash table methods.
 */
public class HashTableTest {

    /**
     * Tests the assign method of the HashTable class to ensure values are inserted properly.
     */
    @Test
    public void testAssign() {
        HashTable hashTable = new HashTable();
        hashTable.assign(1);
        hashTable.assign(14); // Should cause a collision with 1, as 1 % 13 == 14 % 13

        Integer[] expectedTable = new Integer[13];
        expectedTable[1] = 1;
        expectedTable[2] = 14; // Linear probing places 14 in the next available slot

        assertArrayEquals(expectedTable, hashTable.getHashTable());
    }

    /**
     * Tests that the hash table handles collisions correctly using linear probing.
     */
    @Test
    public void testCollisionHandling() {
        HashTable hashTable = new HashTable();
        hashTable.assign(1);
        hashTable.assign(14); // Collision with 1
        hashTable.assign(27); // Collision with 1 and 14

        Integer[] expectedTable = new Integer[13];
        expectedTable[1] = 1;
        expectedTable[2] = 14;
        expectedTable[3] = 27; // Linear probing places 27 in the next available slot

        assertArrayEquals(expectedTable, hashTable.getHashTable());
    }

    /**
     * Tests the behavior of the hash table when it becomes full.
     */
    @Test
    public void testHashTableFull() {
        HashTable hashTable = new HashTable();
        // Fill the hash table completely
        for (int i = 0; i < 13; i++) {
            hashTable.assign(i * 13); // All values will initially hash to index 0
        }

        // Try to insert another value, which should not be possible
        hashTable.assign(169);

        Integer[] expectedTable = new Integer[13];
        for (int i = 0; i < 13; i++) {
            expectedTable[i] = i * 13;
        }

        assertArrayEquals(expectedTable, hashTable.getHashTable());
    }

}
