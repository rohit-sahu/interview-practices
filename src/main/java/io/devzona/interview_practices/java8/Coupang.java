package io.devzona.interview_practices.java8;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//future & completablefuture, saga, core java, solid, design patterns, without @SpringBootApplication can we create spring boot application, observable design pattern
public class Coupang {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(Employee.builder().id(1).name("name1").salary(100).build());
        list.add(Employee.builder().id(2).name("name2").salary(300).build());
        list.add(Employee.builder().id(3).name("name3").salary(400).build());
        Employee employee = list.stream().sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).limit(2).toList().get(1);
        System.out.println(employee.getSalary());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> futureResult = executor.submit(() -> {
            // Simulating a long-running task
            TimeUnit.SECONDS.sleep(2);
            return 42; // The result of the computation
        });
    }
}

@Data
@Builder
class Employee {
    private int id;
    private String name;
    private Integer salary;
}

class Customer implements Cloneable {
    private static Customer customer = null;
    private Customer() {
    }
    static {
        customer = new Customer();
    }

    public static Customer getCustomer() {
        return customer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this;
    }
}

@Data
class Node {
    private int data;
    private Node nextNode;
}

@Data
class LinkedList {
     private Node head;

     public Node addData(int data) {
         Node node = new Node();
         node.setData(data);
         node.setNextNode(null);
         return node;
     }
}


