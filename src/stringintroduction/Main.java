package stringintroduction;


import stringintroduction.util.StringUtil;

public class Main {
    public static void main(String[] args) {
        String a = "hello";
        String b = "java";

        int sum = StringUtil.sumOfLengths(a,b);
        System.out.println("Sum of \"String a\" and \"String b\" lengths is : " + sum);

        String isLarger = StringUtil.isLarger(a,b);
        System.out.println("Is \"String a\" larger than \"String b\"? : " + isLarger);

        String capitalized = StringUtil.capitalize(a,b);
        System.out.println("Capitalized and merged strings : " + capitalized);
    }
}
