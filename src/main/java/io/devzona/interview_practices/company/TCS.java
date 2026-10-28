package io.devzona.interview_practices.company;

import lombok.Data;

public class TCS {

    public static void main(String[] args) {
        String a = "ABC";
        String b = new String("ABC");
        if (a.equals(b)) {

        }
    }
}

@Data
class Employee implements Comparable {
    private Integer age;

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee) o;
        return this.getAge().compareTo(employee.getAge());
    }
}

interface Animal {
    default void eat() {
        System.out.println("Grass");
    }
}

interface Pet {
    default void eat() {
        System.out.println("Worms");
    }
}

class Dog implements Animal, Pet {

    @Override
    public void eat() {
        Pet.super.eat();
    }
}
