package io.devzona.interview_practices;

import java.util.Arrays;
import java.util.Comparator;

public class Test5 {

    /**
     * ["The Lord of the Rings", "A Game of Thrones", "Ancillary Justice", "1984"]
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = new String[]{"The Lord of the Rings", "A Game of Thrones", "Ancillary Justice", "1984"};
        Arrays.stream(arr).map(s -> {
            String[] a = s.split(" ");
            if (a[0].equals("A") || a[0].equals("The") || a[0].equals("An")) {
                return s.replaceFirst(a[0] + " ", "");
            } else {
                return s;
            }
        }).sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }
}
