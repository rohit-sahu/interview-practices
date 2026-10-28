package io.devzona.interview_practices.problem_solving.easy;

import java.util.stream.Stream;

public class StringProblem {

    public static void main(String[] args) {
        String out = Stream.of("Java", "HTML").filter(s -> s.equals("HTML")).findFirst().orElse(null);
        System.out.println(out);
    }
}
