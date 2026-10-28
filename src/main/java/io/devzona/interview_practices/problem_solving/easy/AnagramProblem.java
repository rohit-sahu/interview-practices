package io.devzona.interview_practices.problem_solving.easy;

public class AnagramProblem {

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int[] charCount = new int[26];
        for(int i = 0; i < a.length(); i++) {
            charCount[ca[i] - 'a']++;
            charCount[ca[i] - 'a']--;
        }
        for(int i = 0; i < charCount.length; i++) {
            if(charCount[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Is Anagram : " + isAnagram("listen", "silent"));
    }
}
