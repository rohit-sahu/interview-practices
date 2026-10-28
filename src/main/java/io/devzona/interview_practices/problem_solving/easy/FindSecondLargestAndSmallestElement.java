package io.devzona.interview_practices.problem_solving.easy;

import java.util.Arrays;

/**
 * Problem Statement: Given an array, find the second smallest and second largest element in the array.
 * Print ‘-1’ in the event that either of them doesn’t exist.
 */
public class FindSecondLargestAndSmallestElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 5};
        int n = arr.length;
        getElements(arr, n);
        getElementsSecondApproach(arr, n);
    }

    /**
     * Solution 1: (Brute Force) [this approach only works if there are no duplicates]
     * Intuition:
     * What do we do to find the largest or the smallest element present in an array? We ideally sort them and the first element would be the smallest of all while the last element would be the largest. Can we find the second-smallest and second-largest using a similar approach?
     *
     * Approach:
     * Sort the array in ascending order
     * The element present at the second index is the second smallest element
     * The element present at the second index from the end is the second largest element
     *
     * @param arr
     * @param n
     */
    private static void getElements(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n - 2];
        System.out.println("Second smallest is " + small);
        System.out.println("Second largest is " + large);
    }

    /**
     * Solution 2(Better Solution)
     * Intuition:
     * Even though we want to have just the second smallest and largest elements, we are still sorting the entire array for that and thus increasing the time complexity. Can we somehow try to not sort the array and still get our answer?
     *
     * Approach:
     * Find the smallest and largest element in the array in a single traversal
     * After this, we once again traverse the array and find an element that is just greater than the smallest element we just found.
     * Similarly, we would find the largest element which is just smaller than the largest element we just found
     * Indeed, this is our second smallest and second largest element.
     *
     * @param arr
     * @param n
     */
    private static void getElementsSecondApproach(int[] arr, int n) {
        if (n == 0 || n == 1) {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = Math.max(large, arr[i]);
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        System.out.println("Second smallest is " + second_small);
        System.out.println("Second largest is " + second_large);
    }
}
