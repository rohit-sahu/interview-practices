package io.devzona.interview_practices.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3, 7, 8, 1, 5, 9);
        int sum = integers.stream().mapToInt(value -> value).sum();
        System.out.println(sum);

        int reduceSum = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        Optional<Integer> reduceSumWithMethodRef = integers.stream().reduce(Integer::sum);
        System.out.println(reduceSumWithMethodRef.get());

        int multipleResult = integers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(multipleResult);

        int maxValue = integers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxValue);

        int maxValueWithMethodRef = integers.stream().reduce(Integer::max).get();
        System.out.println(maxValueWithMethodRef);

        List<String> strings = Arrays.asList("corejava", "hibernate");

        Optional<String> longestString = strings.stream().reduce((s, s2) -> s.length() > s2.length() ? s : s2);
        System.out.println(longestString.get());

        List<String> list = Arrays.asList("corejava", "hibernate", null);
        Set<String> collected = list.stream().flatMap(Stream::ofNullable).collect(Collectors.toSet());
        System.out.println(collected);

        Stream.iterate(0, integer -> integer < 10, integer -> integer + 2).forEach(System.out::println);
        System.out.println("====================");
        Stream.iterate(0, integer -> integer + 2).limit(10).forEach(System.out::println);

        System.out.println("====================");

        List<Integer> orderedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> integerList = orderedList.stream().takeWhile(integer -> integer < 5).collect(Collectors.toList());
        System.out.println(integerList);

        List<Integer> integerList2 = orderedList.stream().dropWhile(integer -> integer < 5).collect(Collectors.toList());
        System.out.println(integerList2);

        List<Integer> integerList3 = orderedList.stream()
                .dropWhile(integer -> integer < 2)
                .takeWhile(integer -> integer < 7)
                .collect(Collectors.toList());
        System.out.println(integerList3);

        Map<String, Integer> integerMap = integers.stream()
                .collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compareTo),
                        Collectors.minBy(Integer::compareTo),
                        (integer, integer2) -> Map.of("max", integer.get(), "min", integer2.get())));
        System.out.println(integerMap);

        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Stream<Integer> integerStream1 = Stream.of(4, 5, 6);
        int sum1 = Stream.concat(integerStream, integerStream1).mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        Map<Boolean, List<Integer>> listMap = integers.stream().collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        System.out.println(listMap);

        List<Integer> integerList1 = IntStream.range(1, 20).boxed().collect(Collectors.toList());
        System.out.println(integerList1);

        List<Integer> integerList4 = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
        System.out.println(integerList4);
    }

    private static List<String> unquieElements(String input){
        //input.chars().mapToObj(i -> (char)i).map()
        List<String> charList = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey()).collect(Collectors.toList());
        return charList;

    }
}
