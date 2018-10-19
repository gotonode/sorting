package sorting.main;

import sorting.enums.ArrayFillMethod;
import sorting.enums.SortingAlgorithm;
import sorting.interfaces.Engine;
import sorting.interfaces.Sorter;

/**
 * MultiEngine, a special case of Engine, runs the benchmark on all of the
 * available sorting algorithms. Unlike SingleEngine, this tests all of the
 * algorithms once.
 */
public class MultiEngine implements Engine {

    private final Generator generator;

    public MultiEngine() {
        // This one uses a seed so all of the algorithms will
        // get the array to be sorted. It would be unfair otherwise.
        generator = new Generator(1337);
    }

    @Override
    public String toString() {
        return "MultiEngine";
    }

    @Override
    public String explanation() {
        return "This engine tests all of the sorting algorithms in the app in a row.";
    }

    @Override
    public void run(int exponent, ArrayFillMethod arrayFillMethod, int iterations) {

        System.out.println("\nTesting all sorting algorithms on a " + arrayFillMethod.name() + "-ordered array of size 10^" + exponent + ".\n");

        for (SortingAlgorithm sortingAlgorithm : SortingAlgorithm.values()) {

            Sorter sorter = sortingAlgorithm.getSorter();

            int[] array = new int[(int) Math.pow(10, exponent)];

            generator.resetRandom();

            switch (arrayFillMethod) {
                case pseudorandom:
                    array = generator.generateRandomArray(exponent);
                    break;
                case ascending:
                    array = generator.generateOrderedArray(exponent);
                    break;
                case descending:
                    array = generator.generateReverseOrderedArray(exponent);
                    break;
                case none:
                    array = generator.generateArrayWithSoleValue(exponent, 0);
                    break;
                default:
                    throw new AssertionError(arrayFillMethod.name());
            }

            System.out.print("Running " + sorter.toString() + "..." + " ");

            long start = System.currentTimeMillis();

            array = sorter.sort(array);

            long end = System.currentTimeMillis();

            long difference = end - start;

            String inversions;

            if (Main.VERIFY_SORT_SUCCESS) {

                boolean arrayIsOkay = Tools.verifySort(array);

                if (arrayIsOkay) {
                    inversions = " " + "No inversions.";
                } else {
                    inversions = " " + "Array had inversions! Check the algorithm.";
                }
            }

            System.out.println("Completed in " + difference + " ms." + inversions);

        }
    }

}
