package io.devzona.interview_practices.java8;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HeroMoto {
    public static void main(String[] args) {
//        List<Employe> employees = new ArrayList<>();
//        employees.stream().sorted(Comparator.comparing(Employe::getName)).toList();
//        employees.stream().peek(employe -> employe.setSalary(employe.getSalary() + (employe.getSalary() * 10) / 100)).toList();
//        employees.stream().collect(Collectors.groupingBy(Employe::getDepartment));

        Integer[] arr = {2, 1, 2, 4, 2, 4, 5, 3};
        System.out.println(Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).findFirst().orElse(null).getKey());
    }
}

@Data
class Employe {
    private String name;
    private Integer salary;
    private Integer department;
}
