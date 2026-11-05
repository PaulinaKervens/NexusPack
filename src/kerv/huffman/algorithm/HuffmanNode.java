package kerv.huffman.algorithm;

/**
 * Represents a node in the Huffman coding tree.
 * Can act as a leaf node (holding a byte symbol and its frequency)
 * or an internal node (holding combined frequencies and child references).
 */
public class HuffmanNode {

    /** The byte symbol value (0–255); typically -1 or a placeholder for internal nodes. */
    private byte symbol;

    /** The number of occurrences (frequency) of the symbol or combined subtree. */
    private int frequency;

    /** Reference or index pointing to the left child node. */
    private HuffmanNode leftChild;

    /** Reference or index pointing to the right child node. */
    private HuffmanNode rightChild;


    /**
     * Constructs a default HuffmanNode with uninitialized values.
     */
    public HuffmanNode() {
        this.symbol = 0;
        this.frequency = 0;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructs a leaf node with a specific symbol and frequency.
     *
     * @param symbol    the byte symbol value
     * @param frequency the frequency of the symbol
     */
    public HuffmanNode(byte symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructs an internal node with a frequency and child references.
     *
     * @param frequency the combined frequency of the children
     * @param leftChild reference to the left child
     * @param rightChild reference to the right child
     */
    public HuffmanNode(int frequency, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.symbol = -1; // Internal nodes typically don't represent a specific symbol
        this.frequency = frequency;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Sets the byte symbol for this node.
     *
     * @param symbol the symbol to set
     */
    public void setSymbol(byte symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the byte symbol stored in this node.
     *
     * @return the symbol byte
     */
    public byte getSymbol() {
        return symbol;
    }

    /**
     * Sets the frequency of this node.
     *
     * @frequency the frequency count to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Returns the frequency count of this node.
     *
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * Sets the reference/index for the left child.
     *
     * @leftChild the left child reference
     */
    public void setLeftChild(int leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Returns the reference/index of the left child.
     *
     * @return the left child reference
     */
    public int getLeftChild() {
        return leftChild;
    }

    /**
     * Sets the reference/index for the right child.
     *
     * @rightChild the right child reference
     */
    public void setRightChild(int rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Returns the reference/index of the right child.
     *
     * @return the right child reference
     */
    public int getRightChild() {
        return rightChild;
    }
}