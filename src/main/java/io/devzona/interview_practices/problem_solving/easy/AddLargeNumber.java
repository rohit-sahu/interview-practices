package io.devzona.interview_practices.problem_solving.easy;

public class AddLargeNumber {

    public static void main(String[] args) {
        System.out.println(addNumber("123456", "9865434"));
        System.out.println(findSum("123456", "9865434"));
    }

    /**
     * A = 37456187
     * B = 984759271
     *
     * @param a
     * @param b
     * @return
     */
    public static String addNumber(String a, String b) {
        StringBuilder output = new StringBuilder();
        int fCount = a.length();
        int sCount = b.length();
        int carry = 0;
        while (fCount > 0 || sCount > 0) {
            char n1 = fCount > 0 ? a.charAt(fCount - 1) : '0';
            char n2 = sCount > 0 ? b.charAt(sCount - 1) : '0';
            int sum  = Integer.parseInt(n1 + "") + Integer.parseInt(n2 + "") + carry;
            output.insert(0, (sum % 10));
            carry = sum / 10;
            fCount--;
            sCount--;
        }
        if (carry > 0) {
            output.insert(0, carry);
        }
        return output.toString();
    }

    static String findSum(String str1, String str2)
    {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()){
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        String str = "";

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1=new StringBuilder(str1).reverse().toString();
        str2=new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++)
        {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((int)(str1.charAt(i) - '0') +
                    (int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');

            // Calculate carry for next step
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++)
        {
            int sum = ((int)(str2.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str += (char)(carry + '0');

        // reverse resultant String
        str = new StringBuilder(str).reverse().toString();

        return str;
    }
}
