package io.devzona.interview_practices.problem_solving.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array arr[] of N integers such that the last element of the given array is adjacent
 * to the first element of the array, the task is to print the Next Greater Element in this circular array.
 * Elements for which no greater element exist, consider the next greater element as “-1”.
 * <p>
 * Input: arr[] = {5, 6, 7}
 * Output: {6, 7, -1}
 * Explanation:
 * Next Greater Element for 5 is 6, for 6 is 7, and for 7 is -1 as we don’t have any element greater than
 * itself so its -1.
 * <p>
 * <p>
 * Input: arr[] = {4, -2, 12, 8}
 * Output: {5, 5, 8, -1}
 * Explanation:
 * Next Greater Element for 4 is 5, for -2 its 5, for 5 is 8, and for 8 is -1 as we don’t have any element
 * greater than itself so its -1, and for 3 its 4.
 */
public class NextGreatestElement {

    public static void printNGEApproach1(int[] A, int n) {
        // Formation of circular array
        int[] arr = new int[2 * n];
        // Append the given array element twice
        for (int i = 0; i < 2 * n; i++)
            arr[i] = A[i % n];
        int next;
        // Iterate for all the elements of the array
        for (int i = 0; i < n; i++) {
            // Initialise NGE as -1
            next = -1;
            for (int j = i + 1; j < 2 * n; j++) {
                // Checking for next greater element
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            // Print the updated NGE
            System.out.println(next + ", ");
        }
    }

    // Function to find the Next Greater Element(NGE)
    public static void printNGEApproach2(int A[], int n) {
        int k;
        for (int i = 0; i < n; i++) {
            // Initialise k as -1 which is printed when no NGE found
            k = -1;
            for (int j = i + 1; j < n + i; j++) {
                if (A[i] < A[j % n]) {
                    System.out.print(A[j % n] + " ");
                    k = 1;
                    break;
                }
            }
            // Gets executed when no NGE found
            if (k == -1)
                System.out.println("-1 ");
        }
    }

    public static void printNGEApproach3(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Remove all the elements in Stack that are less than arr[i%n]
            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty())
                    result[i] = stack.peek();
                else
                    result[i] = -1; // When none of elements in Stack are greater than arr[i%n]
            }
            stack.push(arr[i % n]);
        }
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    public static void nGEApproach4(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            // Remove all the elements in Stack that are less than arr[i%n]
            while (!stack.isEmpty() && arr[i % n] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i % n];
            }
            if (i < n)
                stack.push(i);
        }
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    // Driver Code
    public static void main(String args[]) {
        // Given array arr[]
        //int[] arr = {1, 2, 1};
        int[] arr = {4, -2, 12, 8};
        int[] arr1 = {4, 5, 2, 1, 3, 7, 6};
        int[] arr2 = {4, 5, 2, 1, 3, 7, 3};
        int N = arr.length;
        //printNGEApproach1(arr, N);
        nGEApproach4(arr2);
    }

}
