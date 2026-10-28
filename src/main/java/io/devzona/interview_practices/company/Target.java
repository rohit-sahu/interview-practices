package io.devzona.interview_practices.company;

import lombok.Data;

import java.util.*;

/**
 * Subtract 2 largest element and generate a new set of array
 *
 * [ 2, 3, 4,5,7]
 * [2,3,4,2]
 * [2,1,2]
 * [1]
 */
public class Target {

    public static Integer getWeight(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        while (!queue.isEmpty() & queue.size() > 1) {
            queue.add(queue.poll() - (Objects.nonNull(queue.poll()) ? queue.poll() : 0));
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(getWeight(new int[]{2, 3, 4,5,7}));
        List<Players> players = new ArrayList<>();
        players.stream().sorted((o1, o2) -> {
            int c = o2.getRank().compareTo(o1.getRank());
            if (c == 0) {
                c = o2.getAge().compareTo(o1.getAge());
            }
            return c;
        }).forEach(System.out::println);
    }
}

@Data
class Players {
    private Integer age;
    private Integer rank;
}
