import insertionsort.InsertionSort;
import quicksort.QuickSort;

import java.util.Arrays;

public class RunTheTask {
    public static void main(String[] args) {
        int arr1[] = {4,-1,6,8,0,5,-3};
        int arr2[] = {3,3,3,4,-1,6,8,0,5,-3};

        QuickSort qs = new QuickSort();
        qs.quickSort(arr1,0,arr1.length-1);

        InsertionSort is = new InsertionSort();
        is.insertionSort(arr2);


        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
