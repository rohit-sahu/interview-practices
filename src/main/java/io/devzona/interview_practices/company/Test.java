package io.devzona.interview_practices.company;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Test {

    public static void main(String[] args) {
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of();
        List<Integer> list3 = List.of();
        List<Integer> list4 = List.of();
//        TreeSet<Integer> set = new TreeSet();
//        set.addAll(list1);
//        set.addAll(list2);
//        set.addAll(list3);
//        set.addAll(list4);
        list1.addAll(list2);
        list1.addAll(list3);
        list1.addAll(list4);
        list1.stream().sorted().toList();
    }
}


