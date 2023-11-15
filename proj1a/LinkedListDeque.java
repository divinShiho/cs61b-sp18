public class LinkedListDeque<T> {

    public static class Node<T> {
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>(null, null, null);
        sentinel.next = sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        this.sentinel = other.sentinel;
        this.size = other.size;
    }

    public void addFirst(T item) {
        size += 1;
        Node p = sentinel;
        while (p.prev != sentinel) {
            p.prev = p;
        }

        p.prev = new Node<>(item, sentinel, p);
        sentinel.next = p.prev;
    }

    public void addLast(T item) {
        size += 1;
        Node p = sentinel;
        while (p.next != sentinel) {
            p.next = p;
        }

        p.next = new Node<>(item, p, sentinel);
        sentinel.prev = p.next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + (p.next==sentinel ? "\n" : " "));
            p = p.next;
        }
    }

    public T removeFirst() {
        size = Math.max(size-1, 0);
        T item = (T) sentinel.next.item;
        Node p = sentinel.next;
        sentinel.next = p.next;
        p.next.prev = sentinel;
        return item;
    }

    public T removeLast() {
        size = Math.max(size-1, 0);
        T item = (T) sentinel.prev.item;
        Node p = sentinel.prev;
        sentinel.prev = p.prev;
        p.prev.next = sentinel;
        return item;
    }

    public T get(int index) {
        Node p = sentinel.next;
        int i = 0;
        while (i++ < index) {
            p = p.next;
        }
        return (T) p.item;
    }

    private T findByIdx(int index, Node n) {
        return index == 0 ? (T) n.item : findByIdx(index-1, n.next);
    }

    public T getRecursive(int index) {
        return findByIdx(index, sentinel.next);
    }

}
