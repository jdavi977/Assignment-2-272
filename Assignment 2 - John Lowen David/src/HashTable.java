import java.util.Arrays;

/**
 * A hash table implementation that uses linear probing.
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
     * Inserts a value into the hash table using linear probing to handle any possible collisions.
     *
     * @param num the value that will be assigned.
     */
    public void assign(int num) {
        int hashIndex = num % TABLE_SIZE;
        int startIndex = hashIndex;

        // Using linear probing for collisions.
        while (hashTable[hashIndex] != null) {
        	// Increment the hashIndex by 1 if the slot is taken by another number.
            hashIndex = (hashIndex + 1) % TABLE_SIZE;

            // If the hashIndex loops back to the startIndex we stop the loop and cannot assign the num to a slot.
            if (hashIndex == startIndex) {
                System.out.println("Hash table is full. Cannot assign the number: " + num);
                return;
            }
        }

        hashTable[hashIndex] = num;
    }

    /**
     * Displays the hash table.
     * Each index and its the value assigned to its slot.
     */
    public void displayHashTable() {
    	// Starts at i = 0 and increments by 1, as long as i is less than table_size we repeat
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
    
    /**
     * Getter method to retrieve the hash table array.
     *
     * @return the hash table array.
     */
    public Integer[] getHashTable() {
        return hashTable;
    }

    /**
     * Main method to store elements into the hash table and display it.
     *
     * @param args command line arguments that is not used
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        int[] elements = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};

        for (int element : elements) {
            hashTable.assign(element);
        }

        hashTable.displayHashTable();
    }
}
