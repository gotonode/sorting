package sorting.enums;

import sorting.algorithms.BubbleSort;
import sorting.algorithms.CountingSort;
import sorting.algorithms.Heapsort;
import sorting.algorithms.InsertionSort;
import sorting.algorithms.JavaSort;
import sorting.algorithms.MergeSort;
import sorting.algorithms.Quicksort;
import sorting.algorithms.SelectionSort;
import sorting.interfaces.Sorter;

/**
 * An enum used to house and link the different sorting algorithms.
 *
 * When a new sorting algorithm is added, it's linked here. Only this file has
 * the sorting algorithms as a dependency.
 *
 * Please refer to the individual sorting algorithm's file for more information.
 */
public enum SortingAlgorithm {

    BubbleSort(new BubbleSort()), CountingSort(new CountingSort()), Heapsort(new Heapsort()), InsertionSort(new InsertionSort()),
    JavaSort(new JavaSort()), MergeSort(new MergeSort()), Quicksort(new Quicksort()), SelectionSort(new SelectionSort());

    private final Sorter sorter;

    SortingAlgorithm(Sorter sorter) {
        this.sorter = sorter;
    }

    public Sorter getSorter() {
        return this.sorter;
    }
}
