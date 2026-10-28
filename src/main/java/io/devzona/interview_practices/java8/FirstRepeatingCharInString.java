package io.devzona.interview_practices.java8;

import java.util.*;

public class FirstRepeatingCharInString {

    public static void main(String[] args) {
        String str = "Rohit is java programmer";
        System.out.println("Approach 1");
        Set<Integer> seen = new HashSet<>();
        OptionalInt first = str.replace(" ", "").chars().filter(value -> !seen.add(value)).findFirst();
        if (first.isPresent()) {
            System.out.println((char) first.getAsInt());
        }
    }
}
