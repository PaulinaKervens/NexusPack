package kerv.huffman.compression;

import java.util.HashMap;
import java.util.Map;

/**
 * Carries compressed data and metadata between components.
 *
 * <p>Responsibilities:
 * <ul>
 *   <li>Hold the compressed bytes.</li>
 *   <li>Store the frequency table required for decompression.</li>
 *   <li>Preserve the original data size.</li>
 *   <li>Provide safe access to the stored information.</li>
 * </ul>
 */
public class CompressionResult {

    /** The resulting compressed bytes */
    private final byte[] compressedData;

    /** The frequency table mapping byte symbols to their frequencies */
    private final HashMap<Integer, Integer> frequencyTable;

    /** Size of the original uncompressed data */
    private final long originalSize;

    /**
     * Initializes the result with compressed data, frequency table, and original size.
     * Validates inputs to ensure data integrity.
     *
     * @param compressedData the compressed byte array
     * @param frequencyTable the frequency table of the bytes
     * @param originalSize   the size of the original data in bytes
     * @throws IllegalArgumentException if arguments are null, size is negative, or frequencies do not match
     */
    public CompressionResult(byte[] compressedData,
                             HashMap<Integer, Integer> frequencyTable,
                             long originalSize) {

        // Check for null object
        if (compressedData == null || frequencyTable == null || originalSize < 0) {
            throw new IllegalArgumentException("Arguments cannot be null and originalSize cannot be negative.");
        }

        // Check that frequency total matches the original data size
        if (!frequencyCheck(frequencyTable, originalSize)) {
            throw new IllegalArgumentException("Frequency total must match the original data size.");
        }

        // Use a copy of the array and map so callers cannot
        // modify our internal state through references
        this.compressedData = compressedData.clone();
        this.frequencyTable = new HashMap<>(frequencyTable);
        this.originalSize = originalSize;
    }


    /**
     * Validates that every symbol and frequency in the table is valid and that the sum
     * of all frequencies matches the original data size.
     *
     * @param frequencyTable map containing byte values as keys and their frequencies as values
     * @param originalSize   the expected total size of the original data in bytes
     * @return true if the accumulated valid frequencies equal the original size; false otherwise
     */
    private static boolean frequencyCheck(HashMap<Integer, Integer> frequencyTable, long originalSize) {
        // Check if the table is not null
        if (frequencyTable == null || originalSize < 0) {
            return false;
        }

        // Local variable to compare to the origin size
        long totalFrequencySum = 0;

        // Retrieve the data from the hashmap to make the comparison
        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {

            if (entry.getKey() == null || entry.getValue() == null)
                return false;

            int symbol = entry.getKey();
            int frequency = entry.getValue();

            // Accumulate frequencies only for valid byte values (0 to 255) with positive counts
            if (symbol >= 0 && symbol <= 255 && frequency > 0) {
                totalFrequencySum += frequency;
            } else {
                return false;
            }
        }

        return totalFrequencySum == originalSize;
    }


    /**
     * Returns a defensive copy of the compressed byte array.
     * Cloning prevents external modification of the internal compressed data.
     *
     * @return a clone of the compressed byte array
     */
    public byte[] getCompressedData() {
        return compressedData.clone();
    }

    /**
     * Returns a copy of the frequency table mapping byte symbols to their frequencies.
     * Returning a new HashMap ensures encapsulation and protects internal state.
     *
     * @return a new HashMap containing the frequency table
     */
    public HashMap<Integer, Integer> getFrequencyTable() {
        return new HashMap<>(frequencyTable);
    }

    /**
     * Returns the size of the original uncompressed data in bytes.
     *
     * @return the original data size
     */
    public long getOriginalSize() {
        return originalSize;
    }

}
