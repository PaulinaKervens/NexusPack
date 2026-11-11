package kerv.huffman.datastructures.MinHeap;


import kerv.huffman.algorithm.HuffmanNode.HuffmanNode;

import java.util.Comparator;
import java.util.Objects;


/** Implement the underlying binary heap */
public class MinHeapPriorityQueue<T> implements MinPriorityInterface<T> {

    /** Stores the heap elements */
    private T[] heap;

    /** Tracks the number of elements currently in the heap */
    private int size;

    /** Default array capacity */
    private static final int DEFAULT_CAPACITY = 16;

    /** Determines element priority */
    private final Comparator<T> comparator;

    /**
     * Constructs a priority queue using the specified comparator and default capacity.
     *
     * @param cmp the comparator used to order the elements
     */
    public MinHeapPriorityQueue(Comparator<T> cmp) {
        this(cmp, DEFAULT_CAPACITY);
    }

    /**
     * Constructs a priority queue using the specified comparator and custom capacity.
     *
     * @param cmp      the comparator used to order the elements (must not be null)
     * @param capacity the initial capacity of the heap array
     */
    public MinHeapPriorityQueue(Comparator<T> cmp, int capacity) {
        // If the capacity is invalid (less than 1), fall back to the default capacity
        if (capacity < 1) {
            this.heap = (T[]) new Object[DEFAULT_CAPACITY];
        } else {
            this.heap = (T[]) new Object[capacity];
        }
        // Initialise the final comparator.
        this.comparator = Objects.requireNonNull(cmp, "The comparator should not be null!");
        this.size = 0;
    }





    /**
     * Inserts a node with his frequency, maintaining the heap property.
     * It stores a HuffmanNode as its value and use frequency as its priority key.
     *
     * @param node A huffman node could be a leaf or internal node
     * @return {@code true} if the insertion was successful, {@code false} otherwise
     */
    @Override
    public boolean insert(HuffmanNode node) {
        return false;
    }

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public T removeMin() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code null} if the heap is empty
     */
    @Override
    public T peekMin() {
        return null;
    }

    /**
     * Check whether the queue is empty.
     *
     * @return true if the priorityQueue is empty; otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the PriorityQueue size.
     *
     * @return A number represent the PriorityQueue size.
     */
    @Override
    public int getSize() {
        return size;
    }


    /**
     * Builds or reorganizes the heap structure from an unordered collection of elements.
     */
    private void buildHeap() {

    }

}
