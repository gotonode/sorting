package sorting.main;

import java.util.List;

/**
 * A class that houses many useful static functions.
 */
public class Tools {

    /**
     * Calculates the results and prints them to the console.
     *
     * This will print the average, minimum and maximum times the algorithm ran.
     *
     * @param times In milliseconds, how long each test took.
     */
    public static void calculateAndPrintResults(List<Long> times) {

        double sum = 0;

        double fastest = times.get(0);
        double slowest = times.get(0);

        for (long l : times) {
            if (l > slowest) {
                slowest = l;
            }
            if (l < fastest) {
                fastest = l;
            }
            sum += l;
        }

        double average = sum / times.size();

        if (Main.VERBOSE_OUTPUT) {
            System.out.println();
        }

        System.out.println("Run complete. Average: " + average + " ms, fastest: " + (long) fastest + " ms, slowest: " + (long) slowest + " ms.");
    }

    /**
     * Prints the array's values into the console.
     *
     * Be cautious with larger arrays!
     *
     * @param array The array to be printed.
     */
    public static void printArray(int[] array) {

        // TODO: Find out how to make the output neater.
        int cutoff = 180; // Reduce cutoff if you have a lower resolution.

        StringBuilder stringBuilder = new StringBuilder(cutoff);

        stringBuilder.append("[");

        for (int i = 0; i < array.length; i++) {

            stringBuilder.append(array[i]);

            if (i < array.length - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("]");
            }
            if (stringBuilder.length() > cutoff) {
                System.out.println(stringBuilder);
                stringBuilder = new StringBuilder(cutoff);
            }
        }

        if (stringBuilder.length() > 0) {
            System.out.println(stringBuilder);
        }
    }

    /**
     * Checks whether the sorted array has zero (0) inversions.
     *
     * Optionally throws a RuntimeException if inversions are found.
     *
     * @param array The array to be checked.
     * @return True if array is in ascending order, false otherwise.
     */
    public static boolean verifySort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                if (Main.ERROR_ON_ARRAY_INVERSIONS) {
                    throw new RuntimeException("Array had inversions. Aborting operation.");
                }
                return false;
            }
        }
        return true;
    }
}
