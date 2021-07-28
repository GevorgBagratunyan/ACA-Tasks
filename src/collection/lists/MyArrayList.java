package collection.lists;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    private T[] array;
    private int capacity;
    private int size = 0;
    private int index = 0;
    private final static int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void add(int index, T obj) {
        checkCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1,
                size - index);
        array[index] = obj;
        this.size++;
    }

    public void add(T obj) {
        checkCapacity(size + 1);
        array[size++] = obj;
    }

    public T get(int index) {
        checkIndexValidity(index);
        return array[index];
    }

    public T set(int index, T obj) {
        checkIndexValidity(index);
        T old = array[index];
        array[index] = obj;
        return old;
    }

    public T remove(int index) {
        checkIndexValidity(index);
        T removed = array[index];
        System.arraycopy(array, index + 1, array, index,
                size - index);
        size--;
        return removed;
    }

    public boolean remove(T obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i,
                        capacity - i);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T obj) {
        return indexOf(obj) >= 0;
    }

    public int indexOf(T obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return this.size;
    }

    private void checkIndexValidity(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index + " is greater than size of list");
        }
    }

    private void checkCapacity(int size) {
        if (capacity < size) {
            expand();
        }
    }

    private void expand() {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        array = Arrays.copyOf(array, newCapacity);
    }

    //Implementing Iterable interface
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (index >= array.length) {
                    return false;
                } else return array[index] != null;


            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }
}
