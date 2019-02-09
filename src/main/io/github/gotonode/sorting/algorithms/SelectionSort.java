package io.github.gotonode.sorting.algorithms;

import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Here's Selection Sort.
 *
 * Like Insertion Sort, Selection Sort is a very simple sorting algorithm. It's
 * an in-place unstable comparison sort.
 *
 * Usually, it performs worse than Insertion Sort, and has a time complexity of
 * O(n^2) because of nesting.
 *
 * Selection Sort is often used when write performance is a limiting factor.
 *
 * More information: https://en.wikipedia.org/wiki/Selection_sort
 */
public class SelectionSort implements Sorter {

    @Override
    public String toString() {
        return "Selection Sort";
    }

    @Override
    public Character code() {
        return 'S';
    }

    @Override
    public String explanation() {
        return "This is a slower sorting algorithm. Arrays greater than 10^5 are not recommended.";
    }

    @Override
    public int[] sort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }

            swap(array, indexMin, i);

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
    private void swap(int[] array, int first, int second) {
        int temp = array[first]; // Temporarily holds the value.
        array[first] = array[second];
        array[second] = temp;
    }

}
