package sortingalgorithms;

import sortingalgorithms.util.ComparableDataSorter;
import sortingalgorithms.util.DataSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Test t1 = new Test(3);
        Test t2 = new Test(378);
        Test t3 = new Test(-32);
        Test t4 = new Test(21);
        Test t5 = new Test(4561);
        Test t6 = new Test(0);
        List<Test> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);

        System.out.print("List BEFORE sort : ");
        for (Test t : list) {
            System.out.print(t.getDigit() + " ");
        }
        System.out.println("\n");

        ComparableDataSorter<Test> sorter = new ComparableDataSorter<>();

        //Comment block 1 or 2 to see result of each sorter algorithm
        //block 1
        sorter.insertionSort(list);
        System.out.print("List AFTER Generic Insertion sort : ");
        for (Test t : list) {
            System.out.print(t.getDigit() + " ");
        }
        System.out.println("\n");

        //block 2
        sorter.quickSort(list,0,list.size()-1);
        System.out.print("List AFTER Generic Quick sort : ");
        for (Test t : list) {
            System.out.print(t.getDigit() + " ");
        }
        System.out.println("\n");

        int arr1[] = {-3, -3, 4, -1, 6, 8, 0, 5, -3};
        int arr2[] = {3, 3, 3, 12, -8, 2, 4, -1, 6, 8, 0, 5, -3};


        System.out.println("Array 1 BEFORE sort :\n" + Arrays.toString(arr1));
        DataSorter.insertionSort(arr1);
        System.out.println("Array 1 AFTER sort using -Insertion Sort- :\n" + Arrays.toString(arr1) + "\n");

        System.out.println("Array 2 BEFORE sort :\n" + Arrays.toString(arr2));
        DataSorter.quickSort(arr2, 0, arr2.length - 1);
        System.out.println("Array 2 AFTER sort using -QuickSort- :\n" + Arrays.toString(arr2) + "\n");

    }
}
