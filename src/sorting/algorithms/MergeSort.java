package sorting.algorithms;

import sorting.interfaces.Sorter;

/**
 * Merge Sort is an advanced sorting algorithm.
 *
 * It works on the Divide & Conquer principle, and has a time complexity of O(n
 * log n).
 *
 * Merge Sort can be difficult for beginners to implement and to understand. My
 * personal recommendation is to watch animations and/or videos about it to get
 * a feel on how it works.
 *
 * More information: https://en.wikipedia.org/wiki/Merge_sort
 */
public class MergeSort implements Sorter {

    private int[] array;
    private int[] help;

    @Override
    public String toString() {
        return "Merge Sort";
    }

    @Override
    public Character code() {
        return 'M';
    }

    @Override
    public String explanation() {
        return "This is a fast sorting algorithm. Very large arrays can be sorted.";
    }

    /**
     * Sorts the given array using Merge Sort.
     *
     * @param array Array to be sorted.
     * @return The sorted array.
     */
    @Override
    public int[] sort(int[] array) {

        this.array = array;

        int n = this.array.length;
        help = new int[n];

        act(0, n - 1);

        return array;
    }

    private void act(int left, int right) {

        if (left == right) {
            return;
        }

        int middle = (left + right) / 2;

        act(left, middle);
        act(middle + 1, right);

        merge(left, middle, middle + 1, right);
    }

    private void merge(int left1, int right1, int left2, int right2) {

        int left = left1;
        int right = right2;

        for (int i = left; i <= right; i++) {

            if (left2 > right2 || (left1 <= right1 && array[left1] < array[left2])) {
                help[i] = array[left1];
                left1++;
            } else {
                help[i] = array[left2];
                left2++;
            }
        }

        for (int i = left; i <= right; i++) {
            array[i] = help[i];
        }
    }

}
