package collection.iteratiors;

import collection.lists.MyArrayList;

import java.util.Iterator;

public class MyArrayListIterator<T> implements Iterator<T> {
    MyArrayList list;
    int index = 0;

    public MyArrayListIterator(MyArrayList arrayList) {
       list = arrayList;
    }

    @Override
    public boolean hasNext() {
        if(index>=list.size()){
            return false;
        }else return list.get(index) != null;


    }

    @Override
    public T next() {
        return (T) list.get(index++);
    }
}
