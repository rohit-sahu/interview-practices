package io.devzona.interview_practices.problem_solving.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {

    public static int longestSubStringWithoutRepeatingChar(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int count = Integer.MIN_VALUE;
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        for (r = 0; r < str.length(); r++) {
            while (l < r && set.contains(str.charAt(r))) {
                set.remove(str.charAt(l++));
            }
            set.add(str.charAt(r));
            count = Math.max(count, r - l + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is " + longestSubStringWithoutRepeatingChar(str));
    }
}
