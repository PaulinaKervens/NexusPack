package kerv.huffman.datastructures.MinPriorityQueue;

import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;

/** Manage nodes by priority **/
public class MinPriorityQueue<K, V> implements MinHeapInterface {


    /**
     * Inserts an element into the min-heap, maintaining the heap property.
     *
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    @Override
    public boolean insert (int frequency, HuffmanNode node){
        return false;
    }

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public Object removeMin() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public Object peekMinimum() {
        return null;
    }

    /**
     * Builds or reorganizes the heap structure from an unordered collection of elements.
     */
    @Override
    public void buildHeap() {

    }
}
