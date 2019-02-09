package io.github.gotonode.sorting.algorithms;

import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Insertion Sort is an entry-level sorting algorithm for beginners.
 *
 * It's very easy to implement, but quite slow. When people sort cards on their
 * hands, most use a form of Insertion Sort.
 *
 * It works great on small amounts of data, and when the given array is almost
 * in a sorted state to begin with (1 or 2 inversions).
 *
 * Time complexity is O(n^2) because of nesting.
 *
 * More information: https://en.wikipedia.org/wiki/Insertion_sort
 */
public class InsertionSort implements Sorter {

    @Override
    public String toString() {
        return "Insertion Sort";
    }

    @Override
    public Character code() {
        return 'I';
    }

    @Override
    public String explanation() {
        return "This is a slow sorting algorithm, but easy to implement. Can process arrays of size 10^4 efficiently.";
    }

    /**
     * Sorts the given array using Insertion Sort.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        int n = array.length;

        for (int i = 1; i <= n - 1; i++) {
            int j = i - 1;

            while (j >= 0 && array[j] > array[j + 1]) {
                swap(array, j, j + 1);
                j--;
            }
        }

        return array;
    }

    /**
     * Swaps the values of two elements in the array, indicated by their
     * indices.
     *
     * For an example, if you call swap(array, 0, 1), it will swap the values of
     * array[0] and array[1]. If the values are the same, the swap will take
     * place regardless.
     *
     * @param array Pass the array that the swap will take place in.
     * @param first First index.
     * @param second Second index.
     */
    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
