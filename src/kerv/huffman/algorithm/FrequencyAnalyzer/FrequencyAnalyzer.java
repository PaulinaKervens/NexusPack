package kerv.huffman.algorithm.FrequencyAnalyzer;

import java.util.HashMap;

/**
 * Calculates byte frequencies from raw file data.
 */
public class FrequencyAnalyzer {

    /**
     * Analyzes the given byte array and calculates the frequency of each unique byte.
     * Each byte is converted to an unsigned integer (0–255) before being stored
     * in the frequency table.
     *
     * @param data the byte array to analyze
     * @return a HashMap containing each unique unsigned byte value as a key
     *         and its frequency as the corresponding value (returns an empty map if input is empty)
     * @throws IllegalArgumentException if the input byte array is null
     */
    public static HashMap<Integer, Integer> analyze(byte[] data) {
        // Check if data is not null
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null.");
        }

        // Calculate and return the frequency table
        return buildFrequencyTable(data);
    }

    /**
     * Helper method that iterates over the byte array and populates the frequency map.
     *
     * @param data the byte array to process
     * @return a HashMap mapping unsigned byte values (0-255) to their occurrence counts
     */
    private static HashMap<Integer, Integer> buildFrequencyTable(byte[] data) {
        HashMap<Integer, Integer> frequencyTable = new HashMap<>();

        for (byte b : data) {
            // Convert signed byte into an unsigned integer (0–255).
            int symbol = Byte.toUnsignedInt(b);

            // Increment frequency count for the symbol
            frequencyTable.put(symbol, frequencyTable.getOrDefault(symbol, 0) + 1);
        }

        return frequencyTable;
    }
}


