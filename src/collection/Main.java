package collection;


import collection.lists.MyArrayList;
import collection.lists.MySinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        //Testing singly linked list
        MySinglyLinkedList<String> singlyList = new MySinglyLinkedList<>();
        singlyList.addLast("One");
        singlyList.addLast("Two");
        singlyList.addLast("Three");
        singlyList.addFirst("Four");
        singlyList.addFirst("Five");
        singlyList.addFirst("Six");

        System.out.println("Size of singlyList after adding items is : " + singlyList.size());
        System.out.println("Removing..... " + singlyList.removeElement("One"));
        System.out.println("Size of singlyList after deleting one item is : " + singlyList.size());
        System.out.println("printing items in LinkedList");
        for (String s : singlyList) {
            System.out.println(s);
        }
        while (!singlyList.isEmpty()) {
            singlyList.removeFirst();
        }
        System.out.println("Size of singlyList after removing items is : " + singlyList.size());


        //Testing  own array list
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        arrayList.add(1, "Four");
        arrayList.add(0, "Five");
        arrayList.add(2, "Six");

        System.out.println("printing items in ArrayList");
        for (String s : arrayList) {
            System.out.println(s);
        }

        arrayList.remove(3);
        System.out.println("printing items in ArrayList after removing one element");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }
}
