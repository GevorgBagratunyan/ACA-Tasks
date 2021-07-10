package anagramchecker.util;

import java.util.Arrays;

public class StringUtil {

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

}
