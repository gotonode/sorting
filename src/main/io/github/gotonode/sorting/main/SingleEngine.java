package io.github.gotonode.sorting.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import io.github.gotonode.sorting.enums.ArrayFillMethod;
import io.github.gotonode.sorting.interfaces.Engine;
import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * SingleEngine, a special case of Engine, runs your chosen algorithm a set
 * number of times. Unlike MultiEngine, this tests only a single algorithm at
 * once. You can run the tests once or multiple times.
 */
public class SingleEngine implements Engine {

    private int[] array;

    private final Generator generator;

    private ArrayList<Long> times;

    private final Sorter sortAlgorithm;

    /**
     * Constructs a new SingleEngine.
     *
     * @param sortAlgorithm The sorting algorithm to be used. There are many to
     * choose form.
     */
    public SingleEngine(Sorter sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;

        generator = new Generator(1337);
    }

    @Override
    public String toString() {
        return "SingleEngine";
    }

    @Override
    public String explanation() {
        return "This engine tests a single algorithm either once or many times.";
    }

    @Override
    public void run(int exponent, ArrayFillMethod arrayFillMethod, int iterations) {

        times = new ArrayList<>(iterations);

        System.out.println("\nRunning " + sortAlgorithm.toString() + " " + iterations + " time(s) with " + arrayFillMethod.name() + "-ordered arrays of size 10^" + exponent + ".\n");

        for (int i = 0; i < iterations; i++) {

            if (iterations > 1) {
                if (Main.VERBOSE_OUTPUT) {
                    System.out.print("Iteration " + (i + 1) + " of " + iterations + "..." + " ");
                }
            }

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

            if (Main.PRINT_ARRAY) {
                System.out.println("Printing array BEFORE sort operation:");
                Tools.printArray(array);
            }

            long start = System.currentTimeMillis();

            array = sortAlgorithm.sort(array);

            long end = System.currentTimeMillis();

            long difference = end - start;

            times.add(difference);

            if (Main.VERBOSE_OUTPUT) {
                System.out.print("Completed in " + difference + " ms." + " ");
            }

            if (Main.VERIFY_SORT_SUCCESS) {

                boolean arrayIsOkay = Tools.verifySort(array);

                if (arrayIsOkay) {
                    if (Main.VERBOSE_OUTPUT) {
                        System.out.print("Verification OK.\n");
                    }
                } else {
                    System.out.print("Verification FAILED. Array NOT in ascending order after sorting.\n");
                }

            }

            if (Main.PRINT_ARRAY) {
                System.out.println("Printing array AFTER sort operation:");
                Tools.printArray(array);
            }
        }
    }

    /**
     * Returns, as a list, the individual times it took to sort the array.
     *
     * @return A list of long values.
     */
    public List<Long> getTimes() {
        return Collections.unmodifiableList(times);
    }

    /**
     * Clears the gathered test times from this Engine.
     */
    public void clearTimes() {
        times.clear();
    }

}
