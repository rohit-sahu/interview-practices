package io.devzona.interview_practices.problem_solving.easy;

import java.util.stream.Stream;

public class StringProblem {

    public static void main(String[] args) {
        System.out.println(Stream.of("Java", "HTML").filter(s -> s.equals("HTML")).findFirst());
    }
}
