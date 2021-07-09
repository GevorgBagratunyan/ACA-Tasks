package sortingalgorithms;

public class DataSorter {

    private DataSorter(){}

    //Insertion Sort
    //___________________________________________________________________________
    public static void insertionSort(int[] arr) {
        int i, j, key, temp;
        for (i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }

    //QuickSort
    //___________________________________________________________________________
    private static int partition(int intArray[], int low, int high) {
        int pi = intArray[high];
        int i = (low-1); // smaller element index
        for (int j=low; j<high; j++) {
            // check if current element is less than or equal to pi
            if (intArray[j] <= pi) {
                i++;
                // swap intArray[i] and intArray[j]
                int temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
            }
        }

        // swap intArray[i+1] and intArray[high] (or pi)
        int temp = intArray[i+1];
        intArray[i+1] = intArray[high];
        intArray[high] = temp;

        return i+1;
    }


    //routine to sort the array partitions recursively
    public static void quickSort(int intArray[], int low, int high) {
        if (low < high) {
            //partition the array around pi=>partitioning index and return pi
            int pi = partition(intArray, low, high);

            // sort each partition recursively
            quickSort(intArray, low, pi-1);
            quickSort(intArray, pi+1, high);
        }
    }
}
