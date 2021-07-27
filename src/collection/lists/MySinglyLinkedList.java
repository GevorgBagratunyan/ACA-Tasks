package collection.lists;

public class MySinglyLinkedList<T> {

    private static int mainIndex = 0;
    private int size = 0;
    private Node<T> first;
    private Node<T> last;


    public void addFirst(T item) {
        if (item == null) {
            throw new NullPointerException("The argument for addFirst() is null.");
        }
        first = new Node<>(item, first);
        if (isEmpty()) {
            last = first;
        }
        size++;
    }

    public void addLast(T item) {
        if (item == null) {
            throw new NullPointerException("The argument for addLast() is null.");
        }
        if (size == 0) {
            last = new Node(item, null);
            first = last;
        } else {
            Node prev = last;
            last = new Node(item, null);
            prev.next = last;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removed = first.obj;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return removed;
    }

    public T removeElement(T t) {
        Node<T> current = first;
        Node<T> previous = first;
        while (current != null && !current.equals(t)) {
            previous = current;
            current = current.next;
        }
        if(current == null){
            return null;
        } else if (first == current) {
            first = current.next;
        } else if (last == current) {
            last = previous;
            last.next = null;
        } else {
            previous.next = current.next;
        }
        size--;
        return current.obj;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }


    private static class Node<T> {
        private T obj;
        private Node<T> next;
        private int index;

        Node(T obj, Node<T> next) {
            this.obj = obj;
            this.next = next;
            this.index = mainIndex++;
        }

    }

}
