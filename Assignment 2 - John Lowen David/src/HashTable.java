
import java.util.Arrays;

public class HashTable {
    private static final int TABLE_SIZE = 13;
    private Integer[] hashTable;

    public HashTable() {
        hashTable = new Integer[TABLE_SIZE];
        Arrays.fill(hashTable, null);
    }

    /**
     * Inserts a value into the hash table using linear probing.
     *
     * @param key the value to be inserted
     */
    public void insert(int key) {
        int hashIndex = key % TABLE_SIZE;

        // Linear probing to find the next available slot
        while (hashTable[hashIndex] != null) {
            hashIndex = (hashIndex + 1) % TABLE_SIZE;
        }

        hashTable[hashIndex] = key;
    }

    /**
     * Displays the contents of the hash table.
     */
    public void displayTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}