package io.devzona.interview_practices.company;

import java.util.LinkedList;
import java.util.List;

public class Paytm {

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        numbers.add(9);
        numbers.add(9);
        numbers.add(9);
        addNum(numbers);
        numbers.forEach(System.out::println);
    }

    public static void addNum(List<Integer> num) {
        int carry = 0;
        int length = num.size();
        int index = 1;
        do {
            int n = num.get(length - index);
            int sum = n++;
            if (sum % 10 == 0) {
                carry = 1;
                sum = 0;
                index++;
            }
            num.set(length - index, sum / 10);
        }
        while (carry >= 1 && length - index >= 1);
        if (length - index == 0 && carry > 0) {
            num.addFirst(carry);
        }
    }
}

//9 -> 9 -> 9
