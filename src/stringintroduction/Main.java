package stringintroduction;

import stringintroduction.util.StringAnalyzer;

public class Main {
    public static void main(String[] args) {
        String a = "hello";
        String b = "java";

        int sum = StringAnalyzer.sumOfLengths(a,b);
        System.out.println("Sum of \"String a\" and \"String b\" lengths is : " + sum);

        String isLarger = StringAnalyzer.isLarger(a,b);
        System.out.println("Is \"String a\" larger than \"String b\"? : " + isLarger);

        String capitalized = StringAnalyzer.capitalize(a,b);
        System.out.println("Capitalized and merged strings : " + capitalized);
    }
}
