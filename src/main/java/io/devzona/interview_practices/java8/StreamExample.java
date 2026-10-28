package io.devzona.interview_practices.java8;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList();
        integerList.add(123);
        integerList.stream().forEach(t -> {
            System.out.println(t);
        });

        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setCity("Mumbai");
        student.setMarks(200);
        student.setName("Name");

        Student student2 = new Student();
        student2.setId(1);
        student2.setAge(30);
        student2.setCity("Mumbai");
        student2.setMarks(100);
        student2.setName("Name");

        Student student3 = new Student();
        student3.setId(1);
        student3.setAge(40);
        student3.setCity("Mumbai");
        student3.setMarks(200);
        student3.setName("Name");

        students.add(student2);
        students.add(student3);
        students.add(student);
        students.stream().filter(Objects::nonNull).sorted((o1, o2) -> o1.getMarks().compareTo(o2.getMarks())).filter(s -> s.getCity().equals("Mumbai")).collect(Collectors.toList());
        students.stream().sorted((o1, o2) -> {
            int v = o1.getMarks().compareTo(o2.getMarks());
            if (v == 0) {
                return o1.getAge().compareTo(o2.getAge());
            }
            return v;
        }).filter(s -> s.getCity().equals("Mumbai")).toList();

        List<Student> sortedStudent = students.stream().filter(Objects::nonNull).sorted(Comparator.comparing(Student::getMarks).thenComparingInt(Student::getAge)).toList();

        students.stream().sorted(Comparator.comparing(Student::getMarks)).filter(s -> s.getCity().equals("Mumbai")).collect(Collectors.toList());

        List<Student> students1 = new ArrayList<>(students);
        students.stream().filter(students1::contains).toList();
    }
}

@Data
class Student {
    private int id;
    private String name;
    private Integer marks;
    private String city;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

interface I1 {
    default String getGreeting() {
        return "Good Morning!";
    }

    default String getGreeting2() {
        return "Good Morning!";
    }
}
