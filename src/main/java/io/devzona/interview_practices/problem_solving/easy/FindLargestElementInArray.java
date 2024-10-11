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

    public static int sort(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
