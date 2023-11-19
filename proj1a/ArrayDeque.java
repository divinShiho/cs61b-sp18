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
        if (firstIndex == -1) {
            firstIndex = lastIndex = 0;
            items[firstIndex] = item;
            return;
        }
        firstIndex = firstIndex-1 < 0 ? 7 : firstIndex-1;
        items[firstIndex] = item;
        size++;
    }

    public void addLast(T item) {
        if (firstIndex == -1) {
            firstIndex = lastIndex = 0;
            items[lastIndex] = item;
            return;
        }
        lastIndex = (lastIndex + 1) % 8;
        items[lastIndex] = item;
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
        T item = items[firstIndex];
        firstIndex = (firstIndex + 1) % 8;
        size--;
        return item;
    }

    public T removeLast() {
        T item = items[lastIndex];
        lastIndex = lastIndex-1 < 0 ? 7 : lastIndex-1;
        size--;
        return item;
    }

    public T get(int i) {
        return items[i];
    }




}
