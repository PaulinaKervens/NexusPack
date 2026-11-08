package kerv.huffman.algorithm.HuffmanTree;

import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;
import kerv.huffman.datastructures.MinPriorityQueue.MinPriorityQueue;

import java.util.HashMap;
import java.util.Map;


/**
 * Build the tree and generate codes.
 * Controls the Huffman algorithm and constructs the final tree
 */
public class HuffmanTree {
    /** Stores the root of the completed Huffman tree. */
    private HuffmanNode root;


    HashMap<Integer, Integer> frequencyTable;

    /**
     * Default constructor.
     */
    public HuffmanTree() {
        root = null;
    }


    /**
     * Constructs the Huffman tree using the Min-Priority Queue.
     *
     * @param frequencyTable
     */
    public void buildTree (HashMap<Integer, Integer> frequencyTable) {
        MinPriorityQueue<HuffmanNode, Integer> minPriorityQueue = null;
        
        // Retrieve each symbol and frequency from the table
        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
            int symbol = entry.getKey();
            int frequency = entry.getValue();

            // Create the leaf node
            minPriorityQueue.insert(
                    frequency,
                    new HuffmanNode(symbol, frequency)
            );

        }

        // Combining all smallest nodes into internal nodes.
        while () {

        }


    }


    /**
     * Checks whether the tree is empty.
     *
     * @return a true value if it empties; otherwise fals;
     */
    public boolean isEmpty() {
        return root != null;
    }

    /**
     * Method that retrieve the root attribute value.
     *
     * @return the root value.
     */
    public HuffmanNode getRoot() {
        return root;
    }


}
