package io.devzona.interview_practices.problem_solving.easy;

import java.util.*;

public class ArrayProblem {

    public static void occurencesOfElement(String[] arr) {
        HashMap<String, Integer> counter = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(counter.containsKey(arr[i])) {
                counter.put(arr[i], counter.get(arr[i]) + 1);
            } else {
                counter.put(arr[i], 1);
            }
        }
        for(Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * int arr[][] = {
     *             {0, 0, 0, 0},
     *             {0, 0, 1, 0},
     *             {1, 0, 1, 1},
     *             {1, 1, 1, 1}
     *         };
     *
     * @return int value
     */
    public static int findRowWithMaxOnes(int[][] arr) {
        int max = 0;
        int row = 0;
        for(int i = 0; i < arr.length; i++) {
            int counter = 0;
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    counter++;
                }
            }
            if(counter > max) {
                max = counter;
                row = i;
            }
        }
        return max;
    }

    /**
     * int arr[][] = {
     *             {0, 0, 0, 0},
     *             {0, 0, 1, 0},
     *             {1, 0, 1, 1},
     *             {1, 1, 1, 0}
     *         };
     *
     * @return int value
     */
    public static int findRowWithMaxConsecutiveOnes(int[][] arr) {
        int max = 0;
        int row = 0;
        for(int i = 0; i < arr.length; i++) {
            int counter = 0;
            int maxj= 0;
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1) {
                    counter++;
                    maxj = Math.max(maxj, counter);
                } else {
                    counter = 0;
                }
            }
            if(maxj > max) {
                max = maxj;
                row = i;
            }
        }
        System.out.println("Row No: " + row);
        return max;
    }

    /**
     * int[] arr = {10, 2, 4, 6, 8, 9, 1, 3, 5};
     *
     * @param arr - array of elements
     * @param size - sub array size
     * @return max
     */
    public static int findMaxSumSubArray(int[] arr, int size) {
        int max = 0;
        for(int i = 0; i < size; i++) {
            max += arr[i];
        }
        int sum = max;
        for(int i = 1; i < arr.length - size; i++) {
            sum = sum - arr[i - 1] + arr[i + size - 1];
            //max = Math.max(max, sum);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * maximum Sum of given SubArray which sum <= k
     * <p>
     * int[] arr = {2, 5, 1, 10, 10};
     * k = 14
     *
     * @param arr - array of integer
     * @param sum - given sum
     * @return length of subarray
     */
    public static int maxSumSubArray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int max = 0;
        int startIndex = 0, endIndex = 0;
        int maxLength = 0;
        while(right < arr.length) {
            sum += arr[right++];
            while(sum > k) {
                sum = sum - arr[left++];
            }
            if(sum <= k) {
                max = Math.max(max, sum);
                startIndex = left - 2;
                endIndex = right - 2;
            }
        }
        System.out.println("Max Length: " + maxLength);
        System.out.println("Start Index : " + startIndex + " End Index : " + endIndex);
        return max;
    }

    /**
     * getAllSubArray of length which sum <= k
     * <p>
     * int[] arr = {2, 5, 2, 1, 10, 10};
     * k = 14
     *
     * @param arr - array of integer
     * @param sum - given sum
     * @return length of subarray
     */
    public static void getAllSubArray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while(right < arr.length) {
            sum += arr[right];
            while(sum > k) {
                sum -= arr[left++];
            }
            // All contiguous subarrays ending at 'right' and starting from
            // any index between 'left' and 'right' are valid
            for (int i = left; i <= right; i++) {
                result.add(Arrays.copyOfRange(arr, i, right + 1));
            }
            right++;
        }
        result.forEach(ints ->  System.out.println(Arrays.toString(ints)));
    }

    /**
     * get the Subarrays Of Length L and Sum Less Than or equal to K
     * int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
     * int L = 3;
     * int k = 10;
     *
     * @param arr
     * @param L
     * @param k
     */
    public static void getSubarraysOfLengthWithSumLessThanK(int[] arr, int L, int k) {
        int sum = 0;
        int left = 0;
        int right = 0;
        List<int[]> result = new ArrayList<>();
        while(right < L) {
            sum += arr[right++];
        }
        if(sum <= k) {
            result.add(Arrays.copyOfRange(arr, left, right));
        }
        while(right < arr.length) {
            sum = sum + arr[right++] - arr[left++];
            if(sum <= k) {
                result.add(Arrays.copyOfRange(arr, left, right));
            }
        }
        result.forEach(ints ->  System.out.println(Arrays.toString(ints)));
    }

    public static void main(String[] args) {
        occurencesOfElement(new String[] {"a", "b", "c", "a", "b", "c"});
        int[][] arr = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(findRowWithMaxOnes(arr));
        int[][] arr1 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 0}
        };
        System.out.println(findRowWithMaxConsecutiveOnes(arr));
        System.out.println(maxSumSubArray(new int[] {2, 5, 1, 10, 10}, 14));
        getAllSubArray(new int[] {2, 5, 2, 1, 10, 10}, 14);
        System.out.println("================getSubarraysOfLengthWithSumLessThanK================");
        getSubarraysOfLengthWithSumLessThanK(new int[] {1, 4, 2, 10, 2, 3, 1, 0, 20}, 3, 10);
    }
}
