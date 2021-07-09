

import sortingalgorithms.DataSorter;

import java.util.Arrays;

public class RunTheTask {
    public static void main(String[] args) {
        int arr1[] = {-3,-3,4,-1,6,8,0,5,-3};
        int arr2[] = {3,3,3,12,-8,2,4,-1,6,8,0,5,-3};


        System.out.println("Array 1 BEFORE sort :\n" + Arrays.toString(arr1));
        DataSorter.insertionSort(arr1);
        System.out.println("Array 1 AFTER sort using -Insertion Sort- :\n" + Arrays.toString(arr1) + "\n");

        System.out.println("Array 2 BEFORE sort :\n" + Arrays.toString(arr2));
        DataSorter.quickSort(arr2,0,arr2.length-1);
        System.out.println("Array 2 AFTER sort using -QuickSort- :\n" + Arrays.toString(arr2) + "\n");

    }
}
