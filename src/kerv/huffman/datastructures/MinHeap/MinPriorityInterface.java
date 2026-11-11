package kerv.huffman.datastructures.MinHeap;

import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;

/**
 * An interface that representing the Min-Heap data structure, where the parent node
 * is always smaller than or equal to its child nodes, ensuring the minimum
 * element is always at the root.
 *
 * @param <E> The type of elements maintained by this heap.
 */
public interface MinPriorityInterface<T> {

    /**
     * Inserts a node with his frequency, maintaining the heap property.
     * It stores a HuffmanNode as its value and use frequency as its priority key.
     *
     * @param node A huffman node could be a leaf or internal node
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    boolean insert (HuffmanNode node);

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    T removeMin();

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    T peekMin();

    /**
     * Check whether the queue is empty.
     *
     * @return true if the priorityQueue is empty; otherwise false.
     */
    boolean isEmpty();

    /**
     * Return the PriorityQueue size.
     * @return A number represent the PriorityQueue size.
     */
    int getSize();

}