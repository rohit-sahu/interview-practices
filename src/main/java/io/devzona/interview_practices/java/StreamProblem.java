package io.devzona.interview_practices.java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamProblem {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Asha",  "IT", 90000, 30),
                new Employee("Ravi",  "IT", 70000, 25),
                new Employee("Neha",  "HR", 50000, 28),
                new Employee("Karan", "HR", 65000, 35),
                new Employee("Mira",  "Finance", 80000, 40)
        );
        //Find the even numbers from a list and square them
        System.out.println("==============Find the even numbers from a list and square them===============");
        List<Integer> result = List.of(1, 2, 3, 4, 5, 6).stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> integer * integer)
                .toList();
        System.out.println(result);
        //Find the sum and average of a list of integers.
        System.out.println("==============Find the sum and average of a list of integers.===============");
        List<Integer> nums = List.of(10, 20, 30);
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        double average = nums.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println(average);
        //Find the highest-paid employee.
        System.out.println("=================Find the highest-paid employee.========================");
        Employee employee = employees.stream()
                .sorted((e1, e2) -> e2.salary() > e1.salary() ? 1 : -1)
                .findFirst()
                .get();
        System.out.println(employee);
        Employee e = employees.stream()
                .max(Comparator.comparing(Employee::salary))
                .get();
        System.out.println(e);
        //Find the second highest salary.
        System.out.println("===============Find the second highest salary Employee.========================");
        Employee employeeSecond = employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(employeeSecond);
        // Group employees by department.
        System.out.println("===================Group employees by department.=======================");
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept));
        System.out.println(byDept);
        // Count employees in each department.
        System.out.println("================Count employees in each department.======================");
        Map<String, Long> count = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept,  Collectors.counting()));
        System.out.println(count);
        // Find the average salary per department.
        System.out.println("===================Find the average salary per department.=====================");
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.averagingDouble(Employee::salary)));
        System.out.println(avgSalary);
        // Find the highest-paid employee in each department.
        System.out.println("===================Find the highest-paid employee in each department.=====================");
        Map<String, Optional<Employee>> topPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::dept, Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println(topPerDept);
        // Partition employees into salary above 60000 and the rest.
        System.out.println("===================Partition employees into salary above 60000 and the rest.======================");
        Map<Boolean, List<Employee>> parts = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.salary() > 60000));
        System.out.println(parts);
        // Join all employee names into one comma-separated string.
        System.out.println("=============Join all employee names into one comma-separated string.===================");
        String names = employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(names);
        // Convert a list of employees to a Map of name to salary.
        System.out.println("================Convert a list of employees to a Map of name to salary.===================");
        Map<String, Double> map = employees.stream()
                .collect(Collectors.toMap(Employee::name, Employee::salary));
        System.out.println(map);
        // Find duplicate elements in a list.
        System.out.println("==================Find duplicate elements in a list.===================");
        List<Integer> list = List.of(1, 2, 3, 2, 4, 3, 5);
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = list.stream()
                .filter(integer -> !seen.add(integer))
                .collect(Collectors.toSet());
        System.out.println(duplicates);
        // Find the first non-repeating character in a string.
        System.out.println("================Find the first non-repeating character in a string.=====================");
        String s = "swiss";
        Character nonRepeatingCharacter = s.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(nonRepeatingCharacter);
        // Count the frequency of each word.
        System.out.println("==============Count the frequency of each word.====================");
        String text = "java is fun and java is powerful";
        Map<String, Long> freq = Arrays.stream(text.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);
        //Check whether a string is a palindrome.
        System.out.println("================Check whether a string is a palindrome.================");
        boolean isPalindrome = IntStream.range(0, s.length() / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));
        System.out.println(isPalindrome);
        // Get the top 3 highest salaries.
        System.out.println("=============Get the top 3 highest salaries.===============");
        List<Double> top3 = employees.stream()
                .map(Employee::salary)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println(top3);
        // Flatten a list of lists and remove duplicates, sorted.
        System.out.println("=============Flatten a list of lists and remove duplicates, sorted.=================");
        List<List<Integer>> lists = List.of(List.of(3, 1), List.of(2, 3), List.of(5, 1));
        List<Integer> resultFlat = lists.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();     // [1, 2, 3, 5]
    }
}

record Employee(String name, String dept, double salary, int age) {}
