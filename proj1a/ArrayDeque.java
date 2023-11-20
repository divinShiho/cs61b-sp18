import java.lang.reflect.Array;

public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    private T[] createArray(int size) {
        return (T[]) Array.newInstance(Object.class, size);
    }

    public ArrayDeque() {
        size = 0;
        items = createArray(8);
        firstIndex = lastIndex = 0;
    }

    public void addFirst(T item) {
        items[firstIndex] = item;
        firstIndex = firstIndex-1 < 0 ? 7 : firstIndex-1;
        size++;
    }

    public void addLast(T item) {
        items[lastIndex] = item;
        lastIndex = (lastIndex + 1) % 8;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = firstIndex;
        while (i != lastIndex) {

        }
    }

    public T removeFirst() {
        if (size == 0) return null;

        firstIndex = (firstIndex + 1) % 8;
        size--;
        return items[firstIndex];
    }

    public T removeLast() {
        if (size == 0) return null;

        lastIndex = lastIndex-1 < 0 ? 7 : lastIndex-1;
        size--;
        return items[lastIndex];
    }

    public T get(int i) {
        return items[i];
    }




}
