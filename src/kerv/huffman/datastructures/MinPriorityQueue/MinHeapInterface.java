package kerv.huffman.datastructures.MinPriorityQueue;

import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;

/**
 * An interface that representing the Min-Heap data structure, where the parent node
 * is always smaller than or equal to its child nodes, ensuring the minimum
 * element is always at the root.
 *
 * @param <E> The type of elements maintained by this heap.
 */
public interface MinHeapInterface<E> {

    /**
     * Inserts an element into the min-heap, maintaining the heap property.
     * It stores a HuffmanNode as its value and use frequency as its priority key.
     *
     * @param node An huffman node could be a leaf or internal node
     * @param frequency The frequency of that node
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    boolean insert (int frequency, HuffmanNode node);

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    E removeMin();

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    E peekMinimum();

    /**
     * Builds or reorganizes the heap structure from an unordered collection of elements.
     */
    void buildHeap();
}