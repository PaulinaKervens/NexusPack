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
    @SuppressWarnings("unchecked")
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
    public void insert(T node) throws IllegalArgumentException {
        // Avoid null arg
        if (node == null)
            throw new IllegalArgumentException("Node args should not be null!");

        // Check if the array is not full to resize it
        if (isFull())
            resize();

        // Insert the node to the array
        heap[size++] = node;

    }

    /***
     * Method that expands the underlying array when full by doubling its capacity. <br>
     * 1) Update the capacity by double it. Making the time of complexity 0(1). <br>
     * 2) Creates a tempo array, initialise it with the new capacity.<br>
     * 3) Copy all elements from the array to the tempo array.<br>
     * 4) Point the old array to the new array.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // Upgrade the capacity attribute
        // Create a temporary array and initialize it with the new capacity
        Object[] tempArray = new Object[heap.length * 2];

        // Copy all elements from the old array to the temporary array
        for (int index = 0; index < getSize(); index++) {
            tempArray[index] = heap[index];
        }

        // Point the old array reference to the temporary array
        heap = (T[]) tempArray;
    }


    private boolean siftUp(int index) {

        return true;
    }

    /**
     * Swaps two elements in the heap array by their indices.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    private void swap(int index1, int index2) {
        // Store the value of index1 in a temporary variable
        // to not lose it when override
        T temp = heap[index1];
        // override the index1 value by index2 value
        heap[index1] = heap[index2];
        // initialize the index2 value by temp value
        heap[index2] = temp;
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
     * Builds or reorganizes the heap structure from an unordered collection of elements.
     */
    private void buildHeap() {

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
     * Check whether the queue is full.
     *
     * @return true if the priorityQueue is full; otherwise false.
     */
    @Override
    public boolean isFull() {
        return size == heap.length;
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
     * Calculates the index of the parent node for a given node index.
     *
     * @param index the index of the current node
     * @return the index of the parent node
     */
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Calculates the index of the left child for a given node index.
     *
     * @param index the index of the current node
     * @return the index of the left child
     */
    private int getLeftChild(int index) {
        return (2 * index) + 1;
    }

    /**
     * Calculates the index of the right child for a given node index.
     *
     * @param index the index of the current node
     * @return the index of the right child
     */
    private int getRightChild(int index) {
        return (2 * index) + 2;
    }

}
