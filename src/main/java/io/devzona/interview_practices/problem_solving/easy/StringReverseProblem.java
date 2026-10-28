package io.devzona.interview_practices.problem_solving.easy;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringReverseProblem {
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverseUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static String reverseUsingStream1(String s) {
        return IntStream.range(0, s.length())
                .map(i -> s.charAt(s.length() - 1 - i))
                .collect(
                        () -> new StringBuilder(),
                        (sb, c) -> sb.append((char) c), // cast int back to char
                        (builder1, builder2) -> builder1.append(builder2)
                ).toString();
    }

    public static String reverseUsingStream2(String s) {
        // Splitting into a Stream of Strings allows a single-argument collect!
        return Stream.of(s.split(""))
                .reduce("", (reversedStr, character) -> character + reversedStr);
    }

    public static void main(String[] args) {
        System.out.println(reverse("listen"));
        System.out.println(reverseUsingStringBuilder("listen"));
    }
}
