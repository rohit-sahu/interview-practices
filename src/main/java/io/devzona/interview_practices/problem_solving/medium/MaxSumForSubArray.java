package io.devzona.interview_practices.problem_solving.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxSumForSubArray {

    public static void main(String[] args) {
        System.out.println(findMaxSumInSubArray(new int[] {-1, 2, 3, 3, 4, 5, -1}, 3));
        System.out.println(findMaxSumInSubArray(new int[] {-1, 2, 10, 3, 4, 5, -1}, 3));
        findSubArrayForGivenSumApproach1(new int[] {1, 4, 0, 0, 3, 10, 5}, 7).forEach(System.out::println);
    }

    public static int findMaxSumInSubArray(int[] arr, int k) {
        //{-1, 2, 3, 3, 4, 5, -1}
        int l = 0, r = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
            r++;
        }
        while (r < arr.length) {
            int nextSum = sum + arr[r++] - arr[l++];
            //sum = Math.max(sum, nextSum);
            if (sum < nextSum) {
                sum = nextSum;
            }
        }
        return sum;
    }

    /**
     * Input: arr[] = { 15, 2, 4, 8, 9, 5, 10, 23}, sum = 23
     * Output: 2 5
     * Explanation: Sum of elements between indices 2 and 5 is 2 + 4 + 8 + 9 = 23
     *
     *
     * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
     * Output: 2 5
     * Explanation: Sum of elements between indices 2 and 5 is 4 + 0 + 0 + 3 = 7
     *
     *
     * Input: arr[] = {1, 4}, sum = 0
     * Output: -1
     * Explanation: There is no subarray with 0 sum
     * @return
     */
    public static List<Integer> findSubArrayForGivenSumApproach1(int[] arr, int sum) {
        int l = 0, r = 0, nextSum = 0;
        boolean flag = false;
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nextSum += arr[i];
            if (nextSum >= sum) {
                r = i;
                while (sum < nextSum && l < r) {
                    nextSum -= arr[l++];
                }
                if (nextSum == sum) {
                    integers.add(l);
                    integers.add(r);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            integers.add(-1);
        }
        return integers;
    }

    /**
     * Subarray with Given Sum – Handles Negative Numbers
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * Output: Sum found between indexes 2 and 4
     * Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
     *
     *
     * Input: arr[] = {2, 12, -2, -20, 10}, sum = -10
     * Output: Sum found between indexes 1 to 3
     * Explanation: Sum of elements between indices 0 and 3 is 12 – 2 – 20 = -10
     *
     *
     * Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
     * Output: No subarray with given sum exists
     * Explanation: There is no subarray with the given sum
     *
     * @param arr
     * @param sum
     */
    public static void findSubArrayForGivenSumApproach2(int[] arr, int sum) {
        int l = 0, r = -1, currentSum = 0;
        HashMap<Integer, Integer> integers = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum - sum == 0) {
                l = 0;
                r = i;
                break;
            }
            if (integers.containsKey(currentSum - sum)) {
                l = integers.get(currentSum - sum) + 1;
                r = i;
                break;
            }
            integers.put(currentSum, i);
        }
    }

    /**
     * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     *
     */
    public static int findTotalSubArrayCountForGivenSum(int[] arr, int k) {
        int l = 0, r = 0, currentSum = 0, count = 0;
        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum >= k) {
                r = i;
                while((k < currentSum) && l < r) {
                    currentSum -= arr[l++];
                }
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
