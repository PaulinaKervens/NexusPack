package kerv.huffman.datastructures;

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
     *
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    boolean insert();

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