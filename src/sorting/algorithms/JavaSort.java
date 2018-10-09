package sorting.algorithms;

import java.util.Arrays; // Needed to access the internal sorting algorithm(s).
import sorting.interfaces.Sorter;

/**
 * This class links Java's internal sorting algorithm to this app.
 *
 * Depending on the content to be sorted, Java uses either a form of Merge Sort
 * or Quicksort with two pivots (usually Quicksort only uses one).
 *
 * Most often, the time complexity is O(n log n).
 *
 * More information:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(int[])
 */
public class JavaSort implements Sorter {

    @Override
    public String toString() {
        return "JavaSort (internal)";
    }

    @Override
    public Character code() {
        return 'J';
    }

    @Override
    public String explanation() {
        return "This uses Java's own sorting algorithm, which is a form of either Merge Sort or Quicksort with two pivots. Very large arrays can be sorted.";
    }

    /**
     * Sorts the given array using Java's internal sorting algorithm.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        Arrays.sort(array);

        return array;
    }

}
