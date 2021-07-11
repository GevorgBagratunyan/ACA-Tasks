package anagramchecker.util;

import java.util.Arrays;

public class StringUtil {

    private static GenericArrayUtil<Character> util = new GenericArrayUtil<>();

    private StringUtil() {
    }

    public static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        String aLow = a.toLowerCase();
        String bLow = b.toLowerCase();

        char[] arr1 = aLow.toCharArray();
        char[] arr2 = bLow.toCharArray();

        SortingUtil.insertionSort(arr1);
        SortingUtil.insertionSort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagramGeneric(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        Character[] chars1 = initArray(a.toLowerCase());
        Character[] chars2 = initArray(b.toLowerCase());

        util.setElements(chars1);
        util.insertionSort();
        util.setElements(chars2);
        util.insertionSort();

        return Arrays.equals(chars1, chars2);
    }


    private static Character[] initArray(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = Character.valueOf(s.charAt(i));
        }
        return chars;
    }

}
