package sorting.algorithms;

import java.util.PriorityQueue;
import sorting.interfaces.Sorter;

/**
 * Heapsort (lowercase 's'), as the name implies, uses the heap data structure.
 *
 * It can sort an array in (usually) only O(n log n) time. This implementation
 * uses Java's PriorityQueue-structure, but one can of course create their own
 * heap structure to be used with Heapsort.
 *
 * More information: https://en.wikipedia.org/wiki/Heapsort
 */
public class Heapsort implements Sorter {

    private PriorityQueue<Integer> priorityQueue;

    @Override
    public String toString() {
        return "Heapsort";
    }

    @Override
    public Character code() {
        return 'H';
    }

    @Override
    public String explanation() {
        return "Heap Sort uses the heap (PriorityQueue) data structure to sort an array.";
    }

    @Override
    public int[] sort(int[] array) {
        priorityQueue = new PriorityQueue<>(array.length);

        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            priorityQueue.add(i);
        }

        for (int i = 0; i < output.length; i++) {
            output[i] = priorityQueue.poll();
        }

        return output;
    }

}
