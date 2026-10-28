package io.devzona.interview_practices.company;

public class JPMC {

    private static JPMC jpmc = null;

    static {
        jpmc = new JPMC();
    }

    public static JPMC getJpmc() {
        return jpmc;
    }

    public static void main(String[] args) {
        String name = "Rohit";
        print(name, 5);
    }

    public static void print(String name, int times) {
        if (times > 1) {
            print(name, --times);
        }
        System.out.println(name);
    }
}
