package anagramchecker;

import anagramchecker.util.AnagramChecker;

public class Main {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Java";

        String c = "ARmenIan CoDE ACAdemy";
        String d = "ARMENIAN code acaDEMY";

        boolean isAnagrams1 = AnagramChecker.isAnagram(a,b);
        boolean isAnagrams2 = AnagramChecker.isAnagram(c,d);

        printResult(a,b,isAnagrams1);
        printResult(c,d,isAnagrams2);


    }

    static void printResult(String s1, String s2, boolean isAnagrams){
        System.out.println("String \"" +s1 + "\" and String \"" + s2 + "\" are "
                + (isAnagrams ? "Anagrams" : "Not Anagrams"));
    }
}
