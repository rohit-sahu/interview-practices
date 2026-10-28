package io.devzona.interview_practices.company;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;

public class JLL {
    public static void main(String[] args) {
        List<EmployeeDto> employeeDtos = List.of();
        employeeDtos.stream().sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).findFirst().orElse(null);
        Map<String, Set<EmployeeDto>> groupedEmp = employeeDtos.stream().collect(Collectors.groupingBy(EmployeeDto::getDepartmentName, Collectors.toSet()));
        groupedEmp.values().forEach(employeeDtos1 -> {
            EmployeeDto e = employeeDtos1.stream().sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).findFirst().orElse(null);
            System.out.println("DEpartment Name : " + e.getDepartmentName() + "->" + e.getSalary());
        });
    }
}

@Data
@EqualsAndHashCode
class EmployeeDto {
    private Integer id;
    private String name;
    private String departmentName;
    private Double salary;

    public static EmployeeDto builder() {
        return new EmployeeDto();
    }
}