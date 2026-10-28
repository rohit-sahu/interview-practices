package io.devzona.interview_practices;

import java.util.ArrayList;
import java.util.List;

/**
 * arr = [3,1,2,4]
 *
 * All subarrays = [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 *
 * total=
 * 30
 */
public class NoBroker {

    public static List<List<Integer>> getAllSubArray(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < arr.length; i++) {
//            int k = i;
//            List<Integer> integers = new ArrayList<>();
//            for (int j = i; j <= i || k < arr.length; j++) {
//                integers.add(arr[j]);
//                k++;
//            }
//            list.add(integers);
//        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
//                for (int k = i; k <= i + j; k++) {
//                    System.out.println(arr[k] + ",");
//                }
                System.out.println(arr[j] + ",");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getAllSubArray(new int[]{3,1,2,4}));
    }
}
