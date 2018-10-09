package sorting.interfaces;

import sorting.enums.ArrayFillMethod;

public interface Engine {

    /**
     * Run the benchmark(s).
     *
     * @param exponent An integer, usually from 4 to 8, to which 10 is raised
     * to. Defines the array's size.
     * @param arrayFillMethod The method used to fill the generated array.
     * @param iterations How many times we run the test. Defaults to 1, and is
     * ignored when Engine is MultiEngine.
     */
    void run(int exponent, ArrayFillMethod arrayFillMethod, int iterations);

    /**
     * Returns the name of the engine.
     *
     * @return The name in simple string format, ex. "MultiEngine".
     */
    @Override
    String toString();

    /**
     * Gives a brief explanation of the engine.
     *
     * @return The explanation.
     */
    String explanation();

}
