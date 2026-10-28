package io.devzona.interview_practices.java8;

interface GrandParent {
    default void fun() {
        System.out.println("GrandParent");
    }

    static void enjoy() {
        System.out.println("GrandParent enjoy");
    }
}

interface Parent1 extends GrandParent {

    default void fun() {
        System.out.println("Parent1");
    }

    static void enjoy() {
        System.out.println("Parent1 enjoy");
    }
}

interface Parent2 extends GrandParent  {
    default void fun() {
        System.out.println("Parent2");
    }

    static void enjoy() {
        System.out.println("Parent2 enjoy");
    }
}

// Inherting the Properties from Both the classes
public class TestMultipleInheritance implements Parent1, Parent2 {
    // main function
    public static void main(String[] args) {
        TestMultipleInheritance t = new TestMultipleInheritance();
        t.fun();
    }

    @Override
    public void fun() {
        Parent1.super.fun();
    }
}
