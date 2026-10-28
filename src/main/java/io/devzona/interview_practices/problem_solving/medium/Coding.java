package io.devzona.interview_practices.problem_solving.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Move zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 */
public class Coding {

    public static List<Integer> moveZerosToEnd(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int zerosCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zerosCount++;
            } else {
                list.add(arr[i]);
            }
        }
        if (zerosCount > 0) {
            for (int i = 0; i < zerosCount; i++) {
                list.add(0);
            }
        }
        return list;
    }

    public static int[] moveZerosToEndApproach2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        moveZerosToEnd(new int[] {0,1,0,3,12}).forEach(System.out::println);
        System.out.println("Approach 2");
        Arrays.stream(moveZerosToEndApproach2(new int[] {0,0,0,1,0,3,12})).forEach(System.out::println);

        //Input  a1bcd11cj2:
        //output abcdbcdbcdbcdbcdbcdbcdbcdbcdbcdbcdcjcj


        String str = "a1bcd11cj2";
        char[] chars = str.toCharArray();
//        Pattern pattern = Pattern.compile("\d");
//        str.split("")
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append(chars[i]);
            try {
                Integer num = Integer.parseInt(chars[i] + "");
                if (num.intValue() > 0) {
                    for (int j = 0; j < num; j++) {
                        stringBuffer.append(chars[i - 1]);
                    }
                }
            } catch (Exception e) {

            }
        }
        System.out.println(stringBuffer.toString());
    }
}
