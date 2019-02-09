package io.github.gotonode.sorting.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.github.gotonode.sorting.enums.ArrayFillMethod;
import io.github.gotonode.sorting.enums.SortingAlgorithm;
import io.github.gotonode.sorting.interfaces.Sorter;

/**
 * Welcome! This app contains different sorting algorithms that can be
 * evaluated.
 *
 * First, an array of integers is generated. Then, your chosen sorting algorithm
 * is used to sort the array into ascending (natural) order.
 *
 * This app will report how long it took to sort the array.
 *
 * The implemented sorting algorithms can be found in the "sorting.algorithms"
 * package. They are designed to be self-reliant, so you can easily copy & paste
 * them to your own projects. Feel free to do so!
 *
 * Contains quick & dirty code that will be improved over time. Definitely.
 *
 * Any and all feedback will be warmly welcome. Thanks!
 */
public class Main {

    // Set to true to print the contents of the array before and after each run.
    public static final boolean PRINT_ARRAY = false;

    // Set to false to disable the verification of the sorted array.
    public static final boolean VERIFY_SORT_SUCCESS = true;

    // Set to true to terminate runtime if array check fails (array has inversions).
    public static final boolean ERROR_ON_ARRAY_INVERSIONS = true;

    // Set to false to stop displaying additional console (stdout) output.
    public static final boolean VERBOSE_OUTPUT = true;

    /**
     * This is the main entry point for the application.
     *
     * @param args Arguments that can be passed. A set of four values can be
     * provided here. Please run the app once and see what they need to be, if
     * you wish to start this app with the parameters directly (rather than
     * giving them via the console).
     */
    public static void main(String[] args) {

        UI userInterface = new UI(new Scanner(System.in));

        if (args.length > 0) {
            launchWithArguments(userInterface, args);
        } else {
            launchWithoutArguments(userInterface);
        }
    }

    private static void runSingle(Integer iterations, UI userInterface, Sorter sortingAlgorithm, int exponent, ArrayFillMethod arrayFillMethod) throws NumberFormatException {

        if (iterations == null) {
            iterations = userInterface.askForIterationCount();
        }

        // Create a new Engine with the given sorting algorithm.
        SingleEngine engine = new SingleEngine(sortingAlgorithm);

        // Run your chosen algorithm a set amount of times.
        engine.run(exponent, arrayFillMethod, iterations);

        // Get the results from the Engine.
        List<Long> times = engine.getTimes();

        // Calculate and print the results to the console.
        Tools.calculateAndPrintResults(times);
    }

    private static void runAll(int exponent, ArrayFillMethod arrayFillMethod) {
        // Testing all of the algorithms at once.
        MultiEngine multiEngine = new MultiEngine();
        multiEngine.run(exponent, arrayFillMethod, 0);
    }

    private static void launchWithArguments(UI userInterface, String[] args) {
        Pattern pattern = Pattern.compile("[BCHIJMQ]{1} [1-9]{1} [PADN]{1} \\d+");

        // TODO: This can be improved.
        String s = Arrays.asList(args).toString().replace(",", "").replace("[", "").replace("]", "");

        Matcher matcher = pattern.matcher(s);

        System.out.println("Launched with arguments: " + Arrays.toString(args));

        if (matcher.find() == false) {
            System.out.println("Bad arguments. Please see the accompanied 'README.md' file.");
            System.exit(1);
        }

        char type = userInterface.askForTestType();

        Sorter sortingAlgorithm = null;

        if (type == 'S') {

            char algorithm = args[0].toUpperCase().charAt(0); // Will fail on bad input.

            // This line of code is horrible! Please do not look here or read this line.
            sortingAlgorithm
                    = Arrays.asList(SortingAlgorithm.values())
                            .stream()
                            .filter(a -> a.getSorter().code().equals(algorithm))
                            .findFirst()
                            .get()
                            .getSorter();
        }

        int exponent = Integer.valueOf(args[1]);

        char fillMethod = args[2].toUpperCase().charAt(0);

        ArrayFillMethod arrayFillMethod
                = Arrays.asList(ArrayFillMethod.values())
                        .stream()
                        .filter(a -> a.getType() == fillMethod)
                        .findFirst()
                        .get();

        if (type == 'A') {
            runAll(exponent, arrayFillMethod);
        } else {
            runSingle(1, userInterface, sortingAlgorithm, exponent, arrayFillMethod);
        }
    }

    private static void launchWithoutArguments(UI userInterface) {

        char type = userInterface.askForTestType();

        Sorter sortingAlgorithm = null;

        if (type == 'S') {

            char algorithm;

            List<Sorter> sorters = new ArrayList<>(SortingAlgorithm.values().length);

            for (SortingAlgorithm sa : SortingAlgorithm.values()) {
                sorters.add(sa.getSorter());
            }

            algorithm = userInterface.askForAlgorithm(sorters);

            // This line of code is horrible! Please do not look here or read this line.
            sortingAlgorithm
                    = Arrays.asList(SortingAlgorithm.values())
                            .stream()
                            .filter(a -> a.getSorter().code().equals(algorithm))
                            .findFirst()
                            .get()
                            .getSorter();

            System.out.println("Okay, you chose " + sortingAlgorithm.toString() + "." + " " + sortingAlgorithm.explanation());
        }

        int exponent = userInterface.askForExponent();

        System.out.println("Okay, you'll get an array that has " + (int) Math.pow(10, exponent) + " values.");

        char fillMethod = userInterface.askForArrayFillMethod();

        ArrayFillMethod arrayFillMethod
                = Arrays.asList(ArrayFillMethod.values())
                        .stream()
                        .filter(a -> a.getType() == fillMethod)
                        .findFirst()
                        .get();

        if (type == 'A') {
            runAll(exponent, arrayFillMethod);
        } else {
            runSingle(null, userInterface, sortingAlgorithm, exponent, arrayFillMethod);
        }
    }

}
