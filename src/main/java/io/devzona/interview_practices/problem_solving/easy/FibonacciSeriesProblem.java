package io.devzona.interview_practices.problem_solving.easy;

import java.util.Arrays;

public class FibonacciSeriesProblem {

    public static int[] getFibonacciSeries(int n) {
        int num1 = 0;
        int num2 = 1;
        int [] arr = new int[n];
        arr[0] = num1;
        arr[1] = num2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static int sumFibonacciSeries(int n) {
        return Arrays.stream(getFibonacciSeries(n)).sum();
    }

    public static void sumFibonacciSeriesWithRecursion(int n1, int n2, int startIndex, int[] result) {
        if (startIndex < result.length) {
            if (startIndex == 0) {
                result[startIndex++] = n1;
                result[startIndex++] = n2;
            } else {
                result[startIndex++] = n1 + n2;
            }
            sumFibonacciSeriesWithRecursion(result[startIndex - 2], result[startIndex - 1], startIndex, result);
        }
    }

    public static void main(String[] args) {
        Arrays.stream(getFibonacciSeries(10)).forEach(System.out::println);
        System.out.println(sumFibonacciSeries(10));
        System.out.println("===============================");
        int[] arr = new int[10];
        sumFibonacciSeriesWithRecursion(0, 1, 0, arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
