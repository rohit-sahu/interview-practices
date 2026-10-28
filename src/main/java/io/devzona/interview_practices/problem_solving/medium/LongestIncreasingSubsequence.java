package io.devzona.interview_practices.problem_solving.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > list.getLast()) {
                list.add(nums[i]);
            } else {
                int index = Collections.binarySearch(list, nums[i]);
                if(index < 0) {
                    index = -index - 1;
                }
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        //lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
