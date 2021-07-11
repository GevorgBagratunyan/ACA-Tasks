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

        char[] arr1 = a.toLowerCase().toCharArray();
        char[] arr2 = b.toLowerCase().toCharArray();

        SortingUtil.insertionSort(arr1);
        SortingUtil.insertionSort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean isAnagramGeneric(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        Character[] arr1 = initArray(a.toLowerCase());
        Character[] arr2 = initArray(b.toLowerCase());

        util.insertionSort(arr1);
        util.insertionSort(arr2);

        return Arrays.equals(arr1, arr2);
    }


    private static Character[] initArray(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = Character.valueOf(s.charAt(i));
        }
        return chars;
    }

}
