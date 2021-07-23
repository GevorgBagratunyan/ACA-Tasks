package sortingalgorithms.util;

import java.util.List;

public class ComparableDataSorter {

    private ComparableDataSorter() {

    }

    //Insertion sort
    //_____________________________________________________________________________________
    public static <T extends Comparable> void insertionSort(List<T> list) {
        T key;
        int i, j;
        for (i = 1; i < list.size(); i++) {
            key = list.get(i);
            j = i - 1;

            while (j >= 0 && key.compareTo(list.get(j)) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }


    //Quick Sort
    //_____________________________________________________________________________________
    private static <T extends Comparable> int partition(List<T> list, int low, int high) {
        T pi = list.get(high);
        int i = (low - 1); // smaller element index
        for (int j = low; j < high; j++) {
            // check if current element is less than or equal to pi
            if (list.get(j).compareTo(pi) <= 0) {
                i++;
                // swap intArray[i] and intArray[j]
                swap(list, i, j);
            }
        }

        // swap intArray[i+1] and intArray[high] (or pi)
        swap(list, i + 1, high);

        return i + 1;
    }

    //routine to sort the array partitions recursively
    public static <T extends Comparable> void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(list, low, high);

            // sort each partition recursively
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private static <T extends Comparable> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
