package kerv.huffman.algorithm.HuffmanTree;

import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;
import kerv.huffman.datastructures.MinHeap.MinHeapPriorityQueue;

import java.util.HashMap;   // Accessible to get
import java.util.Map;


/**
 * Build the tree and generate codes.
 * Controls the Huffman algorithm and constructs the final tree
 */
public class HuffmanTree {
    /** Stores the root of the completed Huffman tree. */
    private HuffmanNode root;

    /**
     * Default constructor.
     */
    public HuffmanTree() {
        root = null;
    }


    /**
     * Builds the Huffman coding tree from the given frequency table.
     *
     * @param frequencyTable a map containing each symbol and its frequency
     */
    public void buildTree (HashMap<Integer, Integer> frequencyTable) {
        // Check if the frequency table is not empty to avoid NullPointerException
        if (frequencyTable == null || frequencyTable.isEmpty()) {
            root = null;
            return;
        }

        // Create a MinHeapPriorityQueue
        MinHeapPriorityQueue<HuffmanNode> minPriorityQueue = new MinHeapPriorityQueue<>(HuffmanNode::compareTo);

        // Populate the priority queue with leaf nodes for each symbol and its frequency
        for (Map.Entry<Integer, Integer> entry : frequencyTable.entrySet()) {
            // Retrieve each symbol and frequency from the table
            // create a new HuffmanNode and insert it to the queue
            minPriorityQueue.insert(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Combine nodes until only the root node remains in the queue
        while (minPriorityQueue.getSize() > 1) {
            // Get both smaller node from the MinHeapPriorityQueue
            HuffmanNode left = minPriorityQueue.removeMin();
            HuffmanNode right = minPriorityQueue.removeMin();

            // Create a combined frequency
            int combinedFrequency = left.getFrequency() + right.getFrequency();

            // Create a new internal node with the two smaller nodes as children and insert it back
            minPriorityQueue.insert(
                    new HuffmanNode(
                            combinedFrequency,
                            left,
                            right
                    )
            );
        }

        // The remaining node is the root of the Huffman tree
        root = minPriorityQueue.removeMin();
    }


    /**
     * Checks whether the tree is empty.
     *
     * @return a true value if it empties; otherwise fals;
     */
    public boolean isEmpty() {
        return root == null;
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
