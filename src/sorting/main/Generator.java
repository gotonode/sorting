package sorting.main;

import java.security.SecureRandom;
import java.util.Random;

/**
 * This class has different methods of filling an array of integers with.
 *
 * You can generate an array pseudorandomly, in ascending order, in descending
 * order and in a way in which it is filled with a single digit.
 *
 * By default, an array will have values from 0 to n-1 where n is the size of
 * the array. So for an example, if you have an array of 10^7 elements
 * (10,000,000), it will be filled with values from 0 to 9,999,999.
 */
public class Generator {

    private final Random random;
    private final SecureRandom secureRandom;

    private final long seed; // Seed is stored here for reference.

    /**
     * Constructor without a seed.
     */
    public Generator() {

        this.seed = -1; // Seed isn't used.

        random = new Random();
        secureRandom = new SecureRandom();
    }

    /**
     * Constructor with a given seed.
     *
     * @param seed The long value used as the seed.
     */
    public Generator(long seed) {

        this.seed = seed;

        random = new Random(this.seed);
        secureRandom = new SecureRandom();
        secureRandom.setSeed(this.seed);
    }

    /**
     * Generates a pseudorandom array of integers.
     *
     * @param exponent The exponent, to which 10 is raised to.
     * @return The newly generated pseudorandom array.
     */
    public int[] generateRandomArray(int exponent) {

        int n = (int) Math.pow(10, exponent);

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = random.nextInt(n);
        }

        return output;
    }

    /**
     * Generates a more secure pseudorandom array of integers.
     *
     * This is slower than generateRandomArray.
     *
     * @param exponent The exponent, to which 10 is raised to.
     * @return The newly generated, more secure pseudorandom array.
     */
    public int[] generateSecureRandomArray(int exponent) {

        int n = (int) Math.pow(10, exponent);

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = secureRandom.nextInt(n);
        }

        return output;
    }

    /**
     * Generates an array of integers from 0 to n-1, in ascending order.
     *
     * @param exponent The exponent, to which 10 is raised to.
     * @return The newly generated, ordered array.
     */
    public int[] generateOrderedArray(int exponent) {

        int n = (int) Math.pow(10, exponent);

        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = i;
        }

        return output;
    }

    /**
     * Generates an array of integers from n-1 to 0, in descending order.
     *
     * @param exponent The exponent, to which 10 is raised to.
     * @return The newly generated, reverse-ordered array.
     */
    public int[] generateReverseOrderedArray(int exponent) {

        int n = (int) Math.pow(10, exponent);

        int[] output = new int[n];

        int pos = 0;

        for (int i = n - 1; i >= 0; i--) {
            output[pos] = i;
            pos++;
        }

        return output;
    }

    /**
     * Generates an array of integers, where all integers are the same.
     *
     * @param exponent The exponent, to which 10 is raised to.
     * @param value The integer value to fill the array with.
     * @return The newly generated array, filled with the given value.
     */
    public int[] generateArrayWithSoleValue(int exponent, int value) {

        int n = (int) Math.pow(10, exponent);

        int[] output = new int[n];

        if (value == 0) {
            // By default, an array is filled with 0's.
            return output;
        }

        for (int i = 0; i < n; i++) {
            output[i] = value;
        }

        return output;
    }

}
