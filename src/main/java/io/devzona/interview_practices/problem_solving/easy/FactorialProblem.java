package io.devzona.interview_practices.problem_solving.easy;

public class FactorialProblem {

    public static int getFactorial(int number) {
        if (number == 1) return 1;
        return number * getFactorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(4));
    }
}
