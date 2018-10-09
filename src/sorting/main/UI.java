package sorting.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import sorting.interfaces.Sorter;

/**
 * Most of the user interface handling is done here.
 */
public class UI {

    private final Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Ask which method to use when filling the array.
     *
     * @return The chosen method for filling the array with, as an integer.
     */
    public char askForArrayFillMethod() {

        System.out.println("\nHow to create your new array? Pseudorandom ordering is the default.");
        System.out.println("[P] Order the integers pseudorandomly, ex. [2, 0, 1]");
        System.out.println("[A] Order the integers in ascending order, ex. [0, 1, 2]");
        System.out.println("[D] Order the integers in descending order, ex. [2, 1, 0]");
        System.out.println("[N] No fill (by default it will be full of zeros), ex. [0, 0, 0]");

        char type = askForCharacter(new char[]{'P', 'A', 'D', 'N'});

        return type;
    }

    /**
     * Ask for which sorting algorithm to use.
     *
     * @param algorithms
     * @return The chosen sorting algorithm, as an integer.
     */
    public char askForAlgorithm(List<Sorter> algorithms) {

        // Should this class be knowledgeable of Sorter?
        // Separation of concern comes to mind. This isn't a cyclomatic dependency, however.
        System.out.println("\nWhich sorting algorithm to use?");

        char[] chars = new char[algorithms.size()];

        for (int i = 0; i < algorithms.size(); i++) {
            Sorter sorter = algorithms.get(i);

            char c = sorter.code();
            chars[i] = c;

            System.out.println("[" + c + "]" + " " + sorter.toString());

        }

        char choice = askForCharacter(chars);

        return choice;
    }

    /**
     * Ask the exponent to which 10 is raised to.
     *
     * @return An integer, usually between 4 and 8.
     */
    public int askForExponent() {

        System.out.println("\nWe're going to be creating an array of integers.");
        System.out.println("Please specify which exponent to use, to which 10 is raised to.");
        System.out.println("For an example, if you give a 6, the array will have 10^6 = 1,000,000 values.");
        System.out.println("Example values for different exponents:");

        for (int i = 4; i <= 7; i++) {
            System.out.println("10^" + i + " = " + (int) Math.pow(10, i));
        }

        int exponent = askForInteger(0, 9);

        return exponent;
    }

    /**
     * Ask how many times we should run the tests. Defaults to 1.
     *
     * @return An integer, always at least 1.
     */
    public int askForIterationCount() {

        System.out.println("\nHow many iterations? Default is one (1).");

        int iterations = askForInteger(1, 100000000);

        return iterations;
    }

    /**
     * Ask the user if he/she would like to test a single algorithm, or all of
     * them at once. This choice affects which Engine will be used.
     *
     * @return A character, either 'S' for Single or 'A' for All.
     */
    public char askForTestType() {

        System.out.println("Would you like to test a single algorithm or all of them at once?");
        System.out.println("[S] Single");
        System.out.println("[A] All of them");

        char type = askForCharacter(new char[]{'S', 'A'});

        return type;
    }

    /**
     * Continuously asks the user for an integer, unless an integer that is
     * between the min and max values specified is given, which is then
     * returned.
     *
     * @param minValue Minimum value for the integer (ex. 0).
     * @param maxValue Maximum value for the integer (ex. Integer.MAX_VALUE).
     * @return An integer between minValue and maxValue.
     */
    private int askForInteger(int minValue, int maxValue) {

        while (true) {

            System.out.print("Your choice: ");

            if (scanner.hasNext() && scanner.hasNextInt()) {

                int input = scanner.nextInt();

                if (input < minValue || input > maxValue) {
                    System.out.println("Please enter a valid integer between " + minValue + " and " + maxValue + ".");

                } else { // Valid integer given.
                    return input; // Return the proper value.

                }

            } else {
                System.out.println("Please enter an integer.");
                scanner.next();
            }
        }
    }

    /**
     * Continuously asks the user for a character, unless a character that is in
     * allowedChars is given, which is then returned.
     *
     * @param allowedChars An array of char that contains the legal choices.
     * @return A single character from allowedChars.
     */
    private char askForCharacter(char[] allowedChars) {

        while (true) {

            System.out.print("Your choice: ");

            if (scanner.hasNext()) {

                String next = scanner.next();

                if (next.length() > 1) {
                    System.out.println("Please only enter 1 character.");
                    continue;
                }

                char input = next.toUpperCase().charAt(0);

                boolean found = false;

                for (char c : allowedChars) {
                    if (input == c) {
                        found = true;
                        break;
                    }
                }

                if (found == false) {
                    System.out.println("Please enter a character from the following: " + Arrays.toString(allowedChars));
                } else {
                    return input;
                }
            }
        }
    }

}
