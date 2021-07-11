package anagramchecker.util;

public class GenericArrayUtil<E> {
    private E[] elements;

    public E[] insertionSort(E[] array) {
        elements=array;
        int n = elements.length;
        for (int j = 1; j < n; j++) {
            E key = elements[j];
            int i = j - 1;
            while ((i > -1) && (String.valueOf(elements[i]).compareTo(String.valueOf(key))) > 0) {
                elements[i + 1] = elements[i];
                i--;
            }
            elements[i + 1] = key;
        }
        return elements;
    }
}