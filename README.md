# Sorting

*A collection of sorting algorithms implemented in Java*

![App results](https://github.com/gotonode/sorting/blob/master/docs/images/app01.png)

## Included algorithms

| algorithm | source | info | time complexity |
| :-------  | :----- | :--- | :-------------- |
| Bubble Sort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/BubbleSort.java) | [info](https://en.wikipedia.org/wiki/Bubble_sort) | O(n^2) |
| Counting Sort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/CountingSort.java) | [info](https://en.wikipedia.org/wiki/Counting_sort) | O(n) |
| Heapsort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/Heapsort.java) | [info](https://en.wikipedia.org/wiki/Heapsort) | O(n log n) |
| Insertion Sort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/InsertionSort.java) | [info](https://en.wikipedia.org/wiki/Insertion_sort) | O(n^2) |
| JavaSort (internal) |  [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/JavaSort.java) | [info](https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort[int()]) | O(n log n) |
| Merge Sort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/MergeSort.java) | [info](https://en.wikipedia.org/wiki/Merge_sort) | O(n log n) |
| Quicksort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/Quicksort.java) | [info](https://en.wikipedia.org/wiki/Quicksort) | O(n log n) |
| Selection Sort | [source](https://github.com/gotonode/sorting/blob/master/src/sorting/algorithms/SelectionSort.java) | [info](https://en.wikipedia.org/wiki/Selection_sort) | O(n^2) |

Feel free to copy and use the algorithms in your own projects! :-)

## How to use

You can either test the speeds of **all of the algorithms at once**, or test a **single algorithm multiple times**.

First, you need to choose if you want to test a single algorithm (1 to n times) or all of the algorithms in a row once.

If you chose to test a single algorithm, you'll specify which one next.

Then you are asked for an exponent. We'll raise 10 to this exponent to determine the size of the array (of integers) that will be created. For an example, if you choose 6, your array will have 10^6 = 1,000,000 integers.

After that, an array of integers is created in one of four different ways:
- integers in pseudorandom order, ex. [2, 0, 1]
- integers in ascending order, ex. [0, 1, 2]
- integers in descending order, ex [2, 1, 0]
- no fill (by default, the array will be full of zeros), ex. [0, 0, 0]

Once you have indicated how you want your new array to be filled, you're almost ready.

Again, if you chose to test only a single algorithm, you need to specify how many times you want to run the tests.

Now the sorting tests are run and the times are reported to the console.

## Screenshots

Here's how the program flow looks like:

![App results](https://github.com/gotonode/sorting/blob/master/docs/images/app02.png)

## TODO

- include in-depth descriptions of each step in the algorithms
- refactoring
- implement more sorting algorithms
