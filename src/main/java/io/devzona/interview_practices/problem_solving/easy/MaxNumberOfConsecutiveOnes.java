package io.devzona.interview_practices.problem_solving.easy;

public class MaxNumberOfConsecutiveOnes {

    public static int maxNumberOfConsecutiveOnes(int[] arr) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            } else {
                count++;
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,1};
        System.out.println(maxNumberOfConsecutiveOnes(arr));
    }
}
