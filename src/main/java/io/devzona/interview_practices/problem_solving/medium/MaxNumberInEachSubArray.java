package io.devzona.interview_practices.problem_solving.medium;

import java.util.*;

public class MaxNumberInEachSubArray {

    public static void main(String[] args) {
        System.out.println("Approach 1");
        fetchMaxNumberInEachSubArrayApproach1(new int[]{2, 6, -1, 2, 4, 1, -6, 5}, 3).forEach(System.out::println);
        System.out.println("Approach 2");
        fetchMaxNumberInEachSubArrayApproach2(new int[]{2, 6, -1, 2, 4, 1, -6, 5}, 3).forEach(System.out::println);
        System.out.println("Approach 3");
        printMax(new int[]{2, 6, -1, 2, 4, 1, -6, 5}, 8, 3);
    }

    /**
     * Maximum of all subarrays of size k ({2,6,-1,2,4,1,-6,5} k=3)
     *
     * <pre>Solution
     * Create a priority queue that stores the elements in descending order of priority.
     * Add the first k numbers in the priority queue.
     * Print the maximum element in the first subarray.
     * Remove the first element from the priority queue.
     * Similarly, update the priority queue in every iteration and display the maximum element in each window.
     *
     * @param arr
     * @param k
     * @return list
     */
    public static List<Integer> fetchMaxNumberInEachSubArrayApproach1(int[] arr, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for (i = 0; i < k; i++) {
            integers.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(integers.peek());
        integers.remove(arr[0]);
        for (; i < arr.length; i++) {
            integers.add(arr[i]);
            list.add(integers.peek());
            integers.remove(arr[i - k + 1]);
        }
        return list;
    }


    /**
     * Maximum of all subarrays of size k ({2,6,-1,2,4,1,-6,5} k=3)
     *
     * <pre>Solution
     * Create a priority queue that stores the elements in descending order of priority.
     * Add the first k numbers in the priority queue.
     * Print the maximum element in the first subarray.
     * Remove the first element from the priority queue.
     * Similarly, update the priority queue in every iteration and display the maximum element in each window.
     *
     * @param arr
     * @param k
     * @return list
     */
    public static List<Integer> fetchMaxNumberInEachSubArrayApproach2(int[] arr, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k - 1) {
                integers.add(arr[i]);
            } else {
                integers.add(arr[i]);
                list.add(integers.peek());
                integers.remove(arr[i - k + 1]);
            }
        }
        return list;
    }

    public static void printMax(int arr[], int N, int K) {

        // Create a Double Ended Queue, Qi that will store indexes of array elements. The queue will store indexes of
        // useful elements in every window and it will maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<>();
        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < K; ++i) {
            // For every element, the previous smaller elements are useless so remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast(); // Remove from rear
            }
            Qi.addLast(i); // Add new element at rear of queue
        }
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {
            // The element at the front of the queue is the largest element of previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K) {
                Qi.removeFirst();
            }
            // Remove all elements smaller than the currently being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) {
                Qi.removeLast();
            }
            Qi.addLast(i); // Add current element at the rear of Qi
        }
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }
}
