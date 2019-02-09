package io.github.gotonode.sorting.algorithms;

import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Counting Sort is an extremely fast sorting algorithm.
 *
 * It's fast because it is not based on comparisons, and thus it can sort an
 * array in O(n) time, where most others require at least O(n log n).
 *
 * However, this isn't suitable for all sorting purposes because the integer
 * values in the array cannot be too great.
 *
 * More information: https://en.wikipedia.org/wiki/Counting_sort
 */
public class CountingSort implements Sorter {

    @Override
    public String toString() {
        return "Counting Sort";
    }

    @Override
    public Character code() {
        return 'C';
    }

    @Override
    public String explanation() {
        return "This is an extremely fast sorting algorithm, but arrays can only contain integers that don't have very high values.";
    }

    /**
     * Sorts the given array using Counting Sort.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        int n = array.length;

        int[] counter = new int[n];

        for (int i = 0; i <= n - 1; i++) {
            counter[array[i]] += 1;
        }

        int index = 0;

        for (int i = 0; i < array.length; i++) {

            int nextValue = counter[i];

            for (int j = 0; j < nextValue; j++) {
                array[index] = i;
                index++;
            }
        }

        return array;
    }
}
