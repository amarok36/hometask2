public class MyHashSet<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<E>[] table;
    private int size;

    private static class Node<E> {
        final E key;
        Node<E> next;

        Node(E key, Node<E> next) {
            this.key = key;
            this.next = next;
        }
    }

    public MyHashSet() {
        table = (Node<E>[]) new Node[DEFAULT_CAPACITY];
    }


    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Пустые элементы не допускаются");
        }

        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(element);
        Node<E> current = table[index];

        while (current != null) {
            if (current.key.equals(element)) {
                return false;
            }
            current = current.next;
        }

        table[index] = new Node<>(element, table[index]);
        size++;
        return true;
    }

    public boolean remove(E element) {
        int index = getIndex(element);
        Node<E> current = table[index];
        Node<E> prev = null;

        while (current != null) {
            if (current.key.equals(element)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    private int getIndex(E element) {
        return Math.abs(element.hashCode()) % table.length;
    }

    private void resize() {
        Node<E>[] oldTable = table;
        table = (Node<E>[]) new Node[oldTable.length * 2];
        size = 0;

        for (Node<E> node : oldTable) {
            while (node != null) {
                add(node.key);
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        boolean first = true;

        for (Node<E> node : table) {
            while (node != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(node.key);
                first = false;
                node = node.next;
            }
        }

        sb.append("]");
        return sb.toString();
    }
}