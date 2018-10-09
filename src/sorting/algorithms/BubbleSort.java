package sorting.algorithms;

import sorting.interfaces.Sorter;

/**
 * This is Bubble Sort.
 *
 * It's a very slow sorting algorithm. Many beginners implement this as their
 * first sorting algorithm. It's also good to know about.
 *
 * Bubble Sort has a time complexity of O(n^2) because of one nested loop.
 *
 * More information: https://en.wikipedia.org/wiki/Bubble_sort
 */
public class BubbleSort implements Sorter {

    @Override
    public String toString() {
        return "Bubble Sort";
    }

    @Override
    public Character code() {
        return 'B';
    }

    @Override
    public String explanation() {
        return "This is a very slow sorting algorithm, but extremely easy to implement. Arrays greater than 10^5 are not recommended.";
    }

    /**
     * Sorts the given array using Bubble Sort.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        int n = array.length;

        for (int i = n; i >= 2; i--) {

            for (int j = 0; j < i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }

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
    private void swap(int[] array, int first, int second) {
        int temp = array[first]; // Temporarily holds the value.
        array[first] = array[second];
        array[second] = temp;
    }

}
