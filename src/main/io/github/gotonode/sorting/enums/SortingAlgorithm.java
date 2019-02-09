package io.github.gotonode.sorting.enums;

import io.github.gotonode.sorting.algorithms.BubbleSort;
import io.github.gotonode.sorting.algorithms.CountingSort;
import io.github.gotonode.sorting.algorithms.Heapsort;
import io.github.gotonode.sorting.algorithms.InsertionSort;
import io.github.gotonode.sorting.algorithms.JavaSort;
import io.github.gotonode.sorting.algorithms.MergeSort;
import io.github.gotonode.sorting.algorithms.Quicksort;
import io.github.gotonode.sorting.algorithms.SelectionSort;
import io.github.gotonode.sorting.interfaces.Sorter;

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
