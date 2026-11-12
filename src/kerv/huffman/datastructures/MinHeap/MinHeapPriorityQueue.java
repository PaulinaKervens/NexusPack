package kerv.huffman.datastructures.MinHeap;

import java.util.Comparator;
import java.util.NoSuchElementException;
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
     * Inserts an element into the priority queue while maintaining
     * the Min-Heap property.
     *
     * @param node the element to be inserted
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

        // Restores the Min-Heap ordering property.
        siftUp(size - 1);
    }


    /***
     * Method that expands the underlying array when full by doubling its capacity. <br>
     * 1) Update the capacity by double it. Making the time of complexity 0(n). <br>
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


    /**
     * Sifts the element at the specified index upward to restore the min-heap property.
     * <p>Time complexity: 0(Log n)</p>
     *
     * @param index the starting index of the element
     */
    private void siftUp(int index) {
        // Continue as long as we are not at the root and the child is smaller than its parent
        while (index > 0 && comparator.compare(heap[index], heap[getParent(index)]) < 0) {
            swap(index, getParent(index));      // If parent is bigger swap them
            // Update the index to check if we must swap the new parent too
            index = getParent(index);
        }
    }


    /**
     * Sifts the element at the specified index downward to restore the min-heap property.
     * The while loop follows these steps:
     * 1. Check whether the left child exists.
     * 2. Calculate the left and right child indices.
     * 3. Set smallerChild = leftChild.
     * 4. If the right child exists and is smaller, assign smallerChild = rightChild.
     * 5. Compare the parent (current node) with the smaller child.
     * 6. If the parent is larger, swap and update index; otherwise, break.
     * 7. Repeat.
     * <p>Time complexity: 0(Log n)</p>
     *
     * @param index the starting index to sift down from
     */
    private void siftDown(int index) {
        // Ensures a left child exists
        while (getLeftChild(index) < size) {
            // Get each child index
            final var smallerChild = getSmallerChild(index);

            // Compare the smaller child with the parent
            if(comparator.compare(heap[index], heap[smallerChild]) > 0) {
                swap(index, smallerChild);  // swaps when the parent is larger
                index = smallerChild;       // initialise the new index of parent
            } else {
                break;      // stops if the heap property is already satisfied.
            }
        }
    }

    /**
     * Determines which child (left or right) has smaller priority according to the comparator.
     * Defaults to the left child if the right child does not exist or is not smaller.
     *
     * @param index the parent index whose children are being evaluated
     * @return the index of the child with the smaller value
     */
    private int getSmallerChild(int index) {
        int leftChild = getLeftChild(index), rightChild = getRightChild(index);
        // Assign leftChild by default,
        // because in a complete tree
        // we start from left to right
        int smallerChild = leftChild;

        // Check if left child exists and is smaller than right child (if right exists)
        if (rightChild < size && comparator.compare(heap[rightChild], heap[leftChild]) < 0) {
            smallerChild = rightChild;      // If yes we assign it to the variable smaller
        }
        return smallerChild;
    }

    /**
     * Removes and returns the minimum element (the root) from the min-heap,
     * then reorganizes the heap to maintain its order.
     * <p>Time complexity: 0(Log n)</p>
     *
     * @return The minimum element, or {@code throws NoSuchElementException} if the heap is empty
     */
    @Override
    public T removeMin() {
        // Check if the MinPriorityQueue is empty
        if (isEmpty())
            throw new NoSuchElementException("Empty tree");

        // Store the root element (minimum value) before replacing it
        T heapRoot = heap[0];

        // Replace the root with the last element in the heap
        heap[0] = heap[size - 1];

        // Decrease the size to remove the last position from the heap
        size--;

        // Remove the pointer of the old element definitively
        heap[size] = null;

        // Restore the Min-Heap property starting from the root
        if (!isEmpty())
            siftDown(0);

        // Return the original minimum element
        return heapRoot;
    }

    /**
     * Retrieves, but does not remove, the minimum element from the min-heap.
     *
     * @return the minimum element, or {@code throws NoSuchElementException} if the heap is empty
     */
    @Override
    public T peekMin() {
        // Check if the queue is not empty first
        if (isEmpty())
            throw new NoSuchElementException("Empty tree");
        // Return the root value
        return heap[0];
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
