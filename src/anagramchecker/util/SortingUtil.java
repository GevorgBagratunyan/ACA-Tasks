package anagramchecker.util;

public class SortingUtil {

    private SortingUtil() {
    }

    public static void insertionSort(char[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                swap(array, i, i - 1);
            }
        }

        for (int i = 2; i < array.length; i++) {
            char temp = array[i];
            int j = i;
            while (temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
