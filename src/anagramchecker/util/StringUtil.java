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

        insertionSort(arr1);
        insertionSort(arr2);

//        Arrays.sort(arr1);
//        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    static void insertionSort(char[] arr) {
        int i, j, key;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
