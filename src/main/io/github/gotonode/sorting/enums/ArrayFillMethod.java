package io.github.gotonode.sorting.enums;

/**
 * An enum used to house the different methods to fill an array.
 *
 * They are: pseudorandom (orders in a pseudorandom fashion), ascending (also
 * known as natural ordering, with zero inversions), descending (reverse of
 * natural ordering, with maximum inversions) and none (doesn't fill the array
 * with anything special).
 *
 */
public enum ArrayFillMethod {
    pseudorandom('P'), ascending('A'), descending('D'), none('N');

    private final char type;

    ArrayFillMethod(char type) {
        this.type = type;
    }

    public char getType() {
        return this.type;
    }

}
