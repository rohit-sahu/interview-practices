package io.devzona.interview_practices;

public class LargeNumber {

    public static String addLargeNumber(String a, String b) {
        int carry = 0;
        String sum = "";
        int l1 = a.length();
        int l2 = b.length();
        while (l1 > 0 || l2 > 0) {
            int m = l1 > 0 ? Integer.parseInt(a.charAt(l1 - 1) + "") : 0;
            int n = l2 > 0 ? Integer.parseInt(b.charAt(l2 - 1) + "") : 0;
            int s = m + n + carry;
            if (s >= 10) {
                carry = s / 10;
                sum = (s % 10) + sum;
            } else {
                sum = s + sum;
                carry = 0;
            }
            l1--;
            l2--;
        }
        if (carry > 0) {
            sum = carry + sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addLargeNumber("1000", "20"));
        System.out.println(addLargeNumber("1000", "200"));
        System.out.println(addLargeNumber("1100", "1900"));

        String num1 = "123456789012345678901234567890";
        String num2 = "987654321098765432109876543210";
        String num3 = "1111111110111111111011111111100";
        System.out.println(addLargeNumber(num1, num2));
        System.out.println(addLargeNumber("1", "5"));
        System.out.println(addLargeNumber("301", "5"));
        assert addLargeNumber("301", "5").equals("306");


//        assertAdd("1", "5", "6");
//        assertAdd("301", "5", "306");

    }


}
