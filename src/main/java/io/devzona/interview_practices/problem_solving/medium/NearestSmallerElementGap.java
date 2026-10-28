package io.devzona.interview_practices.problem_solving.medium;

import java.util.*;

/**
 * Next Smaller Element Gap
 * Given an array, print the Next Smaller Element (NSE) for every element.
 * The NSE for an element x is the first smaller element on the right side of x in the array.
 * Elements for which no smaller element exist (on the right side), consider NSE as 0.
 */
public class NearestSmallerElementGap {

    // Function to print nearest smaller elements for each element in the array
    public static void printNSE(Integer[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of elements
        Integer[] ans = new Integer[n]; // Array to store the results
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            int next = arr[i];
            // Pop elements from the stack and update results for elements with smaller neighbors
            while (!stack.isEmpty() && arr[stack.peek()] > next) {
                ans[stack.pop()] = next;
            }
            stack.push(i);// Push the current index onto the stack
        }
        // For remaining elements in the stack, set their result to -1
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        List<Integer> integers = Arrays.asList(arr);
        // Print the original array elements and their corresponding nearest smaller elements
        for (int i = 0; i < ans.length; i++) {
            System.out.println(arr[i] + " --> " + ans[i]);
            System.out.println(ans[i] != -1 ? integers.indexOf(ans[i]) - i : 0);
        }
    }

    public static void printNSE(Integer[] arr, int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            int count = 0;
            for (j = i + 1; j < n; j++) {
                count++;
                if (arr[i] > arr[j]) {
                    break;
                }
            }
            System.out.println(arr[i] + " -- " + count);
        }
    }

    public static List<Integer> getGapBetweenTwoNumber(List<Integer> nums) {
        int l = 0, r = 0, min = nums.getFirst(), count = 0;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int next = nums.get(i);
            if (next > min) {
                count++;
                r++;
            } else {
                while (l < r) {
                    integers.add(count--);
                    min = nums.get(l++);
                }
                min = nums.get(l++);
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        Integer[] arr = {11, 13, 21, 3};
        printNSE(arr);
        System.out.println("====================");
        Integer[] arr1 = {40, 45, 43, 42, 35, 13, 21, 3};
        printNSE(arr1);
        System.out.println("====================");
        Integer[] arr2 = {40, 45, 42, 35, 13, 21, 3};
        printNSE(arr2);
        System.out.println("====================");
        Integer[] arr3 = {40, 45, 35, 13, 21, 3};
        printNSE(arr3);
        printNSE(arr3, arr3.length);

        List<Integer> integers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            integers.add(rand.nextInt(100));
        }
        integers.forEach(System.out::println);
        System.out.println("getGapBetweenTwoNumber ========================= getGapBetweenTwoNumber");
        getGapBetweenTwoNumber(integers).forEach(System.out::println);
        System.out.println("getGapBetweenTwoNumber ========================= getGapBetweenTwoNumber");
        getGapBetweenTwoNumber(List.of(arr2)).forEach(System.out::println);
    }
}
