package dev.alexengrig.structures.heap;

import dev.alexengrig.structures.annotation.O;

import java.util.Arrays;

public class IntMinBinaryHeap implements IntMinHeap {
    protected static final int DEFAULT_CAPACITY = 15;

    protected int size;
    protected Node[] array;

    public IntMinBinaryHeap() {
        this.size = 0;
        this.array = new Node[DEFAULT_CAPACITY];
    }

    @O("1")
    @Override
    public int size() {
        return size;
    }

    @O("1")
    @Override
    public boolean empty() {
        return size == 0;
    }

    @O("log(n)")
    @Override
    public Pointer insert(int value) {
        if (size >= array.length) grow();
        int index = size++;
        Node node = new Node(value, index);
        array[index] = node;
        siftUp(index);
        return node.pointer;
    }

    protected void grow() {
        array = Arrays.copyOf(array, array.length * 2 + 1);
    }

    @O("log(n)")
    @Override
    public int extract(Index index) {
        requireValidIndex(index);
        decrease(index, value(0) - 1);
        return extractMin();
    }

    @O("1")
    @Override
    public int min() {
        requireNonEmpty();
        return value(0);
    }

    @O("log(n)")
    @Override
    public int extractMin() {
        requireNonEmpty();
        Node node = node(0);
        node.pointer.removed = true;
        swap(0, --size);
        siftDown(0);
        return node.value;
    }

    @O("log(n)")
    @Override
    public int decrease(Index index, int newValue) {
        requireValidIndex(index);
        Node node = node(index.get());
        if (newValue >= node.value) {
            throw new IllegalArgumentException(
                    String.format("The new value must be less than the current value: %d >= %d",
                            newValue, node.value));
        }
        int target = node.value;
        node.value = newValue;
        siftUp(node.pointer.index);
        return target;
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyHeapException();
    }

    protected void requireValidIndex(Index index) {
        if (!index.valid()) throw new InvalidHeapIndexException();
    }

    protected void swap(int from, int to) {
        Node temp = array[from];
        array[from] = array[to];
        array[from].setIndex(from);
        array[to] = temp;
        array[to].setIndex(to);
    }

    protected void siftUp(int index) {
        int child = index;
        int parent = parent(child);
        while (child > 0 && value(child) <= value(parent)) {
            swap(child, parent);
            child = parent;
            parent = parent(child);
        }
    }

    @SuppressWarnings("SameParameterValue")
    protected void siftDown(int index) {
        int parent = index;
        int left = left(parent);
        int right = right(parent);
        while ((left < size && value(left) <= value(parent)) || (right < size && value(right) <= value(parent))) {
            if (value(left) >= value(right)) {
                swap(parent, right);
                parent = right;
            } else {
                swap(parent, left);
                parent = left;
            }
            left = left(parent);
            right = right(parent);
        }
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected int left(int index) {
        return index * 2 + 1;
    }

    protected int right(int index) {
        return index * 2 + 2;
    }

    protected int value(int index) {
        return array[index].value;
    }

    protected Node node(int index) {
        return array[index];
    }

    protected class Node {
        protected int value;
        protected Pointer pointer;

        protected Node(int value, int index) {
            this.value = value;
            this.pointer = new Pointer(index);
        }

        protected void setIndex(int index) {
            this.pointer.index = index;
        }

        @Override
        public String toString() {
            return String.format("Node(%d: %d%s)", pointer.index, value, pointer.removed ? " - REMOVED" : "");
        }
    }

    public class Pointer implements Index {
        protected int index;
        protected boolean removed;

        public Pointer(int index) {
            this.index = index;
        }

        @Override
        public int get() {
            return index;
        }

        @Override
        public boolean valid() {
            return !removed && index >= 0 && index < size;
        }
    }
}
