package io.devzona.interview_practices.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCount {

    /**
     * Array of int [10, 15, 8, 17, 15, 16, 12, 17] display the repeated numbers
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 15, 8, 17, 15, 16, 12, 17};

        System.out.println("Approach 1");

        HashMap<Integer, Integer> couHashMap = new HashMap<>();
        Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey).forEach(System.out::println);

        System.out.println("Approach 2");

        Arrays.stream(arr).filter(i -> Collections.frequency(Arrays.stream(arr).toList(), i) > 1).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Approach 3");

        Arrays.stream(arr).forEach(value -> {
            //couHashMap.merge(value, 1, Integer::sum);
            if (couHashMap.get(value) != null) {
                couHashMap.put(value, couHashMap.get(value) + 1);
            } else {
                couHashMap.put(value, 1);
            }
        });
        couHashMap.entrySet().stream()
                .filter(integerIntegerEntry -> integerIntegerEntry.getValue() > 1)
                .map(Map.Entry::getKey).forEach(System.out::println);

        System.out.println("Approach 4");

        Set<Integer> items = new HashSet<>();
        Arrays.stream(arr).filter(integer -> !items.add(integer)).forEach(System.out::println);
    }
}
