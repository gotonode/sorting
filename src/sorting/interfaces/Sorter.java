package sorting.interfaces;

public interface Sorter {

    /**
     * Sorts the given array of integers.
     *
     * @param array An array of integers, either sorted or not.
     * @return The same array, but with the integers sorted in ascending order.
     */
    int[] sort(int[] array);

    /**
     * Returns the name of the sorting algorithm.
     *
     * @return The name in simple string format, ex. "Bubble Sort".
     */
    @Override
    String toString();

    /**
     * Gives a brief explanation of the algorithm, and how big arrays it can
     * handle efficiently.
     *
     * @return The explanation.
     */
    String explanation();

    /**
     * A single character, used to uniquely distinguish this algorithm.
     *
     * @return The code.
     */
    Character code();
}
