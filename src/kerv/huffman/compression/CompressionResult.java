package kerv.huffman.compression;

import java.util.HashMap;
import java.util.Map;

/**
 * Carries compressed data and metadata between components.
 * Responsibilities
 *  - Hold the compressed bytes.
 *  - Preserve the frequency table.
 *  - Preserve the original data size.
 *  - Provide access to the stored information.
 */
public class CompressionResult {

    /*** The resulting compressed bytes **/
    private final byte[] compressedData;

    /*** */
    private final HashMap<Integer, Integer> frequencyTable;

    /*** Size of the original data */
    private final long originalSize;

    /**
     * Initializes the result with all three attributes.
     */
    public CompressionResult(byte[] compressedData,
                             HashMap<Integer, Integer> frequencyTable,
                             long originalSize) {
        if (compressedData == null || frequencyTable == null || originalSize < 0)
            throw new IllegalArgumentException("Arguments cannot be null and originalSize cannot be negative.");

        if (!frequencyCheck(frequencyTable, originalSize))
            throw new IllegalArgumentException("Frequency total must match the original data size.");

        // using a copy of the array so the caller cannot
        // modify our internal data through the getter
        this.compressedData = compressedData.clone();
        this.frequencyTable = new HashMap<>(frequencyTable);
        this.originalSize = originalSize;
    }

    private static boolean frequencyCheck(HashMap<Integer, Integer> frequencyTable, long originalSize) {
        long size = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
            size += entry.getValue();
        }
        return size == originalSize;
    }

    /**
     * Returns the compressed bytes.
     * @return
     */
    public byte[] getCompressedData() {
        return compressedData.clone();
    }

    /**
     * Returns the frequency table
     * @return
     */
    public HashMap<Integer, Integer> getFrequencyTable() {
        return new HashMap<>(frequencyTable);
    }

    /**
     * Returns the original data size
     * @return
     */
    public long getOriginalSize() {
        return originalSize;
    }
}
