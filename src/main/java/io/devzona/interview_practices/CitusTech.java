package io.devzona.interview_practices;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CitusTech {

    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        System.out.println(listOfStrings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));

        List<String> listOfStringss = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        System.out.println(listOfStringss.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().min((o1, o2) -> o2.getValue().compareTo(o1.getValue())).orElse(null).getKey());
    }
}
