package io.devzona.interview_practices.company;


/**
 *
 * Write a function, add, which adds two large numbers together and returns their sum:
 * // Returns sum of two numbers
 * String add(String a, String b)
 * - Inputs to the add function are two numbers, represented as strings
 *
 * - Output of the add function is a single string representing the sum of the inputs
 * - Only positive integers need to be supported
 * - Input numbers can be very large, with 100 digits or more.
 * - This negates the ability to convert the entirety of the strings to integers and simply add.
 *
 * Large integer test
 * assertAdd("8944394323791464", "14472334024676221", "23416728348467685");
 *
 *
 * Large numbers should include separators every 3 digits for readability, ( comma ‘,’ is
 * preferred)
 *
 * Share below information with candidate only if they ask for specific additional information or related
 * queries
 * ● Previous test cases with output > 999 are allowed to fail due to missing commas
 * ● Formatting should be for a US audience (ex: 1,000,000); European number formatting (ex:
 * 1.000.000) need not be supported
 *
 * assertAdd("8,944,394,323,791,464", "14,472,334,024,676,221",
 * "23,416,728,348,467,685");
 *
 */
public class Test123 {

    public static String add(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        int aL = a.length();
        int bL = b.length();
        while (aL > 0 || bL > 0) {
            int f = Integer.parseInt(aL > 0 ? a.charAt(aL - 1) + "" : "0");
            int s = Integer.parseInt(bL > 0 ? b.charAt(bL - 1) + "" : "0");
            int sum = f + s + carry;
            carry = sum / 10;
            sum = sum % 10;
            builder.insert(0, sum);
//            if (aL % 3 == 0 || bL % 3 == 0) {
//                builder.insert(0, ",");
//            }
            aL--;
            bL--;
        }
        if (carry > 0) {
            builder.insert(0, carry);
        }
        int length = builder.length();
        int counter = 0;
        while (length > 0) {
            if (counter == 3) {
                builder.insert(builder.length() - length, ",");
                counter = 0;
            }
//            else if (length < 3 && counter == 2) {
//                builder.insert(1, ",");
//            } else {
//                builder.insert(0, ",");
//            }
            counter++;
            length--;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(add("8944394323791464", "14472334024676221"));
    }
}
