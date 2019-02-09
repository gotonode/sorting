package io.github.gotonode.sorting.algorithms;

import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Quicksort (yes, spelled with a lowercase 's') can be a very efficient sorting
 * algorithm.
 *
 * It works on the Divide & Conquer principle, and has a time complexity of O(n
 * log n) at best, and O(n^2) at worst. Care must be taken on where to place the
 * pivot.
 *
 * Quicksort can be difficult for beginners to implement and to understand. My
 * personal recommendation is to watch animations and/or videos about it to get
 * a feel on how it works.
 *
 * More information: https://en.wikipedia.org/wiki/Quicksort
 */
public class Quicksort implements Sorter {

    private int[] array;

    @Override
    public String toString() {
        return "Quicksort";
    }

    @Override
    public Character code() {
        return 'Q';
    }

    @Override
    public String explanation() {
        return "This is (or can be) a very fast sorting algorithm. Very large arrays can be sorted.";
    }

    /**
     * Sorts the given array using Quicksort.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        this.array = array;

        int n = this.array.length;

        work(0, n - 1);

        return this.array;
    }

    private void work(int a, int b) {
        if (a >= b) {
            return;
        }

        int k = split(a, b);

        work(a, k - 1);
        work(k + 1, b);
    }

    private int split(int a, int b) {

        int k = a;

        for (int i = a + 1; i <= b; i++) {
            if (array[i] < array[a]) {
                k++;
                swap(i, k);
            }
        }

        swap(a, k);

        return k;
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
    private void swap(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

}
