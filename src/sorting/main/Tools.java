package sorting.main;

/**
 * A class that houses many static functions used by the Engine-classes.
 */
public class Tools {

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
                if (Base.ERROR_ON_ARRAY_INVERSIONS) {
                    throw new RuntimeException("Array had inversions. Aborting operation.");
                }
                return false;
            }
        }
        return true;
    }
}
