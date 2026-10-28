package io.devzona.interview_practices.problem_solving.easy;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        //Arrays.stream(fibonacci(10)).forEach(ints -> System.out.println(ints));
        int n = 5;
        int result = nthFibonacci(n);
        System.out.println(result);
    }

    public static int[] fibonacci(int n) {
        //[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
        int[] out = new int[n];
        out[0] = 0;
        out[1] = 1;
        for (int i = 2; i < n; i++) {
            out[i] = out[i-1] + out[i-2];
        }
        return out;
    }

    /**
     * Function to calculate the nth Fibonacci number using recursion
     */
    public static int nthFibonacci(int n){
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Recursive case: sum of the two preceding Fibonacci numbers
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }
}
