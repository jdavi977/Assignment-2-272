import java.util.Arrays;

/**
 * A hash table implementation that uses linear probing to handle collisions.
 */
public class HashTable {
    /**
     * The size of the hash table.
     */
    private static final int TABLE_SIZE = 13;
    
    /**
     * The array that represents the hash table.
     */
    private Integer[] hashTable;
    
    /**
     * Constructor to initialize the hash table with a fixed size.
     * All slots are initially set to null.
     */
    public HashTable() {
        hashTable = new Integer[TABLE_SIZE];
        Arrays.fill(hashTable, null);
    }

    /**
     * Inserts a value into the hash table using linear probing to handle collisions.
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
     * Each index and its corresponding value are printed to the console.
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

    /**
     * Main method to demonstrate the usage of the hash table with linear probing.
     * Inserts a set of elements and displays the resulting hash table.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        int[] elements = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};

        for (int element : elements) {
            hashTable.insert(element);
        }

        hashTable.displayTable();
    }
}
