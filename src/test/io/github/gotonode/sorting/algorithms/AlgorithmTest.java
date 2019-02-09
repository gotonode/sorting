package io.github.gotonode.sorting.algorithms;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Contains tests for all of the sorting algorithms.
 */
public class AlgorithmTest {

    // To which 10 is raised to, ex. 10^4 = 10,000.
    public static final int EXPONENT = 4;

    @Before
    public void setUp() {
        System.gc();
    }

    @Test
    public void testBubbleSort() {
        test(new BubbleSort());
    }

    @Test
    public void testCountingSort() {
        test(new CountingSort());
    }

    @Test
    public void testHeapsort() {
        test(new Heapsort());
    }

    @Test
    public void testInsertionSort() {
        test(new InsertionSort());
    }

    @Test
    public void testJavaSort() {
        test(new JavaSort());
    }

    @Test
    public void testMergeSort() {
        test(new MergeSort());
    }

    @Test
    public void testQuicksort() {
        test(new Quicksort());
    }

    @Test
    public void testSelectionSort() {
        test(new SelectionSort());
    }

    /**
     * Asks for a generated (reverse-sorted) array, then sorts it, and checks if
     * the resulting array has zero inversions.
     *
     * @param sorter The sorting algorithm to use.
     */
    private void test(Sorter sorter) {
        int[] array = generateArray();

        array = sorter.sort(array);

        assertTrue("Array had inversions!", verifySort(array));
    }

    /**
     * Generates an array of integers in a descending order.
     *
     * This ordering has the maximum number of inversions possible.
     *
     * @return A new array.
     */
    private int[] generateArray() {

        int n = (int) Math.pow(10, EXPONENT);

        int[] output = new int[n];

        int pos = 0;

        for (int i = n - 1; i >= 0; i--) {
            output[pos] = i;
            pos++;
        }

        return output;
    }

    /**
     * Verifies that the array has zero inversions.
     *
     * @param array The array to be checked.
     * @return True if array is in natural sort order; false otherwise.
     */
    private boolean verifySort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
