package io.devzona.interview_practices.problem_solving.easy;

import java.util.Arrays;

/**
 * Given an array, we have to find the largest element in the array.
 *
 * Example 1:
 * Input:
 *  arr[] = {2,5,1,3,0};
 * Output:
 *  5
 * Explanation:
 *  5 is the largest element in the array.
 *
 * Example2:
 * Input:
 *  arr[] = {8,10,5,7,9};
 * Output:
 *  10
 * Explanation:
 *  10 is the largest element in the array.
 *
 */
public class FindLargestElementInArray {

    public static void main(String[] args) {

        int[] arr1 = {2, 5, 1, 3, 0};
        System.out.println("The Largest element in the array is: " + sort(arr1));

        int[] arr2 = {8, 10, 5, 7, 9};
        System.out.println("The Largest element in the array is: " + sort(arr2));
    }

    /**
     * Solution1: Sorting
     * Intuition:
     * We can sort the array in ascending order, hence the largest element will be at the last index of the array.
     *
     * Approach:
     * Sort the array in ascending order.
     * Print the (size of the array -1)th index.
     *
     * @param arr
     * @return largest number
     */
    public static int sort(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }


    /**
     * Solution2: Using a max variable (Recursive Approach)
     * Intuition:
     * We can maintain a max variable that will update whenever the current value is greater than the value in the max variable.
     *
     * Approach:
     * Create a max variable and initialize it with arr[0].
     * Use a for loop and compare it with other elements of the array
     * If any element is greater than the max value, update max value with the element’s value
     * Print the max variable.
     *
     * @param arr
     * @return largest number
     */
    public static int findLargestElement(int[] arr) {
        int max= arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max= arr[i];
            }
        }
        return max;
    }
}
