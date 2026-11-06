package kerv.huffman.algorithm.HuffmanNode;

/**
 * Represents a node in the Huffman coding tree.
 * Can act as a leaf node (holding a byte symbol and its frequency)
 * or an internal node (holding combined frequencies and child references).
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    /*** Attribute that represent one byte value that we want to compress. */
    private int symbol;

    /*** The Frequency is simply the number of times a particular symbol appears in the input */
    private int frequency;

    /*** Reference or index pointing to the left child node. */
    private HuffmanNode leftChild;

    /*** Reference or index pointing to the right child node. */
    private HuffmanNode rightChild;


    /**
     * Constructs a leaf node with a specific symbol and frequency.
     *
     * @param symbol    the byte symbol value
     * @param frequency the frequency of the symbol
     */
    public HuffmanNode(int symbol, int frequency) {
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
     * Returns the byte symbol stored in this node.
     *
     * @return the symbol byte
     */
    public int getSymbol() {
        return symbol;
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
     * Returns the reference/index of the left child.
     *
     * @return the left child reference
     */
    public HuffmanNode getLeftChild() {
        return leftChild;
    }


    /**
     * Returns the reference/index of the right child.
     *
     * @return the right child reference
     */
    public HuffmanNode getRightChild() {
        return rightChild;
    }

    /**
     * Method that compare the frequency. <br>
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }


    /**
     * Method that determines whether the node is a leaf or not.
     * <p>
     * True  : when both children are null. <br>
     * False : when at least one child exists.
     * </p>
     *
     * @return true if the node is a leaf; otherwise false.
     */
    public boolean isLeaf() {
        // A leaf definition is a node without children
        return (this.rightChild == null && this.leftChild == null);
    }
}