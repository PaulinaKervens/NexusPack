package kerv.huffman.algorithm.FrequencyAnalyzer;

import java.util.HashMap;
import java.util.Map;

/** Calculate byte frequencies on a file */
public class FrequencyAnalyzer {

    /**
     * Analyzes the given byte array and calculates the frequency of each unique byte.
     * Each byte is converted to an unsigned integer (0–255) before being stored
     * in the frequency table.
     *
     * @param data the byte array to analyze
     * @return a HashMap containing each unique unsigned byte value as a key
     *         and its frequency as the corresponding value. Otherwise, if the
     *         input is null, an empty HashMap would be return.
     * @throws IllegalArgumentException if the input byte array is null
     */
    public static HashMap<Integer, Integer> analyze(byte[] data){
        // Check if data is not null
        if (data == null)
            throw new IllegalArgumentException("Input data cannot be null.");

        // Key (Integer): The unsigned byte value (0–255).
        // Value (Integer): How many times that byte appears.
        HashMap<Integer, Integer> frequencyTable = new HashMap<>();

        // Retrieve the current byte from the array.
        for (int index = 0; index < data.length; index++) {
            // Convert it into an unsigned integer (0–255).
            int symbol = Byte.toUnsignedInt(data[index]);

            // Check whether that symbol already exists in the HashMap
            // if yes increment the frequency(key), otherwise insert it
            frequencyTable.put(symbol, frequencyTable.getOrDefault(symbol, 0) + 1);
        }

        // Return the HashMap either empty or not
        return frequencyTable;
    }


}


