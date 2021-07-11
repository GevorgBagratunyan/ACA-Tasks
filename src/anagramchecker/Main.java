package anagramchecker;

import anagramchecker.util.GenericArrayUtil;
import anagramchecker.util.StringUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "Java";

        String c = "ARmenIan CoDE ACAdemy";
        String d = "menARiAn cedo acaDEMY";

        boolean isAnagrams1 = StringUtil.isAnagram(a, b);
        boolean isAnagrams2 = StringUtil.isAnagram(c, d);

        printResult(a, b, isAnagrams1);
        printResult(c, d, isAnagrams2);


        //Same actions using generic array class
        //_______________________________________________________________
        boolean isAnagrams3 = StringUtil.isAnagramGeneric(a, b);
        boolean isAnagrams4 = StringUtil.isAnagramGeneric(c, d);
        printResult(a, b, isAnagrams3);
        printResult(c, d, isAnagrams4);
    }

    private static Character[] initArray(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = Character.valueOf(s.charAt(i));
        }
        return chars;
    }

    static void printResult(String s1, String s2, boolean isAnagrams) {
        System.out.println("String \"" + s1 + "\" and String \"" + s2 + "\" are "
                + (isAnagrams ? "ANAGRAMS" : "NOT ANAGRAMS"));
    }
}
