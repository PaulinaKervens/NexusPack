package kerv.huffman.datastructures;

/** Implement the underlying binary heap */
public class MinHeap<E> implements MinHeapInterface<E> {
    /**
     * Inserts an element into the min-heap, maintaining the heap property.
     *
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    @Override
    public boolean insert() {
        return false;
    }

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public E removeMin() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public E peekMinimum() {
        return null;
    }

    /**
     * Builds or reorganizes the heap structure from an unordered collection of elements.
     */
    @Override
    public void buildHeap() {

    }

}
