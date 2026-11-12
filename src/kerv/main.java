package kerv;

import kerv.huffman.NexusPackUI.ConsoleMenu;
import kerv.huffman.datastructures.MinHeap.MinHeapPriorityQueue;

import java.util.Comparator;

public class main {
    /**
     * Application entry point.
     *
     * @param args a String array as argument.
     */
    void main(String[] args) {
            ConsoleMenu menu = new ConsoleMenu();
            menu.menu();

        MinHeapPriorityQueue<Integer> minHeapPriorityQueue = new MinHeapPriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
